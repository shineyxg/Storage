package com.shine.storage.dao.enums;

/**
 * @author : shine
 * @Project: Storage
 * @Description: 性别
 * @date: 2018年09月21日 18:12
 */
public enum GenderEnum {

    man("男", 1), woman("女", 2);

    private String name;

    private Integer index;

    GenderEnum(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
