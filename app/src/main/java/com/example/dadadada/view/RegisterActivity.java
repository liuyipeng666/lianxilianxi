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
        
    }

    private void initView() {
        registerName = (EditText) findViewById(R.id.register_name);
        registerPwd = (EditText) findViewById(R.id.register_pwd);
        register = (Button) findViewById(R.id.register);
        imageFanhui = (ImageView) findViewById(R.id.image_fanhui);
        titleText = (TextView) findViewById(R.id.title_text);
    }
}