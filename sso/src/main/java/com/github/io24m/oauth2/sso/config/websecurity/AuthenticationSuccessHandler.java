package com.github.io24m.oauth2.sso.config.websecurity;

import com.github.io24m.oauth2.sso.domain.User;
import com.github.io24m.oauth2.sso.mapper.UserMapper;
import com.github.io24m.oauth2.sso.service.user.SSOUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.util.ClassUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 16:19
 */
@Configuration
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //success log
        if (ClassUtils.isAssignable(authentication.getPrincipal().getClass(), SSOUser.class)) {
            SSOUser ssoUser = (SSOUser) authentication.getPrincipal();
            try {
                User user = new User();
                user.setAccount(ssoUser.getUsername());
                user.setLastLoginTime(new Date());
                user.setLoginErrorCount(0);
                userMapper.updateByPrimaryKeySelective(user);
            } catch (Exception ex) {
                logger.error("登录成功日志记录异常", ex);
            }
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
