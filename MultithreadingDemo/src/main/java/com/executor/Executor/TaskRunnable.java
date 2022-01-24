package com.executor.Executor;

import java.util.concurrent.TimeUnit;

/**
 * to do
 *
 * @author Hj
 * @date 2021/9/8
 */
class TaskRunnable implements Runnable {
    private String name;
    public TaskRunnable(String name) {
        this.name = name;
    }

    //        @Override
    public void run() {
        try {
            //休眠10秒之内的时间
            TimeUnit.SECONDS.sleep((int)Math.random()*10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Runnable任务"+name+"执行业务逻辑");
    }

}
