package com.shine.storage.dao.dto;

import java.util.List;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月14日 20:21
 */
public class UserInfoDTO {

    private String account; //帐号

    private String name;//名称（昵称或者真实姓名，不同系统不同定义）

    private String password; //密码;

    private String salt;//加密密码的盐

    private byte state;//用户状态

    private List<SysRoleDTO> roleList;// 一个用户具有多个角色

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

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRoleDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRoleDTO> roleList) {
        this.roleList = roleList;
    }
}
