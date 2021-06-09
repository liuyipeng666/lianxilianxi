package com.example.dadadada.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadadada.R;

/**
 * 联系人页面  群组添加联系人
 */
public class PeopleActivity extends AppCompatActivity {

    private RecyclerView recyclePeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        initView();




    }

    private void initView() {
        recyclePeople = (RecyclerView) findViewById(R.id.recycle_people);
    }
}