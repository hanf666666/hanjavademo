package com.file.hutoolexcel;

/**
 * @author Hj
 * @date 2025/6/4
 */

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class DeleteSheetDemo01 {

    public static void main(String[] args) throws Exception {

        // 加载Excel文件（需替换为实际路径）
        ExcelWriter writer = ExcelUtil.getWriter("C:\\Users\\han\\Desktop\\meisoocity\\aa.xls");

        for (Sheet sheet:writer.getSheets()){
            try {
                if(Long.parseLong(sheet.getSheetName())<202405){
                    // 删除名为"Sheet1"的Sheet页
                    int sheetIndex = writer.getWorkbook().getSheetIndex(sheet.getSheetName());
                    if (sheetIndex >= 0) {
                        writer.setSheet(sheetIndex); // 切换到目标Sheet
                        writer.getWorkbook().removeSheetAt(sheetIndex); // 删除Sheet
                    }
                }
            } catch (NumberFormatException e) {

            }


        }


        // 保存修改后的文件
        writer.flush(new File("C:\\Users\\han\\Desktop\\meisoocity\\aa.xlsx"));
        writer.close();

    }
}