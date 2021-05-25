package com.example.dadadada.mvvm.model;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.api.UserApi;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.model.entity.RegisterCodeEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

/**
 *
 */
public class RegisterCodeMdoel implements IModel {

    public LiveData<BaseRespEntity<RegisterCodeEntity>> getcode(String phonenumber){
        UserApi userApi = NetTools.getInstance().create(UserApi.class);
        return userApi.getcode(phonenumber);
    }

}
