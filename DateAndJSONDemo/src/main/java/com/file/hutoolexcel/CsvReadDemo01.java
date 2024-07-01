package com.file.hutoolexcel;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;

import java.io.BufferedReader;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/6/19
 */
public class CsvReadDemo01 {
    public static void main(String[] args) {
        CsvReader reader = CsvUtil.getReader();


        BufferedReader reader1 = ResourceUtil.getReader(
                "C:\\Users\\han\\Desktop\\meisoocity\\aaaa.csv",
                CharsetUtil.CHARSET_GBK);
        List<PlateDTO> read = reader.read(reader1, PlateDTO.class);

        System.out.println(read);

    }
}
