package com.shine.storage.dao.mapper;

import com.shine.storage.dao.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月20日 10:18
 */
@Mapper
public interface PermissionMapper {

    @Select("select * from sys_permission sp left join role_permission rp on sp.id=rp.permission_id where sp.id=#{roleId}")
    List<SysPermission> findPermissionsByRoleId(@Param("roleId")Integer roleId);
}
