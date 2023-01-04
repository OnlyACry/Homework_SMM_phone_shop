package org.xja.phonedemo.domain;

import lombok.Data;

import javax.management.relation.Role;

/**
 * 管理员实体类
 */
@Data
public class Admin {
    //    admin_id	int
    private Integer adminId;
    //    admin_name	varchar
    private String adminName;
    //    admin_pass	varchar
    private String adminPass;
    //    admin_role_id	int
    private Role adminRole;//管理员的角色

}
