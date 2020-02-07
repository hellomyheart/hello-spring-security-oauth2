package com.demo.spring.security.oauth2.server.service;

import com.demo.spring.security.oauth2.server.domain.TbUser;

public interface TbUserService{
    //先拿用户再匹配密码
    TbUser getByUsername(String username);

}
