package com.scandemo.Migrate;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/1/9
 */
public class MigrateScheduledDemo {
    public static void main(String[] args) {

        String srcFileName = ".java";
        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage\\meisoo-bossmanage-service\\", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
//                if (true) {
                if (pathname.getName().indexOf(srcFileName) > -1) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file)); ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("@Scheduled")) {
                        System.out.println(file.getPath() + " === " + line);
                    }
                }

            } catch (IOException e) {
            }


        }
    }
}
