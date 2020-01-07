package com.ibranco.mybatis.lazyload.mapper;

import com.ibranco.mybatis.lazyload.domain.Account;

import java.util.List;

public interface AccountMapper {
    List<Account> findAll();
}
