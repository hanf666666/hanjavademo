package com.set;


import cn.hutool.core.date.DateUtil;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. 【强制】关于 hashCode 和 equals 的处理，遵循如下规则：
 * @author Hj
 * @date 2025/12/2
 */
public class EqualsToListExample {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String localTime = sdf.format(new Date()); // 需手动设置时区
        System.out.println(localTime);
        System.out.println(DateUtil.date().toDateStr());

        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 12.10));
        pairArrayList.add(new Pair<>("version", 12.19));
        pairArrayList.add(new Pair<>("version", 6.28));
        Map<String, Double> map = pairArrayList.stream().collect(
// 生成的 map 集合中只有一个键值对：{version=6.28}
                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));

//        在使用 java.util.stream.Collectors 类的 toMap()方法转为 Map 集合时，一定要使
//        用含有参数类型为 BinaryOperator，参数名为 mergeFunction 的方法，否则当出现相同 key
//        值时会抛出 IllegalStateException 异常
        String[] departments = new String[] {"iERP", "iERP", "EIBU"};

        //7. 【强制】Collections 类返回的对象，如：emptyList()/singletonList()等都是 immutable list，
        Map<Integer, String> map2 = Arrays.stream(departments)
                .collect(Collectors.toMap(String::hashCode, str -> str,(v1, v2) -> v2));
        List<Object> list = Collections.emptyList();
//        list.add("aaaa");

        // 对象 1
        Persion p1 = new Persion();
        p1.setName("Java");
        p1.setAge(18);
        // 对象 2
        Persion p2 = new Persion();
        p2.setName("Java");
        p2.setAge(18);
        // 创建 Set 对象
        Set<Persion> set = new HashSet<Persion>();
        set.add(p1);
        set.add(p2);
        // 打印 Set 中的所有数据
        set.forEach(p -> {
            System.out.println(p);
        });
    }
}


class Persion {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 引用相等返回 true
        // 如果等于 null，或者对象类型不同返回 false
        if (o == null || getClass() != o.getClass()) return false;
        // 强转为自定义 Persion 类型
        Persion persion = (Persion) o;
        // 如果 age 和 name 都相等，就返回 true
        return age == persion.age &&
                Objects.equals(name, persion.name);
    }

    @Override
    public int hashCode() {
        // 对比 name 和 age 是否相等
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
