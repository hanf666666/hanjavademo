package com.date;

/**
 * to do
 *  trycatchfinally
 * @author Hj
 * @date 2023/2/11
 */
public class trycatchfinally {
    public static void main(String[] args) {


        String extracted = extracted();
        System.out.println(extracted);
    }

    private static String extracted() {
        try {
            System.out.println("try");
            int i=0;
            int i1 = 1 / i;
        } catch (Exception e) {
            System.out.println("catch");

            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
            return "finally";
        }

    }
}
