package com.example.dadadada.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dadadada.R;
import com.example.dadadada.common.SpUtils;

public class SettingActivity extends AppCompatActivity {

    private Button tuichuLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();

        tuichuLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpUtils.clearr(SettingActivity.this);
                startActivity(new Intent(SettingActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void initView() {
        tuichuLogin = (Button) findViewById(R.id.tuichu_login);
    }
}