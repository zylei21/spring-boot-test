package com.cibei.springbootjpa.service;


import com.cibei.springbootjpa.persistence.entity.Account;
import com.cibei.springbootjpa.persistence.entity.Account1;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 13:46
 */
public interface IAccountService {
    Account1 save(Account1 account);

    void delete(Account1 account);

    Account1 update(Account1 account);

    Account1 queryById(int id);

    List<Account1> queryList();
}
