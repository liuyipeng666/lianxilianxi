package com.example.dadadada;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "曹蓝之简直是太牛了", Toast.LENGTH_SHORT).show();
    //ZLogManager.getInstance().i("哒哒哒");


    }
}