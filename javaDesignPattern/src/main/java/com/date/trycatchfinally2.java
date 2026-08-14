package com.date;

/**
 *  执行，并且finally的执行早于try里面的return
 * 结论:
 * 1、不管有木有出现异常，finally块中代码都会执行
 * 2、当try和catch中有return时，finally仍然会执行;
 * 3、finalv是在return后面的表达式运算后执行的(此时并没有返回运算后的值，而是先把要返回的值保
 * 存起来，管finally中的代码怎么样，返回的值都不会改变，任然是之前保存的值)，所以函数返回值是
 * 在finally执行前确定的;
 * 4、finally中最好不要包含return，否则程序会提前退出，返回值不是try或catch中保存的返回值,
 *  trycatchfinally
 * @author Hj
 * @date 2023/2/11
 */
public class trycatchfinally2 {
    public static void main(String[] args) {
        System.out.println("return===>"+extracted());

    }

    private static String extracted() {
        try {
            System.out.println("try");
            int i=0;
            int i1 = 1 / i;
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
            return "catch";
        } finally {
            System.out.println("finally");
            //并且finally的执行早于try里面的return
            //finally中最好不要包含return，否则程序会提前退出
            return "finally";
        }
//        return "结果";

    }
}
