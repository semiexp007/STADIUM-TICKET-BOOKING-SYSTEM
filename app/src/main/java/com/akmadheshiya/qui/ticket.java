package com.akmadheshiya.qui;

public class ticket {
    String uid;
    String name;
    String tcno;
    String stno;
    String clas;



    public ticket() {
    }

    public ticket(String uid, String name, String tcno, String stno,String clas) {
        this.uid = uid;
        this.name = name;
        this.tcno = tcno;
        this.stno = stno;
        this.clas=clas;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno;
    }
    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }
}
