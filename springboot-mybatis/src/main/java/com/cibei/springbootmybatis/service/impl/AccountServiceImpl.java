package com.cibei.springbootmybatis.service.impl;

import com.cibei.springbootmybatis.persistence.entity.Account;
import com.cibei.springbootmybatis.persistence.mapper.AccountMapper;
import com.cibei.springbootmybatis.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 21:26
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public int save(Account account) {
        return accountMapper.add(account.getName(),account.getMoney());
    }

    @Override
    public int delete(Account account) {
        return accountMapper.delete(account.getId());
    }

    @Override
    public int update(Account account) {
        return accountMapper.update(account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public Account queryById(int id) {
        return accountMapper.findAccount(id);
    }

    @Override
    public List<Account> queryAll() {
        return accountMapper.findAccountList();
    }
}
