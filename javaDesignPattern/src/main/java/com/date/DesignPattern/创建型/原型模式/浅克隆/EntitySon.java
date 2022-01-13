package com.date.DesignPattern.创建型.原型模式.浅克隆;

/**
 *
 */
public class EntitySon {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EntitySon{" +
                "name='" + name + '\'' +
                '}';
    }
}
