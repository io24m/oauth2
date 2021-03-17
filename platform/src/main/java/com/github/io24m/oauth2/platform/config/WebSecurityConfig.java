package com.github.io24m.oauth2.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${io24m.logout:/logout}")
    private String logout;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();

        http.authorizeRequests()
                //region 权限码
//                .requestMatchers(getRequestMatcher("/sys/notication/**")).hasAuthority("sys-notication")
                .antMatchers("/**/**").authenticated()
                .anyRequest().hasAuthority("not_allow")//这一行强制添加，必须加
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .clearAuthentication(true)
                .invalidateHttpSession(true).permitAll()
                //关闭跨站请求防护
                .and().csrf().disable()
                .headers().frameOptions().sameOrigin();
    }
}
