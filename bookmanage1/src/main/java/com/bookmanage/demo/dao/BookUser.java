package com.bookmanage.demo.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity(name = "bookuser")
public class BookUser implements Serializable {

    @Id
    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "bname", nullable = false)
    private String bname;
    @Column(name = "bnumber", nullable = false)
    private int bnumber;
    @Column(name = "time", nullable = false)
    private String time;

    //  private String  time1;
    public BookUser() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        this.time = df.format(new Date());
    }

    public BookUser(String name, String bname, int bnumber) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        this.time = df.format(new Date());
        this.name = name;
        this.bname = bname;
        this.bnumber = bnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getBnumber() {
        return bnumber;
    }

    public void setBnumber(int bnumber) {
        this.bnumber = bnumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BookUser{" +
                "name='" + name + '\'' +
                ", bname='" + bname + '\'' +
                ", bnumber=" + bnumber +
                ", time='" + time + '\'' +
                '}';
    }
}
