package com.spring.security.dao.model;

import java.util.Collection;
import java.util.Date;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Company:     民航西南凯亚
 * Department:  研发部
 * Title:       [项目名 — 模块名]
 * Description: [描述该类概要功能]
 * Created on   2018年08月15日
 *
 * @author 李燕朋
 * @version V1.0
 */
@Data
public class User implements UserDetails {

    /**
     * id
     */
    private Integer id;

    /**
     * username:  [用户名]
     */
    private String username;

    /**
     * telephone:  [手机]
     */
    private String telephone;

    /**
     * mail:  [邮箱]
     */
    private String mail;

    /**
     * password:  [密码]
     */
    private String password;

    /**
     * deptId:  [部门ID]
     */
    private Integer deptId;

    /**
     * status:  [1：正常，0：冻结状态，2：删除]
     */
    private int status;

    /**
     * remark:  [备注]
     */
    private String remark;

    /**
     * operator:  [操作人]
     */
    private String operator;

    /**
     * operateIp:  [操作人Ip]
     */
    private String operateIp;

    /**
     * operateTime:  [操作时间]
     */
    private Date operateTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
