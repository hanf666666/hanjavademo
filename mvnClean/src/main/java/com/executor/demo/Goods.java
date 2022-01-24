package com.executor.demo;

public class Goods {
    private String name;
    private Double price;
    private Integer number;
    public Goods(String name,Double price,Integer number){
        this.name = name;
        this.price = price;
        this.number = number;
    }
    public Double getTotalPrice(){
        return this.price*this.number;
    }

    public String toString() {
        return this.name+"\t"+"￥"+this.price+"\t"
                +this.number+"\t"+this.getTotalPrice();
    }

}
