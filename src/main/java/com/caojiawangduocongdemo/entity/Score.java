package com.caojiawangduocongdemo.entity;

import java.io.Serializable;

public class Score implements Serializable {
    private static final long serialVersionUID = -3388627195849290611L;
    private String sysid;

    private String studentid;

    private Integer score;

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid == null ? null : sysid.trim();
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}