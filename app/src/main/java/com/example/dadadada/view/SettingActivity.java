package com.example.dadadada.view;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dadadada.R;

public class SettingActivity extends AppCompatActivity {

    private Button tuichuLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();



    }

    private void initView() {
        tuichuLogin = (Button) findViewById(R.id.tuichu_login);
    }
}