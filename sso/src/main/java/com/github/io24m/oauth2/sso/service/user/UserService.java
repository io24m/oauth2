package com.github.io24m.oauth2.sso.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:13
 */
@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        if (s==null||s.equals("")){
            throw new UsernameNotFoundException("用户名error");
        }


        return new User();
    }
}