package com.caojiawangduocongdemo.entity;

import java.io.Serializable;

public class Subject implements Serializable {
    private static final long serialVersionUID = 979234672899267839L;
    private String sysid;

    private String stno;

    private String sttitle;

    private String stoptiona;

    private String stoptionb;

    private String stoptionc;

    private String stoptiond;

    private String stanswer;

    private String stparse;

    private String ststatus;

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid == null ? null : sysid.trim();
    }

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno == null ? null : stno.trim();
    }

    public String getSttitle() {
        return sttitle;
    }

    public void setSttitle(String sttitle) {
        this.sttitle = sttitle == null ? null : sttitle.trim();
    }

    public String getStoptiona() {
        return stoptiona;
    }

    public void setStoptiona(String stoptiona) {
        this.stoptiona = stoptiona == null ? null : stoptiona.trim();
    }

    public String getStoptionb() {
        return stoptionb;
    }

    public void setStoptionb(String stoptionb) {
        this.stoptionb = stoptionb == null ? null : stoptionb.trim();
    }

    public String getStoptionc() {
        return stoptionc;
    }

    public void setStoptionc(String stoptionc) {
        this.stoptionc = stoptionc == null ? null : stoptionc.trim();
    }

    public String getStoptiond() {
        return stoptiond;
    }

    public void setStoptiond(String stoptiond) {
        this.stoptiond = stoptiond == null ? null : stoptiond.trim();
    }

    public String getStanswer() {
        return stanswer;
    }

    public void setStanswer(String stanswer) {
        this.stanswer = stanswer == null ? null : stanswer.trim();
    }

    public String getStparse() {
        return stparse;
    }

    public void setStparse(String stparse) {
        this.stparse = stparse == null ? null : stparse.trim();
    }

    public String getStstatus() {
        return ststatus;
    }

    public void setStstatus(String ststatus) {
        this.ststatus = ststatus == null ? null : ststatus.trim();
    }
}