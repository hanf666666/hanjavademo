package com.executor.demo;

import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Order order = new Order();

        Goods[] goodsArray = new Goods[3];
        order.setGoodsArray(goodsArray);
        System.out.println("请输入商品信息，格式如下：");
        System.out.println("商品名称 商品价格 商品数量");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < goodsArray.length; i++) {
            String line = scanner.nextLine();
            String [] segments =line.split(" ");
            goodsArray[i] = new Goods(segments[0],
                    Double.parseDouble(segments[1]),
                    Integer.parseInt(segments[2]));
        }
        System.out.println("请输入折扣 1-9的整数：");
        String discountstr = scanner.nextLine();
        order.setDiscount(Integer.parseInt(discountstr));
        Double totalPrice = order.getTotalPrice();
        System.out.println("总金额为："+totalPrice);
        System.out.println("请输入支付金额：");
        String paystr = scanner.nextLine();
        order.setPay(Double.parseDouble(paystr));
        System.out.println(order);
    }

}
