package com.github.io24m.oauth2.sso.util;

import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

/**
 * @author lk1
 * @description
 * @create 2021-03-17 8:58
 */
public final class MD5Utils {
    public static String encode(String s) {
        byte[] bytes = DigestUtils.md5Digest(s.getBytes());
        byte[] encode = Base64Utils.encode(bytes);
        return new String(encode);
    }
}
