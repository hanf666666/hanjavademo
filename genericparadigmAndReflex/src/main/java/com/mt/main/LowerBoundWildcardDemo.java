package com.mt.main;

/**
 * @author Hj
 * @date 2025/12/9
 */
import java.util.ArrayList;
import java.util.List;

// 父类
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// 子类1
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// 子类2
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class LowerBoundWildcardDemo {
    // 使用下界通配符：可以向 Animal 或其超类型的 List 中添加 Animal/子类型
    public static void addAnimal(List<? super Animal> animals, Animal animalToAdd) {
        animals.add(animalToAdd);  // 安全添加 Animal 或其子类型
        // Object obj = animals.get(0);  // 可以读取，但只能作为 Object
        // Animal a = animals.get(0);    // 编译错误！类型不确定
    }

    public static void main(String[] args) {
        // 创建不同类型的列表
        List<Animal> animalList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();  // Animal 的超类型

        // 方法能灵活向各种列表添加
        addAnimal(animalList, new Cat());  // 添加 Cat 到 List<Animal>
        addAnimal(objectList, new Dog());  // 添加 Dog 到 List<Object>

        // 打印验证
        ((Animal) animalList.get(0)).makeSound();  // 输出: Meow! (需强制转换读取)
        ((Animal) objectList.get(0)).makeSound();  // 输出: Woof!
    }
}