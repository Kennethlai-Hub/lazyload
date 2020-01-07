package com.ibranco.mybatis.lazyload.mapper;

import com.ibranco.mybatis.lazyload.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();



}
