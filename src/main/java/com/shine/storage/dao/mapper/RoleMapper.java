package com.shine.storage.dao.mapper;

import com.shine.storage.dao.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月18日 23:06
 */
@Mapper
public interface RoleMapper {

    @Select("select id,role,description,available from sys_role sr left join user_role ur on sr.id=ur.role_id WHERE ur.user_id=#{userId} AND sr.available=1")
    // @Results({})
    List<SysRole> findRolesByUserId(@Param("userId") Integer userId);
}
