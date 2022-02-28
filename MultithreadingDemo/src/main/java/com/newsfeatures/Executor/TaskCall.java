package com.newsfeatures.Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * to do
 *
 * @author Hj
 * @date 2021/9/8
 */
class TaskCall implements Callable<String> {
    private String name;
    public TaskCall(String name) {
        this.name = name;
    }

    //        @Override
    //有返回值
    public String call() throws Exception {
        try {
            //休眠10秒之内的时间
            TimeUnit.SECONDS.sleep((int)Math.random()*10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Callable任务"+name+"执行业务逻辑");
        return "线程返回值，线程名称："+name;
    }

}
