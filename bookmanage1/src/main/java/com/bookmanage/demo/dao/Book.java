package com.bookmanage.demo.dao;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "bno", nullable = false)
    private String bno;
    @Column(name = "bname", nullable = false)
    private String bname;
    @Column(name = "bnumber", nullable = false)
    private int bnumber;
    @Column(name = "btest", nullable = false)
    private String btest;
    @Column(name = "btype", nullable = false)
    private String btype;
    @Column(name = "publisher",nullable = false)
    private String publisher;
    @Column(name = "btime",nullable = false)
    private String btime;

    public Book () {
    }

    public Book(String bno, String bname, int bnumber, String btest, String btype, String publisher, String btime) {
        this.bno = bno;
        this.bname = bname;
        this.bnumber = bnumber;
        this.btest = btest;
        this.btype = btype;
        this.publisher = publisher;
        this.btime = btime;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }




    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
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

    public String getBtest() {
        return btest;
    }

    public void setBtest(String btest) {
        this.btest = btest;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bno='" + bno + '\'' +
                ", bname='" + bname + '\'' +
                ", bnumber=" + bnumber +
                ", btest='" + btest + '\'' +
                ", btype='" + btype + '\'' +
                ", publisher='" + publisher + '\'' +
                ", btime='" + btime + '\'' +
                '}';
    }
}
