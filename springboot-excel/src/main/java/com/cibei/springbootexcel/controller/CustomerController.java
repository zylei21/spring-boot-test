package com.cibei.springbootexcel.controller;


import com.cibei.springbootexcel.service.ICustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;


/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/03 14:53
 */
@Api(description = "客户导出")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "/export")
    @ApiOperation(value = "导出表格",produces = "application/octet-stream")

    public String export(HttpServletResponse response){

        int  start=1;
        int max=15;
        return customerService.export(response,start,max);
    }

}
