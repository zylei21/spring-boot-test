package com.cibei.springbootexcel.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 17:38
 *
 * `cust_id` BIGINT ( 32 ) NOT NULL AUTO_INCREMENT COMMENT '客户编号主键()',
 * 	`cust_name` VARCHAR ( 32 ) NOT NULL COMMENT '客户名称',
 * 	`cust_source` VARCHAR ( 32 ) NOT NULL COMMENT '客户信息来源',
 * 	`cust_industry` VARCHAR ( 32 ) NOT NULL COMMENT '客户所属行业',
 * 	`cust_level` VARCHAR ( 32 ) NOT NULL COMMENT '客户所属级别',
 * 	`cust_phone` VARCHAR ( 64 ) NOT NULL COMMENT '客户固定电话',
 * 	`cust_mobile` VARCHAR ( 64 ) NOT NULL COMMENT '客户移动电话',
 * 	`cust_image` VARCHAR ( 64 ) DEFAULT NULL,
 * 	PRIMARY KEY ( `cust_id` ),
 *
 */
@Entity(name = "cst_customer")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Customer {
    @Id
    @Column(name = "cust_id")
    private Long id;
    @Column(name = "cust_name")
    private String name;
    @Column(name = "cust_source")
    private String source;
    @Column(name = "cust_industry")
    private String industry;
    @Column(name = "cust_level")
    private String level;
    @Column(name = "cust_phone")
    private String phone;
    @Column(name = "cust_mobile")
    private String mobile;
    @Column(name = "cust_image")
    private String image;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", industry='" + industry + '\'' +
                ", level='" + level + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
