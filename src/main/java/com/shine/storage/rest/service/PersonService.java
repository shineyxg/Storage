package com.shine.storage.rest.service;

import com.shine.storage.dao.entity.Person;
import com.shine.storage.dao.enums.GenderEnum;

import java.util.List;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年09月26日 22:53
 */
public interface PersonService {

    boolean savePerson(String personName, GenderEnum gender);

    List<Person> getAllPerson();
}
