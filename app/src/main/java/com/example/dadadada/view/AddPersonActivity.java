package com.example.dadadada.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.dadadada.R;
import com.example.dadadada.adapter.AddPersonAdapter;
import com.example.dadadada.fragment.AddGroupFragment;
import com.example.dadadada.fragment.AddPersonFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AddPersonActivity extends AppCompatActivity {

    private ImageView imageFanhui;
    private TextView titleText;
    private TabLayout tablayoutAddperson;
    private ViewPager addpersonVp;
    private List<String> title=new ArrayList<>();
    private List<Fragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        initView();
        titleText.setText("添加");

        imageFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tab();
    }

    private void tab() {
        title.add("找人");
        title.add("找群");

        list.add(new AddPersonFragment());
        list.add(new AddGroupFragment());

        AddPersonAdapter addPersonAdapter = new AddPersonAdapter(getSupportFragmentManager(),list,title);


        addpersonVp.setAdapter(addPersonAdapter);
        tablayoutAddperson.setupWithViewPager(addpersonVp);
    }

    private void initView() {
        imageFanhui = (ImageView) findViewById(R.id.image_fanhui);
        titleText = (TextView) findViewById(R.id.title_text);
        tablayoutAddperson = (TabLayout) findViewById(R.id.tablayout_addperson);
        addpersonVp = (ViewPager) findViewById(R.id.addperson_vp);
    }
}