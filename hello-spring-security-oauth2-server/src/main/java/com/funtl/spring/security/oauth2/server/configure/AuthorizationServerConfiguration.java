package com.funtl.spring.security.oauth2.server.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
//开启认证授权服务
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //客户端配置

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                //在内存中配置客户端
                .inMemory()
                // client_id
                .withClient("client")
                // client_secret
                .secret(passwordEncoder.encode("secret"))
                //授权模式,这里使用了授权码模式
                .authorizedGrantTypes("authorization_code")
                //授权范围
                .scopes("app")
                //注册回调地址
                .redirectUris("https://www.baidu.com");
    }
}
