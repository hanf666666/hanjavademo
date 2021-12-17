package com.Thread.Executor;

/**
 * to do
 *
 * @author Hj
 * @date 2021/9/8
 */
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {

        final ExecutorService pool = Executorfactory.getFactory().createFixedPool(10);
     /*   for (int i = 0; i < 50; i++) {
            String name = "�߳�"+i;
            pool.execute(new TaskRunnable(name));

        }*/
        for (int i = 50; i < 100; i++) {
            String name = "�߳�"+i;
            Future<?> future =  pool.submit(new TaskCall(name));
            try {
                System.out.println(future.get());//��ȡ���
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }


}
