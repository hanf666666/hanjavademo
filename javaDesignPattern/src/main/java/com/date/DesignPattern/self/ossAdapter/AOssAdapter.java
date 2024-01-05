package com.date.DesignPattern.self.ossAdapter;

public class AOssAdapter implements OssAdapter {
    @Override
    public String upload(String key, byte[] content) {
        System.out.println("AOssAdapter upload: " + key+" content "+new String(content));
        return null;
    }

    @Override
    public byte[] download(String key) {
        System.out.println("AOssAdapter download: " + key);
        return new byte[0];
    }
}
