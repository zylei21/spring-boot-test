package com.cibei.springbootmybatistransaction.persistence.mapper;

import com.cibei.springbootmybatistransaction.persistence.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/01 19:09
 */
@Mapper
public interface AccountMapper {
    void update(Account account);
    Account queryById(Integer id);
}
