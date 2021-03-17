package com.github.io24m.oauth2.sso.service.user;

import com.github.io24m.oauth2.sso.domain.User;
import com.github.io24m.oauth2.sso.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:13
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(s)) {
            throw new UsernameNotFoundException("not user");
        }
        User user = userMapper.selectByPrimaryKey(s);
        if (user==null){
            throw new UsernameNotFoundException("not user");
        }
        return new SSOUser(user);
    }
}
