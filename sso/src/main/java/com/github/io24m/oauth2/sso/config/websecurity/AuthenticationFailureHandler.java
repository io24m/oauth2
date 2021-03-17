package com.github.io24m.oauth2.sso.config.websecurity;

import com.github.io24m.oauth2.sso.domain.User;
import com.github.io24m.oauth2.sso.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 16:24
 */
@Configuration
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private final Logger logger = LoggerFactory.getLogger(AuthenticationFailureHandler.class);
    @Autowired
    private UserMapper userMapper;

    public AuthenticationFailureHandler() {
        super.setDefaultFailureUrl("/login");
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Object username = request.getAttribute(AuthenticationProcessingFilter.USERNAME);
        if (username == null) {
            super.onAuthenticationFailure(request, response, exception);
            return;
        }
        String account = (String) username;
        User user = userMapper.selectByPrimaryKey(account);
        if (user == null) {
            super.onAuthenticationFailure(request, response, exception);
            return;
        }
        user.setLoginErrorCount(user.getLoginErrorCount() + 1);
        user.setLastLoginErrorTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
        super.onAuthenticationFailure(request, response, exception);
    }
}
