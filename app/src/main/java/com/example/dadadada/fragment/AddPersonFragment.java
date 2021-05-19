package com.example.dadadada.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.dadadada.R;
import com.example.dadadada.view.ContactActivity;

public class AddPersonFragment extends Fragment {
    private EditText edSou;
    private TextView tianjiaLianxiren;
    private TextView tianjiaMianduimian;
    private TextView tianjiaOne;
    private TextView tianjiaTwo;
    private TextView tianjiaThree;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_add_person, container, false);
        edSou = (EditText)inflate.findViewById(R.id.ed_sou);
        tianjiaLianxiren = (TextView)inflate. findViewById(R.id.tianjia_lianxiren);
        tianjiaMianduimian = (TextView)inflate. findViewById(R.id.tianjia_mianduimian);
        tianjiaOne = (TextView)inflate. findViewById(R.id.tianjia_one);
        tianjiaTwo = (TextView) inflate.findViewById(R.id.tianjia_two);
        tianjiaThree = (TextView)inflate. findViewById(R.id.tianjia_three);



        tianjiaLianxiren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoujilianxiren();
            }
        });

        tianjiaMianduimian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mianduimian();
            }
        });




        return inflate;
    }

    private void mianduimian() {
        //面对面扫描




    }

    private void shoujilianxiren() {
        //获取手机的联系人
        startActivity(new Intent(getActivity(), ContactActivity.class));

    }





}