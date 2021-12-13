package com.it.test08_匿名内部类讲解;

public class Test03_Player {
    public static void main(String[] args) {
        //需求: 调用Player#play();
//        new Player() {
//            @Override
//            public void play() {
//                System.out.println("为了学好大数据, 就不要玩儿游戏了, 玩儿了你也是个坑");
//            }
//        }.play();

        //多态
        //Player p = Player接口的子类对象;
        Player p =  new Player() {
            @Override
            public void play() {
                System.out.println("为了学好大数据, 就不要玩儿游戏了, 玩儿了你也是个坑");
            }
        };
        p.play();
    }
}
