package com.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//启用
@EnableWebSecurity
//开启Security注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").disabled(false);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //隔离的资源;
        //不被权限所拦截
        web.ignoring().mvcMatchers("/js/**", "/css/**", "/swagger-*/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*所有请求都要授权访问*/
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                //任何请求都要认证
                .anyRequest().authenticated()
                .and().logout()
                .and().formLogin();
        http.csrf().disable();
    }
}
