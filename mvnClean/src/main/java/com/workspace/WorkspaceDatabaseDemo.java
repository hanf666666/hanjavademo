package com.workspace;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2025/9/10
 */
public class WorkspaceDatabaseDemo {
    public static void main(String[] args) throws IOException {

        String srcFileName = "workspace.xml";

        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//            List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\ClearingPlat\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\backend-java\\meitian-activities\\", new FileFilter() {
        //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().indexOf(srcFileName) > -1) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {


            Path source = Paths.get(file.getPath());

            String parent = source.toFile().getParent();
            String dataSources0="dataSources.xml";
            String dataSources1="dataSources.local.xml";
            Path source0 = Paths.get(new File(parent+"\\"+dataSources0).getPath());
            Path source1 = Paths.get(new File(parent+"\\"+dataSources1).getPath());

            List<String> newlines0 = new ArrayList<>();
            newlines0.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project version=\"4\">\n" +
                    "  <component name=\"DataSourceManagerImpl\" format=\"xml\" multifile-model=\"true\">\n" +
                    "    <data-source source=\"LOCAL\" name=\"10.50.254.15pre\" uuid=\"956453cb-2487-44c6-bc24-00bcd65e400f\">\n" +
                    "      <driver-ref>mysql.8</driver-ref>\n" +
                    "      <synchronize>true</synchronize>\n" +
                    "      <remarks>10.50.254.15</remarks>\n" +
                    "      <jdbc-driver>com.mysql.cj.jdbc.Driver</jdbc-driver>\n" +
                    "      <jdbc-url>jdbc:mysql://10.50.254.15:3306/meisoocity</jdbc-url>\n" +
                    "      <jdbc-additional-properties>\n" +
                    "        <property name=\"com.intellij.clouds.kubernetes.db.host.port\" />\n" +
                    "        <property name=\"com.intellij.clouds.kubernetes.db.enabled\" value=\"false\" />\n" +
                    "        <property name=\"com.intellij.clouds.kubernetes.db.container.port\" />\n" +
                    "      </jdbc-additional-properties>\n" +
                    "      <working-dir>$ProjectFileDir$</working-dir>\n" +
                    "    </data-source>\n" +
                    "  </component>\n" +
                    "</project>");
            List<String> newlines1 = new ArrayList<>();
            newlines1.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project version=\"4\">\n" +
                    "  <component name=\"dataSourceStorageLocal\" created-in=\"IU-243.23654.117\">\n" +
                    "    <data-source name=\"10.50.254.15pre\" uuid=\"956453cb-2487-44c6-bc24-00bcd65e400f\">\n" +
                    "      <database-info product=\"MySQL\" version=\"8.0.30-txsql\" jdbc-version=\"4.2\" driver-name=\"MySQL Connector/J\" driver-version=\"mysql-connector-j-8.2.0 (Revision: 06a1f724497fd81c6a659131fda822c9e5085b6c)\" dbms=\"MYSQL\" exact-version=\"8.0.30\" exact-driver-version=\"8.2\">\n" +
                    "        <extra-name-characters>#@</extra-name-characters>\n" +
                    "        <identifier-quote-string>`</identifier-quote-string>\n" +
                    "        <jdbc-catalog-is-schema>true</jdbc-catalog-is-schema>\n" +
                    "      </database-info>\n" +
                    "      <case-sensitivity plain-identifiers=\"lower\" quoted-identifiers=\"lower\" />\n" +
                    "      <secret-storage>master_key</secret-storage>\n" +
                    "      <user-name>api_deploy</user-name>\n" +
                    "      <schema-mapping />\n" +
                    "    </data-source>\n" +
                    "  </component>\n" +
                    "</project>");


            // 重新写入文件（覆盖模式）
            Files.write(source0, newlines0);
            Files.write(source1, newlines1);

            System.out.println("文件修改成功！");

        }


    }

}


