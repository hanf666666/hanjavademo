package com.date.DesignPattern.�ṹ��.������ģʽ.Ĭ��������ģʽ;

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
