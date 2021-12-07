package com.it.Executor;

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
            String name = "线程"+i;
            pool.execute(new TaskRunnable(name));

        }*/
        for (int i = 50; i < 100; i++) {
            String name = "线程"+i;
            Future<?> future =  pool.submit(new TaskCall(name));
            try {
                System.out.println(future.get());//获取结果
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
