package com.shine.storage.dao.entity;

import com.shine.storage.dao.enums.GenderEnum;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date; 2018年09月21日 17:11
 */
public class Person {

    private Integer personId;

    private String personName;

//    private String userPwd;

    private  GenderEnum gender;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
