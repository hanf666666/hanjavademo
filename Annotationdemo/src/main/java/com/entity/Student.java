package com.entity;

/**
 * to do
 *
 * @author Hj
 * @date 2021/9/12
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name=name;
    }
    public Student() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
