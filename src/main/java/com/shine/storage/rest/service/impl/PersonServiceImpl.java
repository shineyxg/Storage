package com.shine.storage.rest.service.impl;

import com.shine.storage.dao.entity.Person;
import com.shine.storage.dao.enums.GenderEnum;
import com.shine.storage.dao.mapper.PersonMapper;
import com.shine.storage.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年09月26日 22:57
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;


    @Override
    public boolean savePerson(String personName, GenderEnum gender) {
        boolean result = false;

        try {
            result = personMapper.insertPerson(personName,gender.getIndex());
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<Person> getAllPerson() {
        return personMapper.findAllPerson();
    }
}
