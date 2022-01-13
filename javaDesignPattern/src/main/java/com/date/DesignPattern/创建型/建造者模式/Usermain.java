package com.date.DesignPattern.创建型.建造者模式;;

public class Usermain {
    public static void main(String[] args) {
        User user = User.builder().age(20).name("hanjing").nickName("????").
                password("123456").build();

        System.out.println(user);
    }
}
