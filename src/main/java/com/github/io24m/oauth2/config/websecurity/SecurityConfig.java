package com.github.io24m.oauth2.config.websecurity;

import com.github.io24m.oauth2.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:09
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        return userService;//super.userDetailsServiceBean();
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new UserPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/login", "/oauth/authorize")
                .antMatchers("/oauth/**", "/login/**", "/logout").permitAll()
//                .and()
//                .authorizeRequests()
//                .mvcMatchers("/account/updatepassword").permitAll()
                .anyRequest().authenticated()
                .and()
                //.formLogin().loginPage("/login").permitAll()
                //.and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and()
                .csrf().disable()
//                .addFilterAt(getCisSsoLogoutFilter(), LogoutFilter.class)
                .addFilterAt(usernamePasswordAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Bean
    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilterBean() throws Exception {
        UsernamePasswordAuthenticationFilter filter = new AuthenticationProcessingFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);
        return filter;
    }
}
