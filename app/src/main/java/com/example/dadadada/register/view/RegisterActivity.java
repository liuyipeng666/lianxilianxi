package com.example.dadadada.register.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.dadadada.R;
import com.example.dadadada.register.model.entity.RegisterEntity;
import com.example.dadadada.register.viewmodel.RegisterViewModel;
import com.example.net.retrofit.BaseRespEntity;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerName;
    private EditText registerPwd;
    private Button register;

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


    }
    private void register(){
        //获取
        String name = registerName.getText().toString().trim();
        String pwd = registerPwd.getText().toString().trim();

        Log.i("123", "register: "+name +"  "+ pwd);
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setPwd(pwd);
        registerEntity.setUsername(name);
        registerEntity.setSex("nan");
        registerEntity.setId(1);
        registerEntity.setBirthday(""+System.currentTimeMillis());
        RegisterViewModel registerViewModel = new RegisterViewModel(this);

        registerViewModel.loginCmd(registerEntity).observe(this, new Observer<BaseRespEntity<RegisterEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<RegisterEntity> entity) {
                Log.i("123", "onChanged: "+entity.toString());
                Toast.makeText(RegisterActivity.this, ""+entity.getMsg(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initView() {
        registerName = (EditText) findViewById(R.id.register_name);
        registerPwd = (EditText) findViewById(R.id.register_pwd);
        register = (Button) findViewById(R.id.register);
    }
}