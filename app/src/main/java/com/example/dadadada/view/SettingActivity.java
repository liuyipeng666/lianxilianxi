package com.example.dadadada.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.dadadada.R;
import com.example.dadadada.adapter.FriendsTokenAdapter;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.model.entity.FriendsEntity;
import com.example.dadadada.mvvm.model.entity.LoginFanEntity;
import com.example.dadadada.mvvm.model.entity.UserEntity;
import com.example.dadadada.mvvm.viewmodel.UserHeadViewModel;
import com.example.dadadada.mvvm.viewmodel.UserNameViewModel;
import com.example.dadadada.mvvm.viewmodel.UserPwdViewModel;
import com.example.dadadada.mvvm.viewmodel.UserViewModel;
import com.example.net.retrofit.BaseRespEntity;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SettingActivity extends AppCompatActivity{

    private ImageView imgSetting;
    private TextView againimgSetting;
    private EditText nameSetting;
    private TextView againnameSetting;
    private TextView againpass;
    private SharedPreferences tLapp;
    private EditText passSetting;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initview();

        UserViewModel userViewModel = new UserViewModel(this);
        tLapp = getSharedPreferences("TLapp", MODE_PRIVATE);
        id= Integer.parseInt(tLapp.getString("id", ""));
        userViewModel.usersss(id).observe(this, new Observer<BaseRespEntity<UserEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<UserEntity> userEntityBaseRespEntity) {
//                String nick = userEntityBaseRespEntity.getData(UserEntity.class).getData().getNick();
//                nameSetting.setText(nick);
//                String headimg = data1.getHeadimg();
//                Glide.with(SettingActivity.this).load(headimg).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(imgSetting);
//                nameSetting.setText(data1.getNick());
            }
        });
        //修改头像
        againimgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserHeadViewModel userHeadViewModel = new UserHeadViewModel(SettingActivity.this);
                String path="123";
                userHeadViewModel.headsss(path,id).observe(SettingActivity.this, new Observer<BaseRespEntity<ChangeUserEntity>>() {
                    @Override
                    public void onChanged(BaseRespEntity<ChangeUserEntity> changeUserEntityBaseRespEntity) {
                        if(changeUserEntityBaseRespEntity.getMsg().equals("请求成功")){
//                            Glide.with(SettingActivity.this).load(path).transform(new CircleCrop()).into(imgSetting);
                            Toast.makeText(SettingActivity.this, "头像修改成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        //修改昵称
        againnameSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNameViewModel userNameViewModel = new UserNameViewModel(SettingActivity.this);
                String sss = nameSetting.getText().toString();
                userNameViewModel.headsss(id,sss).observe(SettingActivity.this, new Observer<BaseRespEntity<ChangeUserEntity>>() {
                    @Override
                    public void onChanged(BaseRespEntity<ChangeUserEntity> changeUserEntityBaseRespEntity) {
                        if (changeUserEntityBaseRespEntity.getMsg().equals("请求成功")){
                            Toast.makeText(SettingActivity.this, "昵称修改成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        //修改密码
        againpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserPwdViewModel userpwdViewModel = new UserPwdViewModel(SettingActivity.this);
                String pwd = passSetting.getText().toString();
                userpwdViewModel.headsss(id,pwd).observe(SettingActivity.this, new Observer<BaseRespEntity<ChangeUserEntity>>() {
                    @Override
                    public void onChanged(BaseRespEntity<ChangeUserEntity> changeUserEntityBaseRespEntity) {
                        if (changeUserEntityBaseRespEntity.getMsg().equals("请求成功")){
                            Toast.makeText(SettingActivity.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void initview() {
        imgSetting = (ImageView) findViewById(R.id.img_setting);
        againimgSetting = (TextView) findViewById(R.id.againimg_setting);
        nameSetting = (EditText) findViewById(R.id.name_setting);
        againnameSetting = (TextView) findViewById(R.id.againname_setting);
        againpass = (TextView) findViewById(R.id.againpass);
        passSetting = (EditText) findViewById(R.id.pass_setting);
    }
}