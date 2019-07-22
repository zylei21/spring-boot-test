package com.cibei.springbootmybatis.controller;

import com.cibei.springbootmybatis.persistence.entity.Account;
import com.cibei.springbootmybatis.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 21:31
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    IAccountService accountService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account queryById(@PathVariable("id")int id){
        return accountService.queryById(id);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> queryList(){
        return accountService.queryAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public int update(@PathVariable("id")int id,
                          @RequestParam("name")String name,
                          @RequestParam("money")double money){
        Account account=new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        return accountService.update(account);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public int save(@RequestParam("id")int id,
                        @RequestParam("name")String name,
                        @RequestParam("money")double money){
        Account account=new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        return accountService.save(account);
    }
}
