package com.bookmanage.demo.dao;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name",nullable = false)
    private  String name;
    @Column(name="account",nullable = false)
    private String account;
    @Column(name="password",nullable = false)
    private  String passWord;

    public  User(){}
    public User(String name, String account, String passWord) {
        this.name = name;
        this.account = account;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }



}
