package com.cibei.springbootexcel.persistence.mapper;

import com.cibei.springbootexcel.persistence.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/03 14:47
 */
@Mapper
public interface CustomerMapper {

    @Select("select * from cst_customer limit #{start},#{max}")
    List<Customer> queryPage(@Param("start")int start,@Param("max") int max);
}
