package com.cibei.springbootmongodb;

import com.cibei.springbootmongodb.persistence.dao.CustomerDao;
import com.cibei.springbootmongodb.persistence.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootMongodbApplication implements CommandLineRunner {

    @Autowired
    CustomerDao customerDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        customerDao.deleteAll();

        //先加两条数据
        customerDao.save(new Customer("张三","张炬"));
        customerDao.save(new Customer("李四","李活"));

        //打印数据库中的数据
        System.out.println("===========================================");
        List<Customer> list = customerDao.findAll();
        for (Customer customer:list){
            System.out.println(customer);
        }

        //根据firstName查询 secondName查询
        System.out.println("===========================================");
        Customer customer = customerDao.findByFirstName("李四");
        System.out.println(customer);
        Customer customer1 = customerDao.findBySecondName("张炬");
        System.out.println(customer1);
    }
}
