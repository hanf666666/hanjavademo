package com.mt.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hj
 * @date 2025/12/9
 */
public class UpperBoundWildcardDemo {
    // 父类
    static class Animal {
        public void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }

    // 子类1
    static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Meow!");
        }
    }

    // 子类2
    static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Woof!");
        }
    }


    // 使用上界通配符：可以接受 Animal 或其子类的 List
    public static void printAnimalSounds(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.makeSound();  // 安全读取并调用方法
        }
        // animals.add(new Cat());  // 编译错误！不能添加，因为类型不确定
        // animals.add(new Animal());  // 也错误，只能添加 null
    }

    public static void main(String[] args) {
        // 创建不同类型的列表
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());

        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());

        // 方法能灵活处理各种列表
        printAnimalSounds(animalList);  // 输出: Animal makes a sound
        printAnimalSounds(catList);     // 输出: Meow!
        printAnimalSounds(dogList);     // 输出: Woof!
    }


}
