package com.github.io24m.oauth2.sso.config.websecurity;

import com.github.io24m.oauth2.sso.util.MD5Utils;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 15:00
 */
//@Component
public class UserPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return MD5Utils.encode(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode(charSequence).equals(s);
    }
}
