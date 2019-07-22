package com.cibei.springbootjdbc.service.impl;

import com.cibei.springbootjdbc.persistence.dao.IAccountDao;
import com.cibei.springbootjdbc.persistence.entity.Account;
import com.cibei.springbootjdbc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 10:28
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Override
    public int save(Account account) {
        return accountDao.save(account);
    }

    @Override
    public int delete(Account account) {
        return accountDao.delete(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public Account queryById(int id) {
        return accountDao.queryById(id);
    }

    @Override
    public List<Account> queryList() {
        return accountDao.queryList();
    }
}
