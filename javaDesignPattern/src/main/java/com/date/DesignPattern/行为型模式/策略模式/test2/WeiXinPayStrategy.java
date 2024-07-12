package com.date.DesignPattern.行为型模式.策略模式.test2;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public class WeiXinPayStrategy implements Strategy {
    @Override
    public String operate() {
        System.out.println("WeiXinPayStrategy");
        return "WeiXinPayStrategy";
    }


    public String operate2() {
        System.out.println("H5WeiXinPayStrategy");
        return "H5WeiXinPayStrategy";
    }

}
