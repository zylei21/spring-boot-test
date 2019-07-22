package com.cibei.springbootexcel.persistence.dao;

import com.cibei.springbootexcel.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 17:40
 */
public interface ICustomerDao extends JpaRepository<Customer,Integer> {
}
