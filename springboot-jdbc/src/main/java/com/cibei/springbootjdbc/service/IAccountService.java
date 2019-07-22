package com.cibei.springbootjdbc.service;

import com.cibei.springbootjdbc.persistence.entity.Account;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 10:26
 */
public interface IAccountService {
    int save(Account account);

    int delete(Account account);

    int update(Account account);

    Account queryById(int id);

    List<Account> queryList();
}
