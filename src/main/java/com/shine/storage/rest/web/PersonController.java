package com.shine.storage.rest.web;

import com.shine.storage.dao.dto.UserInfoDTO;
import com.shine.storage.dao.entity.Person;
import com.shine.storage.dao.enums.GenderEnum;
import com.shine.storage.dao.mapper.UserInfoMapper;
import com.shine.storage.rest.service.PersonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年09月21日 18:32
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private UserInfoMapper userInfoMapper;


    @ApiOperation(value = "这只是个测试！")
    @GetMapping("/test")
    public String testResponse() {
        return "this is a test!";
    }

    @GetMapping("/savePerson/{name}/{gender}")
    public boolean savePerson(@PathVariable String name, @PathVariable GenderEnum gender) {
        return personService.savePerson(name, gender);
    }

    @GetMapping("/getAllPerson")
    public List<Person> selectAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/getUserInfo")
    public UserInfoDTO getUserInfo(@RequestParam String account){
        return userInfoMapper.findUserInfoByAccount(account);
    }
}
