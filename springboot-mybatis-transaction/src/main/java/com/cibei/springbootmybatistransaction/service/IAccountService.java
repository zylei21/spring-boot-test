package com.cibei.springbootmybatistransaction.service;

import com.cibei.springbootmybatistransaction.persistence.entity.Account;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/01 19:14
 */
public interface IAccountService {
    void update(Account account);

    Account queryById(Integer id);
}
