package com.cibei.springbootjpa.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/01 18:36
 */
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Account1 {

        @Id
        @GeneratedValue
        private Integer id;

        private String name;

        private Double money;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getMoney() {
            return money;
        }

        public void setMoney(Double money) {
            this.money = money;
        }
}
