package com.newsfeatures.Stream.Sort;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/29
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtil {
    public static void main(String[] args) {
        Student stu1 = new Student("小米", 1,2);
        Student stu2 = new Student("小王", 2,2);
        Student stu3 = new Student("小明", 3,2);
        Student stu4 = new Student("小韩", null,2);

        List<Student> list = new ArrayList<>();
        list.add(stu2);
        list.add(stu1);
        list.add(stu3);
        list.add(stu4);

        System.out.println("排序前：");
        System.out.println(list);
        stu4.setAge(0);
        System.out.println("排序后：");
//        list = list.stream().sorted((o1, o2) -> o1.getAge() ).collect(Collectors.toList());
        list = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        System.out.println(list);
    }
}
