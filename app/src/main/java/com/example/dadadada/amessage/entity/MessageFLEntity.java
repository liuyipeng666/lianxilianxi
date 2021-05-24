package com.example.dadadada.amessage.entity;

import java.util.List;

public class MessageFLEntity {


    /**
     * code : 0
     * data : [{"id":0,"msgtypecode":0,"msgtypename":""}]
     * msg :
     */

    private int code;
    private String msg;
    /**
     * id : 0
     * msgtypecode : 0
     * msgtypename :
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int msgtypecode;
        private String msgtypename;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMsgtypecode() {
            return msgtypecode;
        }

        public void setMsgtypecode(int msgtypecode) {
            this.msgtypecode = msgtypecode;
        }

        public String getMsgtypename() {
            return msgtypename;
        }

        public void setMsgtypename(String msgtypename) {
            this.msgtypename = msgtypename;
        }
    }
}
