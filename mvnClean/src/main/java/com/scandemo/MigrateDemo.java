package com.scandemo;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/1/9
 */
public class MigrateDemo {
    public static void main(String[] args) {

        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java\\common_service\\meisoo-manage-rbac-service", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().indexOf("application-k8sdev.properties") > -1) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {
            Path source = Paths.get(file.getPath());
            Path destination = Paths.get(file.getParent()+"//application-txdev.properties");
            try {
                System.out.println(file.getPath());
                System.out.println(file.getParent());
                Files.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                File sourceFile =source.toFile();
                File destinationFile = destination.toFile();

                try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        // 修改每一行的内容，这里只是一个简单的示例，你可以根据需要进行修改
                        String modifiedLine = line.replace("mysql-service.dev.svc.cluster.local", "10.50.254.22");
                        writer.write(modifiedLine);
                        writer.newLine(); // 写入一个新行
                    }
                    System.out.println("文件修改成功！");
                } catch (IOException e) {
                    System.err.println("文件修改失败: " + e.getMessage());
                }
            }



        }
    }
}
