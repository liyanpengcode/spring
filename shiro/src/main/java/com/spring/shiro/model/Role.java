package com.spring.shiro.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色class
 */
@Data
public class Role {

    private Integer roleId;
    private String name;
    private Set<Permission> permissions = new HashSet<>();
    private Set<User> users = new HashSet<>();


}
