package com.shine.storage.dao.entity;

import com.shine.storage.dao.enums.UserStateEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : shine
 * @Project: Storage
 * @Description: 用户信息
 * @date: 2018年10月18日 20:46
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1087245790835627725L;

    private Integer id;

    private String account;//帐号

    private String username;//名称（昵称或者真实姓名，不同系统不同定义）

    private String password; //密码;

    private String salt;//加密密码的盐

    private UserStateEnum state;

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public UserStateEnum getState() {
        return state;
    }

    public void setState(UserStateEnum state) {
        this.state = state;
    }

    *//*获取密码盐*//*
    public String getCredentialSalt() {
        return this.account + this.salt;
    }*/
}
