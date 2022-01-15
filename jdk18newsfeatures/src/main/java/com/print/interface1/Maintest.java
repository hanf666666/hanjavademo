package com.print.interface1;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
public class Maintest {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        formula.calculate(100);     // 10.0
        formula.sqrt(16);           // 4.0
        System.out.println("fasdfas"+ formula.calculate(100));
        System.out.println("fasdfas"+formula.sqrt(16));
        System.out.println("fasdfas");

    }
}
