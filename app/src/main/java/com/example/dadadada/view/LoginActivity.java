package com.example.dadadada.view;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.dadadada.mvvm.model.entity.LoginEntity;
import com.example.dadadada.mvvm.model.entity.LoginFanEntity;
import com.example.dadadada.mvvm.viewmodel.LoginViewModel;
import com.example.net.retrofit.BaseRespEntity;

public class LoginActivity extends AppCompatActivity {

    private ImageView imageFanhui;
    private TextView titleText;
    private EditText loginName;
    private EditText loginPwd;
    private Button login;
    private TextView wangjiPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        titleText.setText("登录");

        imageFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginn();
            }
        });

        wangjiPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgetActivity.class));
            }
        });



    }

    private void initView() {
        imageFanhui = (ImageView) findViewById(R.id.image_fanhui);
        titleText = (TextView) findViewById(R.id.title_text);
        loginName = (EditText) findViewById(R.id.login_name);
        loginPwd = (EditText) findViewById(R.id.login_pwd);
        login = (Button) findViewById(R.id.login);
        wangjiPwd = (TextView) findViewById(R.id.wangji_pwd);
    }

    private void loginn() {
        String phonenumber = loginName.getText().toString();
        String pwd = loginPwd.getText().toString();
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setPhonenumber(phonenumber);
        loginEntity.setPwd(pwd);
        if (!phonenumber.isEmpty() && !pwd.isEmpty()) {
            LoginViewModel loginViewModel = new LoginViewModel(this);
            loginViewModel.logincmd(loginEntity).observe(this, new Observer<BaseRespEntity<LoginFanEntity>>() {

                public void onChanged(BaseRespEntity<LoginFanEntity> loginEntityBaseRespEntity) {
                    if (loginEntityBaseRespEntity.getMsg().equals("请求成功")) {
                        //登录成功
                        int id = loginEntityBaseRespEntity.getData(LoginFanEntity.class).getId();

                        String token = loginEntityBaseRespEntity.getData(LoginFanEntity.class).getToken();
                        SharedPreferences tLapp = getSharedPreferences("TLapp", MODE_PRIVATE);
                        SharedPreferences.Editor edit = tLapp.edit();
                        edit.putString("token",token);
                        edit.putString("username",phonenumber);
                        edit.putString("pwd",pwd);
                        edit.putString("id",id+"");
                        edit.commit();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        loginPwd.getText().clear();
                        Toast.makeText(LoginActivity.this, "输入手机号或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}