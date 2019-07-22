package com.cibei.springbootexcel.Utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.OutputStream;
import java.util.List;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/03 9:47
 *
 * 首先，我们应该要知道的是，一个Excel文件对应一个workbook，一个workbook中有多个sheet组成，一个sheet是由多个行(row)和列(cell)组成。那么我们用poi要导出一个Excel表格
 *
 * 的正确顺序应该是：
 *
 * 1、用HSSFWorkbook打开或者创建“Excel文件对象”
 *
 * 2、用HSSFWorkbook对象返回或者创建Sheet对象
 *
 * 3、用Sheet对象返回行对象，用行对象得到Cell对象
 *
 * 4、对Cell对象读写。
 *
 * 5、将生成的HSSFWorkbook放入HttpServletResponse中响应到前端页面
 *
 */
public class ExcelUtil {
    public static HSSFWorkbook getExcelTemplate(HSSFWorkbook workbook, String sheetName, List<String> titles){
        //1.创建workbook
        if (workbook==null){
            workbook=new HSSFWorkbook();
        }
        //2.创建sheet
        HSSFSheet sheet=workbook.createSheet(sheetName);

        //3.创建首行row对象
        HSSFRow row = sheet.createRow(0);
        //4.创建格式
        HSSFCellStyle style=workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //5.向首行添加标题
        HSSFCell cell=null;
        for (int i=0;i< titles.size();i++){
            cell=row.createCell(i);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(style);
        }
        return workbook;
    }
}
