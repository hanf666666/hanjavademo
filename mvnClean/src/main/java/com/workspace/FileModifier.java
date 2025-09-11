package com.workspace;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2025/9/11
 */
public class FileModifier {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String newContent = "This is the new content.\n";
        boolean appendMode = true; // 设为false则为覆盖模式

        modifyFile(filePath, newContent, appendMode);
    }

    public static void modifyFile(String filePath, String content, boolean append) {
        try {
            Path path = Paths.get(filePath);
            if (append) {
                // 追加内容
                Files.write(path, content.getBytes(), StandardOpenOption.APPEND);
            } else {
                // 覆盖内容
                Files.write(path, content.getBytes());
            }
            System.out.println("文件修改成功！");
        } catch (IOException e) {
            System.err.println("错误: " + e.getMessage());
        }
    }
}
