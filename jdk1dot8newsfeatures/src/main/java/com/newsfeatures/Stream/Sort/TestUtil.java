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
        Student stu1 = new Student("С��", 1,2);
        Student stu2 = new Student("С��", 2,2);
        Student stu3 = new Student("С��", 3,2);
        Student stu4 = new Student("С��", null,2);

        List<Student> list = new ArrayList<>();
        list.add(stu2);
        list.add(stu1);
        list.add(stu3);
        list.add(stu4);

        System.out.println("����ǰ��");
        System.out.println(list);
        stu4.setAge(0);
        System.out.println("�����");
//        list = list.stream().sorted((o1, o2) -> o1.getAge() ).collect(Collectors.toList());
        list = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        System.out.println(list);
    }
}
