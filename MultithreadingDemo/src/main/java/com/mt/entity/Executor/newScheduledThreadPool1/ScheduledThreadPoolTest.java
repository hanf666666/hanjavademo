package com.mt.entity.Executor.newScheduledThreadPool1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/15
 */


public class ScheduledThreadPoolTest {


    public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {

        ScheduledThreadPoolTest scheduledThreadPoolTest = new ScheduledThreadPoolTest();
        //scheduledThreadPoolTest.f1();//也可以提交实现Callable接口的任务，可以返回结果，提交实现Runnable接口的任务返回的结果是字符串"null"
        scheduledThreadPoolTest.f2();
    }


    public void f1() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        //1 延迟3秒，无get。每个线程很快都提交都执行。submit、schedule、shutdown是不耗时的
        System.out.println(sdf.format(new Date()));
        for (int i = 0; i < 5; i++) {
            scheduledThreadPool.schedule(new RunnableTask(i), 3, TimeUnit.SECONDS);
        }
        System.out.println(sdf.format(new Date()));
        scheduledThreadPool.shutdown();
        System.out.println(sdf.format(new Date()));
/*        15:10:22
        15:10:22
        15:10:22
        pool-1-thread-2,任务0,15:10:25开始执行
        pool-1-thread-1,任务1,15:10:25开始执行
        pool-1-thread-2,任务0,15:10:26执行完成
        pool-1-thread-2,任务2,15:10:26开始执行
        pool-1-thread-1,任务1,15:10:26执行完成
        pool-1-thread-1,任务3,15:10:26开始执行
        pool-1-thread-2,任务2,15:10:27执行完成
        pool-1-thread-2,任务4,15:10:27开始执行
        pool-1-thread-1,任务3,15:10:27执行完成
        pool-1-thread-2,任务4,15:10:28执行完成*/

        //2 延迟3秒，有get
/*        System.out.println(sdf.format(new Date()));
        for (int i = 0; i < 5; i++) {
            ScheduledFuture scheduledFuture = scheduledThreadPool.schedule(new RunnableTask(i), 3, TimeUnit.SECONDS);
            try {
                //get正确使用是不能放在提交任务的同一个for循环中，不然会造成线程池的线程串行执行，失去了线程池的意义
                System.out.println("任务" + i + ",结果:" + scheduledFuture.get() + "," + sdf.format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sdf.format(new Date()));
        scheduledThreadPool.shutdown();
        System.out.println(sdf.format(new Date()));*/
/*        15:05:40
        pool-1-thread-1,任务0,15:05:43开始执行
        pool-1-thread-1,任务0,15:05:44执行完成
        任务0,结果:null,15:05:44
        pool-1-thread-1,任务1,15:05:47开始执行
        pool-1-thread-1,任务1,15:05:48执行完成
        任务1,结果:null,15:05:48
        pool-1-thread-1,任务2,15:05:51开始执行
        pool-1-thread-1,任务2,15:05:52执行完成
        任务2,结果:null,15:05:52
        pool-1-thread-2,任务3,15:05:55开始执行
        pool-1-thread-2,任务3,15:05:56执行完成
        任务3,结果:null,15:05:56
        pool-1-thread-1,任务4,15:05:59开始执行
        pool-1-thread-1,任务4,15:06:00执行完成
        任务4,结果:null,15:06:00
        15:06:00
        15:06:00*/

        //3 延迟3秒，有get。schedule、submit、shutdown不耗时，get方法耗时，耗时的原因是线程执行需要时间，而线程执行的时间不会体现在schedule、submit、shutdown方法中
/*        List<ScheduledFuture> futureList = new ArrayList<>();
        System.out.println(sdf.format(new Date()));
        for (int i = 0; i < 5; i++) {
            ScheduledFuture scheduledFuture = scheduledThreadPool.schedule(new RunnableTask(i), 3, TimeUnit.SECONDS);
            futureList.add(scheduledFuture);
        }
        System.out.println(sdf.format(new Date()));
        //get正确使用是不能放在提交任务的同一个for循环中，不然会造成线程池的线程串行执行，失去了线程池的意义
        for (int i = 0; i < 5; i++) {
            try {
                //System.out.println("任务" + i + sdf.format(new Date()) + ",结果:" + futureList.get(i).get() + "," + sdf.format(new Date()));//这两个时间不一致，可判断出卡在get方法处了
                System.out.println("任务" + i + ",结果:" + futureList.get(i).get() + "," + sdf.format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sdf.format(new Date()));
        scheduledThreadPool.shutdown();
        System.out.println(sdf.format(new Date()));*/
/*        14:57:34
        14:57:34
        pool-1-thread-1,任务0,14:57:37开始执行
        pool-1-thread-2,任务1,14:57:37开始执行
        pool-1-thread-1,任务0,14:57:38执行完成
        任务0,结果:null,14:57:38
        pool-1-thread-1,任务2,14:57:38开始执行
        pool-1-thread-2,任务1,14:57:38执行完成
        任务1,结果:null,14:57:38
        pool-1-thread-2,任务3,14:57:38开始执行
        pool-1-thread-1,任务2,14:57:39执行完成
        任务2,结果:null,14:57:39
        pool-1-thread-1,任务4,14:57:39开始执行
        pool-1-thread-2,任务3,14:57:39执行完成
        任务3,结果:null,14:57:39
        pool-1-thread-1,任务4,14:57:40执行完成
        任务4,结果:null,14:57:40
        14:57:40
        14:57:40*/
    }


    public void f2() {

        ScheduledExecutorService exe = Executors.newScheduledThreadPool(2);

        System.out.println(sdf.format(new Date()));
        //开始时延迟5s执行，每3s开始执行一次。以上次任务的开始时间为准
        exe.scheduleAtFixedRate(new RunnableTask(1), 5, 3, TimeUnit.SECONDS);
//        15:17:47
//        pool-1-thread-1,任务1,15:17:52开始执行
//        pool-1-thread-1,任务1,15:17:53执行完成
//        pool-1-thread-1,任务1,15:17:55开始执行

        //开始时延迟5s执行，本次结束3s后，下次才运行。以上次任务的结束时间为准
//        exe.scheduleWithFixedDelay(new RunnableTask(1), 5, 3, TimeUnit.SECONDS);
/*        15:20:10
        pool-1-thread-1,任务1,15:20:15开始执行
        pool-1-thread-1,任务1,15:20:16执行完成
        pool-1-thread-1,任务1,15:20:19开始执行
*/

//        exe.scheduleAtFixedRate(new RunnableTaskException(1), 5, 3, TimeUnit.SECONDS);
/*        15:41:00
        pool-1-thread-1,任务1,15:41:05开始执行
        pool-1-thread-1,任务1,15:41:06执行完成
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:269)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,任务1,15:41:08开始执行
        pool-1-thread-1,任务1,15:41:09执行完成
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:269)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,任务1,15:41:11开始执行
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:269)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,任务1,15:41:12执行完成*/

//        exe.scheduleWithFixedDelay(new RunnableTaskException(1), 5, 3, TimeUnit.SECONDS);
/*        15:36:43
        pool-1-thread-1,任务1,15:36:48开始执行
        pool-1-thread-1,任务1,15:36:49执行完成
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:248)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,任务1,15:36:52开始执行
        pool-1-thread-1,任务1,15:36:53执行完成
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:248)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,任务1,15:36:56开始执行
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:248)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,任务1,15:36:57执行完成*/

        //如果任务执行时间大于间隔时间，则上次任务执行完成后下次任务才会立即执行，并不会在达到时间间隔时立即创建下次任务去并发执行
//        exe.scheduleAtFixedRate(new RunnableLongTask(1), 5, 3, TimeUnit.SECONDS);
/*        15:50:09
        pool-1-thread-1,任务1,15:50:14开始执行
        pool-1-thread-1,任务1,15:50:24执行完成
        pool-1-thread-1,任务1,15:50:24开始执行
        pool-1-thread-1,任务1,15:50:34执行完成
        pool-1-thread-1,任务1,15:50:34开始执行*/

        //下次任务仍然会间隔3s,不会立即执行
//        exe.scheduleWithFixedDelay(new RunnableLongTask(1), 5, 3, TimeUnit.SECONDS);
/*        15:53:16
        pool-1-thread-1,任务1,15:53:21开始执行
        pool-1-thread-1,任务1,15:53:31执行完成
        pool-1-thread-1,任务1,15:53:34开始执行
        pool-1-thread-1,任务1,15:53:44执行完成
        pool-1-thread-1,任务1,15:53:47开始执行*/

//        exe.shutdown();//这个shutdown慎用，会关闭定时任务
    }

    //自定义的类
    class Result {
        String res;

        public Result() {
        }

        public Result(String res) {
            this.res = res;
        }

        public String getRes() {
            return res;
        }

        public void setRes(String res) {
            this.res = res;
        }
    }


    class CallableTask implements Callable<Result> {
        int id;

        public CallableTask(int id) {
            this.id = id;
        }

        @Override
        public Result call() throws Exception {
            if (id % 2 == 0) {//判断结果顺序是否与任务顺序一致
                Thread.sleep(5000);
            } else {
                Thread.sleep(1000);
            }
            return new Result("任务" + id + "执行完成");
        }
    }


    class RunnableTask implements Runnable {
        int id;

        public RunnableTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "," + "任务=>" + id + "," + sdf.format(new Date()) + "开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "," + "任务<=" + id + "," + sdf.format(new Date()) + "执行完成");
        }
    }

    class RunnableTaskException implements Runnable {
        int id;

        public RunnableTaskException(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "," + "任务" + id + "," + sdf.format(new Date()) + "开始执行");
            try {
                Thread.sleep(1000);
                Integer a = 2 / 0;//在try..catch中每次执行都会捕获并输出异常，定时任务会依旧执行。代码还是写在try..catch中比较好
            } catch (Exception e) {
                e.printStackTrace();
            }
//            Integer a = 2 / 0;//第一次执行任务时就会阻塞住，也不报异常
            System.out.println(Thread.currentThread().getName() + "," + "任务" + id + "," + sdf.format(new Date()) + "执行完成");
        }
    }



    class RunnableLongTask implements Runnable {
        int id;

        public RunnableLongTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "," + "任务" + id + "," + sdf.format(new Date()) + "开始执行");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "," + "任务" + id + "," + sdf.format(new Date()) + "执行完成");
        }
    }

}