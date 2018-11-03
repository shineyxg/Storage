package com.shine.storage.dao.enums;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月18日 20:48
 */
public enum UserStateEnum {
    unauthorized("未认证",1),formal("正常",2),lock("锁定",3);

    UserStateEnum(String value, int index) {
        this.value = value;
        this.index = index;
    }

    private String value;

    private int index;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
