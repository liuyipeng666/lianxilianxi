package com.example.dadadada.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.baweigame.xmpplibrary.XmppManager;
import com.example.dadadada.R;
import com.example.dadadada.common.MsgUtils;
import com.example.dadadada.common.NetHelper;
import com.example.dadadada.mvvm.model.entity.RegisterCodeEntity;
import com.example.dadadada.mvvm.viewmodel.RegisterCodeViewModel;
import com.example.dadadada.mvvm.model.entity.RegisterEntity;
import com.example.dadadada.mvvm.model.entity.RegisterFanEntity;
import com.example.dadadada.mvvm.viewmodel.RegisterViewModel;
import com.example.net.retrofit.BaseRespEntity;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerName;
    private EditText registerPwd;
    private Button register;
    private ImageView imageFanhui;
    private TextView titleText;
    private EditText registerTextcode;
    private Button registerCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        titleText.setText("注册");
        imageFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        registerCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterCodeViewModel registerCodeViewModel = new RegisterCodeViewModel(RegisterActivity.this);
                String s = registerName.getText().toString();
                registerCodeViewModel.codesss(s).observe(RegisterActivity.this, new Observer<BaseRespEntity<RegisterCodeEntity>>() {
                    @Override
                    public void onChanged(BaseRespEntity<RegisterCodeEntity> registerCodeEntityBaseRespEntity) {
                        RegisterCodeEntity data = registerCodeEntityBaseRespEntity.getData();
                        String data1 = data.getData();
                        registerCode.setText(data1);
                    }
                });
            }
        });
    }

    private void register() {
        //获取
        String name = registerName.getText().toString().trim();
        String pwd = registerPwd.getText().toString().trim();
        NetHelper.doTask(new Runnable() {
            @Override
            public void run() {
                XmppManager.getInstance().getXmppUserManager().createAccount(name,pwd);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MsgUtils.showMsg(RegisterActivity.this,"注册成功");
                    }
                });
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setPhonenumber(name);
        registerEntity.setPwd(pwd);
        if(!name.isEmpty() && !pwd.isEmpty()){
            RegisterViewModel registerViewModel = new RegisterViewModel(this);
            registerViewModel.loginCmd(registerEntity).observe(this, new Observer<BaseRespEntity<RegisterFanEntity>>() {
                @Override
                public void onChanged(BaseRespEntity<RegisterFanEntity> entity) {
                    if (entity != null) {
                        if (entity.getMsg().equals("请求成功")) {
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            registerPwd.getText().clear();
                            Toast.makeText(RegisterActivity.this, "已经存在了，请换个再来铁子", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }else{
            registerPwd.getText().clear();
            Toast.makeText(this, "请输入手机号和密码", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        registerName = (EditText) findViewById(R.id.register_name);
        registerPwd = (EditText) findViewById(R.id.register_pwd);
        register = (Button) findViewById(R.id.register);
        imageFanhui = (ImageView) findViewById(R.id.image_fanhui);
        titleText = (TextView) findViewById(R.id.title_text);
        registerTextcode = (EditText) findViewById(R.id.register_textcode);
        registerCode = (Button) findViewById(R.id.register_code);

    }
}