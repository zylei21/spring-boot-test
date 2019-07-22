package com.cibei.springbootjdbc.persistence.dao.impl;

import com.cibei.springbootjdbc.persistence.dao.IAccountDao;
import com.cibei.springbootjdbc.persistence.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 10:07
 */

@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Account account) {
        return jdbcTemplate.update("insert into account (name,money) values (?,?)",account.getName(),account.getMoney());
    }

    @Override
    public Account queryById(int id) {
        List<Account> list = jdbcTemplate.query("select * from account where id= ?", new Object[]{id}, new BeanPropertyRowMapper(Account.class));
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public int delete(Account account) {
        return jdbcTemplate.update("delete account where id=? and name= ? and money= ?",account.getId(),
                account.getName(),account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("update account set money =? where id= ?",account.getMoney(),
                account.getId());
    }

    @Override
    public List<Account> queryList() {
        List<Account> list = jdbcTemplate.query("select * from account", new Object[]{}, new BeanPropertyRowMapper<>(Account.class));
        if (!list.isEmpty()){
            return list;
        }
        return null;
    }
}
