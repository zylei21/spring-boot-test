package com.cibei.springbootjpa.service.impl;

import com.cibei.springbootjpa.persistence.dao.IAccountDao;
import com.cibei.springbootjpa.persistence.dao.IAccountDao1;
import com.cibei.springbootjpa.persistence.entity.Account;
import com.cibei.springbootjpa.persistence.entity.Account1;
import com.cibei.springbootjpa.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 13:54
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao1 accountDao;
    @Override
    public Account1 save(Account1 account) {
        return accountDao.save(account);
    }

    @Override
    public void delete(Account1 account) {
        accountDao.delete(account);
    }

    @Override
    public Account1 update(Account1 account) {
        return accountDao.saveAndFlush(account);
    }

    @Override
    public Account1 queryById(int id) {
        return accountDao.getOne(id);
    }

    @Override
    public List<Account1> queryList() {
        return accountDao.findAll();
    }
}
