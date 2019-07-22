package com.cibei.springbootexcel.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/03 13:56
 */
public interface ICustomerService {
    String export(HttpServletResponse response,int start,int max);
}
