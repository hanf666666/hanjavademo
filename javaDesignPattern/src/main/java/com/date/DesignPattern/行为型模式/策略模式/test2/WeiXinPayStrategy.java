package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test2;

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
