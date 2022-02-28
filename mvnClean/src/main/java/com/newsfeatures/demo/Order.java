package com.newsfeatures.demo;

public class Order {
    private Integer discount = 10;
    private Double pay;
    private Goods[] goodsArray;

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public void setGoodsArray(Goods[] goodsArray) {
        this.goodsArray = goodsArray;
    }

    public Double getTotalPrice(){
        Double total = 0.0;
        for (int i = 0; i <goodsArray.length ; i++) {
            total+=goodsArray[i].getTotalPrice();
        }
        return total*discount*0.1D;
    }
    public Double getGiveChange(){
        return this.pay-this.getTotalPrice();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("***************消费单*************").append("\n")
                .append("名称\t单价\t数量\t金额").append("\n");
        for (int i = 0; i < goodsArray.length; i++) {
            sb.append(this.goodsArray[i].toString()).append("\n");
        }
        sb.append("\n")
                .append("----------------------").append("\n")
                .append("折扣：").append(this.discount).append("折").append("\n")
                .append("消费总金额：").append(this.getTotalPrice()).append("\n")
                .append("实际支付金额：").append(this.pay).append("\n")
                .append("找零：").append(this.getGiveChange()).append("\n")
                .append("本次消费积分：").append(this.getTotalPrice().intValue()).append("\n");
        return sb.toString();
    }

}
