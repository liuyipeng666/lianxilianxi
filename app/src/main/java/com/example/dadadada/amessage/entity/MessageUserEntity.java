package com.example.dadadada.amessage.entity;

import java.util.List;

public class MessageUserEntity {

    /**
     * code : 0
     * data : [{"blltime":"","content":"","ctime":"","fromuser":0,"id":0,"isread":0,"msgtype2":0,"msgtypeid":0,"touser":0}]
     * msg :
     */

    private int code;
    private String msg;
    /**
     * blltime :
     * content :
     * ctime :
     * fromuser : 0
     * id : 0
     * isread : 0
     * msgtype2 : 0
     * msgtypeid : 0
     * touser : 0
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
        private String blltime;
        private String content;
        private String ctime;
        private int fromuser;
        private int id;
        private int isread;
        private int msgtype2;
        private int msgtypeid;
        private int touser;

        public String getBlltime() {
            return blltime;
        }

        public void setBlltime(String blltime) {
            this.blltime = blltime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public int getFromuser() {
            return fromuser;
        }

        public void setFromuser(int fromuser) {
            this.fromuser = fromuser;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsread() {
            return isread;
        }

        public void setIsread(int isread) {
            this.isread = isread;
        }

        public int getMsgtype2() {
            return msgtype2;
        }

        public void setMsgtype2(int msgtype2) {
            this.msgtype2 = msgtype2;
        }

        public int getMsgtypeid() {
            return msgtypeid;
        }

        public void setMsgtypeid(int msgtypeid) {
            this.msgtypeid = msgtypeid;
        }

        public int getTouser() {
            return touser;
        }

        public void setTouser(int touser) {
            this.touser = touser;
        }
    }
}
