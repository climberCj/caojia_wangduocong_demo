package com.caojiawangduocongdemo.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private static final long serialVersionUID = 2581760428284561892L;
    private String perId;

    private String permissionName;

    private String roleId;

    public String getPerId() {
        return perId;
    }

    public void setPerId(String perId) {
        this.perId = perId == null ? null : perId.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    @Override
    public String toString() {
        return "Permission{" +
                "perId='" + perId + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}