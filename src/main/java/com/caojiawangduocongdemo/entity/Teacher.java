package com.caojiawangduocongdemo.entity;

import java.io.Serializable;

public class Teacher implements Serializable {
    private static final long serialVersionUID = 3889841156651636309L;
    private String sysid;

    private String teacherid;

    private String teachername;

    private String teacherpic;

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid == null ? null : sysid.trim();
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid == null ? null : teacherid.trim();
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public String getTeacherpic() {
        return teacherpic;
    }

    public void setTeacherpic(String teacherpic) {
        this.teacherpic = teacherpic == null ? null : teacherpic.trim();
    }
}