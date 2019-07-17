package com.shine.storage.rest.service;

import com.shine.storage.dao.entity.User;
import com.shine.storage.dao.mapper.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年11月20日 23:17
 */
@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserInfoMapper userInfoMapper;

    @Transactional(propagation = Propagation.MANDATORY)
    public User findByAccountAndPwd(String account, String pwd) {

        return userInfoMapper.getUserInfoByAccountAndPwd(account, pwd);
    }
}
