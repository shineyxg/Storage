package com.shine.storage.dao.mapper;

import com.shine.storage.dao.dto.UserInfoDTO;
import com.shine.storage.dao.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.Optional;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月14日 20:16
 */
@Mapper
public interface UserInfoMapper {

    @Select("select id,account,name,password,salt,state from user where account=#{account} and password=#{pwd}")
    Optional<User> getUserInfoByAccountAndPwd(@Param("account") String account, @Param("pwd") String pwd);
}
