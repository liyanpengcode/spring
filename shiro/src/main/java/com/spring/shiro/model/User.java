package com.spring.shiro.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {


    private Integer userId;

    private String username;

    private String password;


    private Set<Role> roles=  new HashSet<>();


}
