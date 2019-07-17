package com.shine.storage.dao.mapper;

import com.shine.storage.dao.dto.UserInfoDTO;
import com.shine.storage.dao.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月14日 20:16
 */
@Mapper
@Repository
public interface UserInfoMapper {

    @Select("select id,account,name,password,salt,state from user where account=#{account} and password=#{pwd}")
    User getUserInfoByAccountAndPwd(@Param("account") String account, @Param("pwd") String pwd);

    @Select("select * from user where account=#{account}")
    User findUserByAccount(@Param("account") String account);

    @Select("select * from user where account=#{account}")
    @Results({@Result(property = "roleList",column = "id",many = @Many(select = "com.shine.storage.dao.mapper.RoleMapper.findRoleById"))})
    UserInfoDTO findUserInfoByAccount(@Param("account") String account);
}
