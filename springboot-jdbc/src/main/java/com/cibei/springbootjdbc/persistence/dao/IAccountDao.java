package com.cibei.springbootjdbc.persistence.dao;

import com.cibei.springbootjdbc.persistence.entity.Account;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 10:04
 */
public interface IAccountDao {

    int save(Account account);

    Account queryById(int id);

    int delete(Account account);

    int update(Account account);

    List<Account> queryList();
}
