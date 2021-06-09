package com.example.dadadada.mvvm.model.entity;

import java.io.Serializable;

/**
 *
 */
public class RegisterCodeEntity implements Serializable {


    /**
     * code : 0
     * data :
     * msg :
     */

    private int code;
    private String data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
