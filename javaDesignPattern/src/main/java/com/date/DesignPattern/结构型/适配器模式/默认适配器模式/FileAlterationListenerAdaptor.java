package com.date.DesignPattern.结构型.适配器模式.默认适配器模式;

import java.io.File;

/**
 * FileAlterationListenerAdaptor的子类只需要实现其中几个子方法
 * 简洁作用(减少方法)
 */
public class FileAlterationListenerAdaptor implements FileAlterationListener {
    @Override
    public void onStart(FileAlterationObserver observer) {

    }

    @Override
    public void onDirectoryCreate(File directory) {

    }

    @Override
    public void onDirectoryChange(File directory) {

    }

    @Override
    public void onDirectoryDelete(File directory) {

    }

    @Override
    public void onFileCreate(File file) {

    }

    @Override
    public void onFileChange(File file) {

    }

    @Override
    public void onFileDelete(File file) {

    }

    @Override
    public void onStop(FileAlterationObserver observer) {

    }
}
