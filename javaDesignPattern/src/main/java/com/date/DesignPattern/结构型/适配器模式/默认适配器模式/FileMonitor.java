package com.date.DesignPattern.�ṹ��.������ģʽ.Ĭ��������ģʽ;

import java.io.File;

public class FileMonitor extends FileAlterationListenerAdaptor {
    @Override
    public void onDirectoryCreate(File directory) {
        super.onDirectoryCreate(directory);
        // �ļ�����
        //doSomething()
        System.out.println("doSomething()");
    }


    public void onFileDelete(final File file) {
        // �ļ�ɾ��
        //doSomething();
        System.out.println("doSomething()");
    }


}
