package com.example.dadadada.mvvm.model.entity;

/**
 *
 */

public class UserEntity {


    /**
     * code : 0
     * data : {"headimg":"","id":0,"imaccount":"","lat":"","lon":"","nick":"","phonenumber":"","token":""}
     * msg :
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * headimg :
         * id : 0
         * imaccount :
         * lat :
         * lon :
         * nick :
         * phonenumber :
         * token :
         */

        private String headimg;
        private int id;
        private String imaccount;
        private String lat;
        private String lon;
        private String nick;
        private String phonenumber;
        private String token;

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImaccount() {
            return imaccount;
        }

        public void setImaccount(String imaccount) {
            this.imaccount = imaccount;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
