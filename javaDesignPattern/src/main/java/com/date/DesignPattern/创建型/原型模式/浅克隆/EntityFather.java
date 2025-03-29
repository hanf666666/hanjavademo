package com.date.DesignPattern.创建型.原型模式.浅克隆;

import com.date.DesignPattern.创建型.原型模式.浅克隆.EntitySon;;

/**
 *
 */
public class EntityFather implements Cloneable{
 private String name;
 private EntitySon son;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntitySon getSon() {
        return son;
    }

    public void setSon(EntitySon son) {
        this.son = son;
    }

    @Override
    protected Object clone() {
        EntityFather entityFather= null;
        try {
            entityFather = (EntityFather) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return entityFather;
    }

    @Override
    public String toString() {
        return "EntityFather{" +
                "name='" + name + '\'' +
                ", son=" + son +
                '}';
    }
}
