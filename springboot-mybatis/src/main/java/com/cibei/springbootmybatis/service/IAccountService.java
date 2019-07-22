package com.cibei.springbootmybatis.service;

import com.cibei.springbootmybatis.persistence.entity.Account;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 21:25
 */
public interface IAccountService {
    int save(Account account);
    int delete(Account account);
    int update(Account account);
    Account queryById(int id);
    List<Account> queryAll();
}
