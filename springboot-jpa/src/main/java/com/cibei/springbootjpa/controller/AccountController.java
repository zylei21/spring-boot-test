package com.cibei.springbootjpa.controller;

import com.cibei.springbootjpa.persistence.entity.Account1;
import com.cibei.springbootjpa.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 14:04
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account1 queryById(@PathVariable("id")int id){
        return accountService.queryById(id);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account1> queryList(){
        return accountService.queryList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Account1 update(@PathVariable("id")int id,
                          @RequestParam("name")String name,
                          @RequestParam("money")double money){
        Account1 account=new Account1();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        return accountService.update(account);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Account1 save(@RequestParam("id")int id,
                        @RequestParam("name")String name,
                        @RequestParam("money")double money){
        Account1 account=new Account1();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        return accountService.save(account);
    }
}
