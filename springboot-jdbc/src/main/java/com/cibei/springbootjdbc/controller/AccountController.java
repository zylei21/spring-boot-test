package com.cibei.springbootjdbc.controller;

import com.cibei.springbootjdbc.persistence.entity.Account;
import com.cibei.springbootjdbc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 10:30
 */
@RestController
@RequestMapping("/account")
@SuppressWarnings("all")

public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account queryById(@PathVariable("id")int id){
        return accountService.queryById(id);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> queryList(){
        return accountService.queryList();
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public int save(@PathVariable("id")int id,@RequestParam("name")String name,
                    @RequestParam("money")double money){
        Account account=new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        return accountService.save(account);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public int update(@PathVariable("id")int id,@RequestParam("money")double money){
        Account account=new Account();
        account.setId(id);
        account.setMoney(money);
        return accountService.update(account);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public int delete(@PathVariable("id")int id,@RequestParam("name")String name,
                      @RequestParam("money")double money){
        Account account=new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        return accountService.delete(account);
    }
}
