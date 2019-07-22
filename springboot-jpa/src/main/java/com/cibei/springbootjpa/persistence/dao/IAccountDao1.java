package com.cibei.springbootjpa.persistence.dao;

import com.cibei.springbootjpa.persistence.entity.Account1;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/01 18:37
 */
public interface IAccountDao1 extends JpaRepository<Account1,Integer> {
}
