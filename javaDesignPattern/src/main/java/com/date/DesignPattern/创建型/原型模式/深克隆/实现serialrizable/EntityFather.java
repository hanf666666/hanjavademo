package com.date.DesignPattern.创建型.原型模式.深克隆.实现serialrizable;

import java.io.*;

/**
 *
 */
public class EntityFather implements Serializable {
    private static final long serialVersionUID = 369285298572941L;
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


    public Object clone() {
        EntityFather entityFather = null;

        try {
            //?????
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream);
            objectOutput.writeObject(this);

            //??????
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            entityFather = (EntityFather) objectInputStream.readObject();

        } catch (Exception e) {
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
