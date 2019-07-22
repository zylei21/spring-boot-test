package com.cibei.springbootmongodb.persistence.entity;

import org.springframework.data.annotation.Id;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 9:52
 */
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String secondName;

    public Customer(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
