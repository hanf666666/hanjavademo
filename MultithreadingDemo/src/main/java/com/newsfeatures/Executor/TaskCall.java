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
    //�з���ֵ
    public String call() throws Exception {
        try {
            //����10��֮�ڵ�ʱ��
            TimeUnit.SECONDS.sleep((int)Math.random()*10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Callable����"+name+"ִ��ҵ���߼�");
        return "�̷߳���ֵ���߳����ƣ�"+name;
    }

}
