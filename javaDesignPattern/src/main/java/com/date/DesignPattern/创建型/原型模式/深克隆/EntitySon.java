package com.date.DesignPattern.������.ԭ��ģʽ.���¡;

/**
 *
 */
public class EntitySon implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() {
        Object clone=null;
        try {
             clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "EntitySon{" +
                "name='" + name + '\'' +
                '}';
    }
}
