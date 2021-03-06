package com.github.io24m.oauth2.config.websecurity;

import com.github.io24m.oauth2.service.user.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 16:24
 */
@Configuration
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public AuthenticationFailureHandler() {
        super.setDefaultFailureUrl("/login");
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        super.onAuthenticationFailure(request, response, exception);
    }
}
