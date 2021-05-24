package com.example.dadadada.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.dadadada.R;
import com.example.dadadada.adapter.AddPersonAdapter;
import com.example.dadadada.view.CQunActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AddGroupFragment extends Fragment {

    private EditText edSou;
    private TextView chuangjianqun;
    private TextView qunMianduimian;
    private ViewPager qunVp;
    private List<String> title = new ArrayList<>();
    private List<Fragment> list = new ArrayList<>();
    private TabLayout qunTab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_add_group, container, false);
        edSou = (EditText) inflate.findViewById(R.id.ed_sou);
        chuangjianqun = (TextView) inflate.findViewById(R.id.chuangjianqun);
        qunMianduimian = (TextView) inflate.findViewById(R.id.qun_mianduimian);
        qunVp = (ViewPager) inflate.findViewById(R.id.qun_vp);
        qunTab = (TabLayout)inflate. findViewById(R.id.qun_tab);
        tab();

        chuangjianqun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cjqun();
            }
        });

        qunMianduimian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saoma();
            }
        });


        return inflate;
    }

    private void tab() {
        title.add("游戏");
        title.add("粉丝");
        title.add("交友");
        list.add(new GameFragment());
        list.add(new FansFragment());
        list.add(new PalFragment());
        AddPersonAdapter addPersonAdapter = new AddPersonAdapter(getChildFragmentManager(), list, title);


        qunVp.setAdapter(addPersonAdapter);
        qunTab.setupWithViewPager(qunVp);

    }

    private void saoma() {

    }

    private void cjqun() {
        startActivity(new Intent(getContext(), CQunActivity.class));

    }
}