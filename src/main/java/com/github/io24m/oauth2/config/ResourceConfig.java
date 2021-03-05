package com.github.io24m.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 13:59
 */
@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private CustomAuthExceptionHandler customAuthExceptionHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.stateless(false)
                .accessDeniedHandler(customAuthExceptionHandler)
                .authenticationEntryPoint(customAuthExceptionHandler);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                //请求权限配置
                .authorizeRequests()
                //下边的路径放行,不需要经过认证
                .antMatchers("/oauth/*","/login", "/auth/user/login").permitAll()
                //OPTIONS请求不需要鉴权
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                //用户的增删改接口只允许管理员访问
                .antMatchers(HttpMethod.POST, "/auth/user").hasAnyAuthority(Oauth2Constants.ROLE_ADMIN)
                .antMatchers(HttpMethod.PUT, "/auth/user").hasAnyAuthority(Oauth2Constants.ROLE_ADMIN)
                .antMatchers(HttpMethod.DELETE, "/auth/user").hasAnyAuthority(Oauth2Constants.ROLE_ADMIN)
                //获取角色 权限列表接口只允许系统管理员及高级用户访问
                .antMatchers(HttpMethod.GET, "/auth/role").hasAnyAuthority(Oauth2Constants.ROLE_ADMIN)
                //其余接口没有角色限制，但需要经过认证，只要携带token就可以放行
                .anyRequest()
                .authenticated();
    }
}
