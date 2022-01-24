package com.executor.线程安全;

import java.util.Date;

public class test {
    public static void main(String[] args) {
        han han = new han();
       // System.out.println("nihao"+han.Date);
        demo(han.Date,han.name);
    }
    static void  demo(Date date2,String name)
    {
        System.out.println("nihao"+date2+name.split(","));
    }
}
class han{
    String name=null;
    Date Date=null;

}
