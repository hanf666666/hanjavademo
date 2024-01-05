package com.date.DesignPattern.self.ossAdapter;

public class BOssAdapter implements OssAdapter {
    @Override
    public String upload(String key, byte[] content) {
        System.out.println("BOssAdapter upload: " + key+" content"+new String(content));
        return null;
    }

    @Override
    public byte[] download(String key) {
        System.out.println("BOssAdapter download: " + key);
        return new byte[0];
    }
}
