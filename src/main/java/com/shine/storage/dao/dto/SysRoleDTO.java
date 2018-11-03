package com.shine.storage.dao.dto;

import java.util.List;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月14日 20:36
 */
public class SysRoleDTO {

    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户

    //角色 -- 权限关系：多对多关系;
    private List<SysPermissionDTO> permissions;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysPermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermissionDTO> permissions) {
        this.permissions = permissions;
    }
}
