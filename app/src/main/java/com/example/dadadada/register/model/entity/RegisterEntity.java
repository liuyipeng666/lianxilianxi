package com.example.dadadada.register.model.entity;

public class RegisterEntity {


    private String imaccount;
    private String phonenumber;
    private String pwd;


    public String getImaccount() {
        return imaccount;
    }

    public void setImaccount(String imaccount) {
        this.imaccount = imaccount;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public RegisterEntity() {
    }

    public RegisterEntity(String imaccount, String phonenumber, String pwd) {
        this.imaccount = imaccount;
        this.phonenumber = phonenumber;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "RegisterEntity{" +
                "imaccount='" + imaccount + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
