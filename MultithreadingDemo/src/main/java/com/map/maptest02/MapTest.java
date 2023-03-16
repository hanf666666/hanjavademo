package com.map.maptest02;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * https://blog.csdn.net/weixin_45301250/article/details/119962402
 * @ClassName MapTest
 * @Description HashMap线程安全测试类
 * @Author 狂奔の蜗牛rz
 * @Date 2021/8/2
 *  并发put会报错
 */
public class MapTest {

    public static void main(String[] args) {

        //创建一个HashMap对象
        Map<String, String> map = new HashMap<>();

        //用循环模拟多线程环境
        for (int i = 0; i < 30; i++) {
            //创建线程
            new Thread(() -> {
                //向map中放入值: key键对应当前线程的名字, value值对应从数组中从0到5的随机字符串
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                //打印map集合
                System.out.println(map);
                //获取数组中下标i位置的字符串, 并且启动线程
            }, String.valueOf(i)).start();
        }
    }

}


