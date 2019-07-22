package com.cibei.springbootjpa.persistence.dao;

import com.cibei.springbootjpa.persistence.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/30 13:42
 */
public interface IAccountDao extends JpaRepository<Account,Integer> {
}
