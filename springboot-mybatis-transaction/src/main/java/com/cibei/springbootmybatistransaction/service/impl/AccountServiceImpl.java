package com.cibei.springbootmybatistransaction.service.impl;

import com.cibei.springbootmybatistransaction.persistence.entity.Account;
import com.cibei.springbootmybatistransaction.persistence.mapper.AccountMapper;
import com.cibei.springbootmybatistransaction.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/01 19:15
 */
@Service
@SuppressWarnings("all")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    AccountMapper accountMapper;
    @Override
    @Transactional
    public void update(Account account) {
        accountMapper.update(account);
    }

    @Override
    public Account queryById(Integer id) {
        return accountMapper.queryById(id);
    }
}
