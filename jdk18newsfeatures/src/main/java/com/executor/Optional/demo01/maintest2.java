package com.executor.Optional.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * to do
 *  Optional 接口还得详细研究
 * @author Hj
 * @date 2021/12/2
 */
public class maintest2 {
    public static void main(String[] args) {
        List<Animal> zoo = new ArrayList<>();

        Animal animal =null;
        if(animal != null){
            zoo.add(animal);
        }
         Optional.ofNullable(animal).ifPresent(zoo::add);
        System.out.println(zoo.size());

    }
    public static class Animal{
        private String no;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }
    }
}
