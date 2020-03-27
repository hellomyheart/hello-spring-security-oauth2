package com.funtl.spring.security.oauth2.server.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration 配置类注解
@Configuration
//开启web安全
@EnableWebSecurity
//通用方法安全注解，拦截所有请求
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 配置默认的加密方式
        return new BCryptPasswordEncoder();
    }

    //认证配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中设置认证
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("123456"))
                //user角色
                .roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin888"))
                .roles("ADMIN");
    }
}
