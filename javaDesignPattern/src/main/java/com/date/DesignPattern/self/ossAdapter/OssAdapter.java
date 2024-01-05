package com.date.DesignPattern.self.ossAdapter;

public interface OssAdapter {
    String upload(String key, byte[] content);

    byte[] download(String key);
}
