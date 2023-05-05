package com.services;

import java.util.ServiceLoader;

public class Maintest {
    public static void main(String[] args) {
        ServiceLoader<HelloService> loaders = ServiceLoader.load(HelloService.class);
        for(HelloService helloService : loaders){
            helloService.printData();
        }
    }
}
