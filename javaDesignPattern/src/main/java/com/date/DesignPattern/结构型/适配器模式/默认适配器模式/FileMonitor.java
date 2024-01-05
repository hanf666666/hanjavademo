package com.date.DesignPattern.结构型.适配器模式.默认适配器模式;

import java.io.File;

public class FileMonitor extends FileAlterationListenerAdaptor {
    @Override
    public void onDirectoryCreate(File directory) {
        super.onDirectoryCreate(directory);
        // 文件创建
        //doSomething()
        System.out.println("doSomething()");
    }


    public void onFileDelete(final File file) {
        // 文件删除
        //doSomething();
        System.out.println("doSomething()");
    }


}
