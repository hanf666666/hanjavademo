package com.date.DesignPattern.self.ossAdapter;

import java.util.HashMap;
import java.util.Map;

public class BusinessServiceMain {
    public static void main(String[] args) {

        BusinessServiceMain main = new BusinessServiceMain();
        Boolean key = main.getif("key");
        if (key) {
            main.writeData("A", "key", "content".getBytes());
        }
        main.readData("A", "key");
         main.readData("B", "key");
         main.writeData("B", "key","content...............".getBytes());

    }

    private Boolean getif(String key) {
        return true;
    }

    private final Map<String, OssAdapter> ossAdapters = new HashMap<>();

    public BusinessServiceMain() {
        ossAdapters.put("A", new AOssAdapter());
        ossAdapters.put("B", new BOssAdapter());
    }

    public String writeData(String source, String key, byte[] content) {
        OssAdapter adapter = ossAdapters.get(source);
        if (adapter != null) {
            return adapter.upload(key, content);
        } else {
            throw new IllegalArgumentException("Invalid source: " + source);
        }
    }

    public byte[] readData(String source, String key) {
        OssAdapter adapter = ossAdapters.get(source);
        if (adapter != null) {
            return adapter.download(key);
        } else {
            throw new IllegalArgumentException("Invalid source: " + source);
        }
    }

}
