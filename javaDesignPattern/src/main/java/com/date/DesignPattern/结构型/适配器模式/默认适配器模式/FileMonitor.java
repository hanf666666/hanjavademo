package com.date.DesignPattern.结构型.适配器模式.默认适配器模式;

import java.io.File;

public class FileMonitor extends FileAlterationListenerAdaptor {
    @Override
    public void onDirectoryCreate(File directory) {
        super.onDirectoryCreate(directory);
        System.out.println("???????");
    }

    @Override
    public void onDirectoryChange(File directory) {
        super.onDirectoryChange(directory);
        System.out.println("??????");
    }

    @Override
    public void onDirectoryDelete(File directory) {
        super.onDirectoryDelete(directory);
        System.out.println("??????");
    }
}
