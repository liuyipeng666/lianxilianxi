package com.example.dadadada.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dadadada.R;
import com.example.dadadada.view.ContactActivity;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import static android.app.Activity.RESULT_OK;

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
        //面对面扫描 调用zxing
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.M){
            requestPermissions(new String[]{
                    "android.permission.VIBRATE",
                    "android.permission.CAMERA",
                    "android.permission.WRITE_EXTERNAL_STORAGE",
                    "android.permission.READ_EXTERNAL_STORAGE",
                    "android.permission.WAKE_LOCK"
            },100);
        }

        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        startActivityForResult(intent,100);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode== RESULT_OK){
            if(data!=null){
                Bundle extras = data.getExtras();
                if(extras!=null){
                    int type = extras.getInt(CodeUtils.RESULT_TYPE);
                    if(type==CodeUtils.RESULT_SUCCESS){
                        String resultString = CodeUtils.RESULT_STRING;
                        Toast.makeText(getActivity(), ""+resultString, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    private void shoujilianxiren() {
        //获取手机的联系人
        startActivity(new Intent(getActivity(), ContactActivity.class));

    }





}