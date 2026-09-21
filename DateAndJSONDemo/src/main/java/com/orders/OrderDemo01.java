package com.orders;

/**
 * @author Hj
 * @date 2026/9/21
 */
import java.util.*;
import java.util.stream.*;

public class OrderDemo01 {

    // 自定义对象：学生
    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return name + "(" + score + ")";
        }
    }

    public static void main(String[] args) {

        // =========================================================
        // 1. List<Integer> 降序
        // =========================================================
        System.out.println("===== 1. List<Integer> 降序 =====");

        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 5, 4));

        // 方式一：list.sort + Comparator.reverseOrder()
        list.sort(Comparator.reverseOrder());
        System.out.println("list.sort 降序: " + list);

        // 方式二：Collections.sort + Comparator.reverseOrder()
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 1, 2));
        Collections.sort(list2, Comparator.reverseOrder());
        System.out.println("Collections.sort 降序: " + list2);

        // =========================================================
        // 2. Integer[] 数组降序
        // =========================================================
        System.out.println("\n===== 2. Integer[] 数组降序 =====");

        Integer[] arr = {3, 1, 2, 5, 4};
        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println("Integer[] 降序: " + Arrays.toString(arr));

        // =========================================================
        // 3. int[] 数组降序
        // 注意：int[] 是基本类型，不能直接传 Comparator
        // =========================================================
        System.out.println("\n===== 3. int[] 数组降序 =====");

        int[] intArr = {3, 1, 2, 5, 4};

        // 方式一：先升序，再反转
        int[] intArr1 = intArr.clone();
        Arrays.sort(intArr1); // 升序：[1, 2, 3, 4, 5]

        for (int i = 0, j = intArr1.length - 1; i < j; i++, j--) {
            int tmp = intArr1[i];
            intArr1[i] = intArr1[j];
            intArr1[j] = tmp;
        }
        System.out.println("int[] 先升序再反转: " + Arrays.toString(intArr1));

        // 方式二：转成 Integer 流，降序后再转回 int[]
        //.boxed() 是 Java Stream 里的一个方法，意思是：把基本类型流，装箱成对应的包装类型流。
        int[] intArr2 = Arrays.stream(intArr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("int[] 使用 Stream 降序: " + Arrays.toString(intArr2));

        // =========================================================
        // 4. 自定义对象按字段降序
        // =========================================================
        System.out.println("\n===== 4. 自定义对象按字段降序 =====");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("张三", 90),
                new Student("李四", 85),
                new Student("王五", 95),
                new Student("赵六", 90)
        ));

        // 只按分数降序
        List<Student> studentArrayList = new ArrayList<>(students);
        studentArrayList.sort(
                Comparator.comparingInt(Student::getScore).reversed()
        );
        System.out.println("按分数降序: " + studentArrayList);

        // 分数降序；如果分数相同，再按姓名升序
        List<Student> byScoreDescThenNameAsc = new ArrayList<>(students);
        byScoreDescThenNameAsc.sort(
                Comparator.comparingInt(Student::getScore).reversed()
                        .thenComparing(Student::getName)
        );
        System.out.println("分数降序，同分姓名升序: " + byScoreDescThenNameAsc);

        // =========================================================
        // 5. Stream 降序
        // =========================================================
        System.out.println("\n===== 5. Stream 降序 =====");

        List<Integer> streamDesc = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Stream collect 降序: " + streamDesc);

        // Java 16+ 可以简写为：
        // List<Integer> streamDesc2 = list.stream()
        //         .sorted(Comparator.reverseOrder())
        //         .toList();

        // =========================================================
        // 6. Map 按 value 降序
        // =========================================================
        System.out.println("\n===== 6. Map 按 value 降序 =====");

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 3);
        map.put("b", 1);
        map.put("c", 2);
        map.put("ff", 2);
        map.put("d", 5);
        map.put("e", 4);

        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<String, Integer>comparingByKey()))
                 .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        System.out.println("Map 按 value 降序: " + sortedMap);
    }
}
