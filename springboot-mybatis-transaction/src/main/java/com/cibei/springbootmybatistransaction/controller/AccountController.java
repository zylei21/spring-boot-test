package com.cibei.springbootmybatistransaction.controller;

import com.cibei.springbootmybatistransaction.persistence.entity.Account;
import com.cibei.springbootmybatistransaction.service.IAccountService;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/01 19:19
 */
@RestController
@RequestMapping("/account")
//@MapperScan("com.cibei.springbootmybatistransaction.persistence.mapper")
public class AccountController {

    @Autowired
    private IAccountService accountService;
    @PutMapping("/{id}")
    public void update(@PathVariable("id")int id, @Param("money")Double money){
        Account account=new Account();
        account.setId(id);
        account.setMoney(money);
        accountService.update(account);
    }

    @GetMapping("/{id}")
    public Account queryById(@PathVariable("id")Integer id){
        return accountService.queryById(id);
    }

}
