package com.it.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Properties;

public class PropsUtil implements Serializable {

    private  Properties props = null;

    public PropsUtil(String fileName) {
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropsUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  String getProps(String key) {
        return props.getProperty(key);
    }
}
