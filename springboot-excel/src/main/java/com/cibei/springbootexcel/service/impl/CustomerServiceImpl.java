package com.cibei.springbootexcel.service.impl;

import com.cibei.springbootexcel.Utils.ExcelUtil;
import com.cibei.springbootexcel.persistence.dao.ICustomerDao;
import com.cibei.springbootexcel.persistence.entity.Customer;
import com.cibei.springbootexcel.service.ICustomerService;;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/03 13:58
 * <p>
 * `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号主键()',
 * `cust_name` varchar(32) NOT NULL COMMENT '客户名称',
 * `cust_source` varchar(32) NOT NULL COMMENT '客户信息来源',
 * `cust_industry` varchar(32) NOT NULL COMMENT '客户所属行业',
 * `cust_level` varchar(32) NOT NULL COMMENT '客户所属级别',
 * `cust_phone` varchar(64) NOT NULL COMMENT '客户固定电话',
 * `cust_mobile` varchar(64) NOT NULL COMMENT '客户移动电话',
 * `cust_image`
 */

@Service
public class CustomerServiceImpl implements ICustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private ICustomerDao customerDao;
    private List<Customer> queryAll(int start,int max){
        return customerDao.findAll();
    }

    private HSSFWorkbook createWorkbook(List<Customer> customers) {

        List<String> titles = Arrays.asList("id", "name", "source", "industry", "level", "phone", "mobile", "image");
        String sheetName = "联系人";
        HSSFWorkbook workbook = ExcelUtil.getExcelTemplate(null, sheetName, titles);
        HSSFSheet sheet = workbook.getSheet(sheetName);

        for (int i = 0; i < customers.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(customers.get(i).getId());
            row.createCell(1).setCellValue(customers.get(i).getName());
            row.createCell(2).setCellValue(customers.get(i).getSource());
            row.createCell(3).setCellValue(customers.get(i).getIndustry());
            row.createCell(4).setCellValue(customers.get(i).getLevel());
            row.createCell(5).setCellValue(customers.get(i).getPhone());
            row.createCell(6).setCellValue(customers.get(i).getMobile());
            if (customers.get(i).getImage() != null) {
                row.createCell(7).setCellValue(customers.get(i).getImage());
            }
        }
        return workbook;
    }
    private void setResponse(HttpServletResponse response, String fileName, HSSFWorkbook workbook) {

        // 设置文件名
        try {
            response.setContentType("application/vnd.ms-excel;charset=utf8");
            String codedFileName = new String((fileName+".xls").getBytes("UTF-8"),"ISO8859-1"); ;
            response.setHeader("content-disposition", "attachment;filename=" +codedFileName);
            response.setCharacterEncoding("UTF-8");
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            if(out!=null){
                out.flush();
                out.close();
            }
        }catch (IOException e){
            LOGGER.info(e.getMessage(),e);
        }
    }
    @Override
    public String export(HttpServletResponse response, int start, int max) {
        List<Customer> customers = queryAll(start, max);
        HSSFWorkbook workbook = createWorkbook(customers);
        LOGGER.info(workbook.toString());
        setResponse(response, "客户表", workbook);
        return "导出成功";
    }
}
