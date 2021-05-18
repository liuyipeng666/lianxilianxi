package com.example.dadadada.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.dadadada.R;
import com.example.dadadada.mvvm.model.entity.RegisterEntity;
import com.example.dadadada.mvvm.viewmodel.RegisterViewModel;
import com.example.net.retrofit.BaseRespEntity;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerName;
    private EditText registerPwd;
    private Button register;
    private ImageView imageFanhui;
    private TextView titleText;

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

    }

    private void register() {
        //获取
        String name = registerName.getText().toString().trim();
        String pwd = registerPwd.getText().toString().trim();
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setPhonenumber(name);
        registerEntity.setPwd(pwd);
        if(!name.isEmpty() && !pwd.isEmpty()){
            RegisterViewModel registerViewModel = new RegisterViewModel(this);
            registerViewModel.loginCmd(registerEntity).observe(this, new Observer<BaseRespEntity<RegisterEntity>>() {
                @Override
                public void onChanged(BaseRespEntity<RegisterEntity> entity) {
                    if (entity != null) {
                        if (entity.getMsg().equals("操作成功")) {
                            Toast.makeText(RegisterActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
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
    }
}