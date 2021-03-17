package com.github.io24m.oauth2.sso.mapper;

import com.github.io24m.oauth2.sso.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(String account);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String account);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateLastLoginTimeByPrimaryKey(User record);
}