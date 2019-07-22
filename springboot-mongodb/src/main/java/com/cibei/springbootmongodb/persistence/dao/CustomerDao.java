package com.cibei.springbootmongodb.persistence.dao;

import com.cibei.springbootmongodb.persistence.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 9:56
 *
 * 继承了MongoRepository之后,具备crud的方法,如果自定义方法,需要严格按着属性名称来
 */
public interface CustomerDao extends MongoRepository<Customer,Integer> {

    Customer findByFirstName(String firstName);

    Customer findBySecondName(String secondName);
}
