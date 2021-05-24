package com.example.dadadada.entity;


public class CreateQunEntity {


    /**
     * groupcode :
     * groupdesc :
     * groupname :
     * grouptypeid : 0
     * grouptypename :
     * imgpath :
     * owner : 0
     */

    public String groupcode;
    private String groupdesc;
    private String groupname;
    private int grouptypeid;
    private String grouptypename;
    private String imgpath;
    private int owner;

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }

    public String getGroupdesc() {
        return groupdesc;
    }

    public void setGroupdesc(String groupdesc) {
        this.groupdesc = groupdesc;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public int getGrouptypeid() {
        return grouptypeid;
    }

    public void setGrouptypeid(int grouptypeid) {
        this.grouptypeid = grouptypeid;
    }

    public String getGrouptypename() {
        return grouptypename;
    }

    public void setGrouptypename(String grouptypename) {
        this.grouptypename = grouptypename;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
