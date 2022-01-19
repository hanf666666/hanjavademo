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
        //scheduledThreadPoolTest.f1();//Ҳ�����ύʵ��Callable�ӿڵ����񣬿��Է��ؽ�����ύʵ��Runnable�ӿڵ����񷵻صĽ�����ַ���"null"
        scheduledThreadPoolTest.f2();
    }


    public void f1() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        //1 �ӳ�3�룬��get��ÿ���̺߳ܿ춼�ύ��ִ�С�submit��schedule��shutdown�ǲ���ʱ��
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
        pool-1-thread-2,����0,15:10:25��ʼִ��
        pool-1-thread-1,����1,15:10:25��ʼִ��
        pool-1-thread-2,����0,15:10:26ִ�����
        pool-1-thread-2,����2,15:10:26��ʼִ��
        pool-1-thread-1,����1,15:10:26ִ�����
        pool-1-thread-1,����3,15:10:26��ʼִ��
        pool-1-thread-2,����2,15:10:27ִ�����
        pool-1-thread-2,����4,15:10:27��ʼִ��
        pool-1-thread-1,����3,15:10:27ִ�����
        pool-1-thread-2,����4,15:10:28ִ�����*/

        //2 �ӳ�3�룬��get
/*        System.out.println(sdf.format(new Date()));
        for (int i = 0; i < 5; i++) {
            ScheduledFuture scheduledFuture = scheduledThreadPool.schedule(new RunnableTask(i), 3, TimeUnit.SECONDS);
            try {
                //get��ȷʹ���ǲ��ܷ����ύ�����ͬһ��forѭ���У���Ȼ������̳߳ص��̴߳���ִ�У�ʧȥ���̳߳ص�����
                System.out.println("����" + i + ",���:" + scheduledFuture.get() + "," + sdf.format(new Date()));
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
        pool-1-thread-1,����0,15:05:43��ʼִ��
        pool-1-thread-1,����0,15:05:44ִ�����
        ����0,���:null,15:05:44
        pool-1-thread-1,����1,15:05:47��ʼִ��
        pool-1-thread-1,����1,15:05:48ִ�����
        ����1,���:null,15:05:48
        pool-1-thread-1,����2,15:05:51��ʼִ��
        pool-1-thread-1,����2,15:05:52ִ�����
        ����2,���:null,15:05:52
        pool-1-thread-2,����3,15:05:55��ʼִ��
        pool-1-thread-2,����3,15:05:56ִ�����
        ����3,���:null,15:05:56
        pool-1-thread-1,����4,15:05:59��ʼִ��
        pool-1-thread-1,����4,15:06:00ִ�����
        ����4,���:null,15:06:00
        15:06:00
        15:06:00*/

        //3 �ӳ�3�룬��get��schedule��submit��shutdown����ʱ��get������ʱ����ʱ��ԭ�����߳�ִ����Ҫʱ�䣬���߳�ִ�е�ʱ�䲻��������schedule��submit��shutdown������
/*        List<ScheduledFuture> futureList = new ArrayList<>();
        System.out.println(sdf.format(new Date()));
        for (int i = 0; i < 5; i++) {
            ScheduledFuture scheduledFuture = scheduledThreadPool.schedule(new RunnableTask(i), 3, TimeUnit.SECONDS);
            futureList.add(scheduledFuture);
        }
        System.out.println(sdf.format(new Date()));
        //get��ȷʹ���ǲ��ܷ����ύ�����ͬһ��forѭ���У���Ȼ������̳߳ص��̴߳���ִ�У�ʧȥ���̳߳ص�����
        for (int i = 0; i < 5; i++) {
            try {
                //System.out.println("����" + i + sdf.format(new Date()) + ",���:" + futureList.get(i).get() + "," + sdf.format(new Date()));//������ʱ�䲻һ�£����жϳ�����get��������
                System.out.println("����" + i + ",���:" + futureList.get(i).get() + "," + sdf.format(new Date()));
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
        pool-1-thread-1,����0,14:57:37��ʼִ��
        pool-1-thread-2,����1,14:57:37��ʼִ��
        pool-1-thread-1,����0,14:57:38ִ�����
        ����0,���:null,14:57:38
        pool-1-thread-1,����2,14:57:38��ʼִ��
        pool-1-thread-2,����1,14:57:38ִ�����
        ����1,���:null,14:57:38
        pool-1-thread-2,����3,14:57:38��ʼִ��
        pool-1-thread-1,����2,14:57:39ִ�����
        ����2,���:null,14:57:39
        pool-1-thread-1,����4,14:57:39��ʼִ��
        pool-1-thread-2,����3,14:57:39ִ�����
        ����3,���:null,14:57:39
        pool-1-thread-1,����4,14:57:40ִ�����
        ����4,���:null,14:57:40
        14:57:40
        14:57:40*/
    }


    public void f2() {

        ScheduledExecutorService exe = Executors.newScheduledThreadPool(2);

        System.out.println(sdf.format(new Date()));
        //��ʼʱ�ӳ�5sִ�У�ÿ3s��ʼִ��һ�Ρ����ϴ�����Ŀ�ʼʱ��Ϊ׼
        exe.scheduleAtFixedRate(new RunnableTask(1), 5, 3, TimeUnit.SECONDS);
//        15:17:47
//        pool-1-thread-1,����1,15:17:52��ʼִ��
//        pool-1-thread-1,����1,15:17:53ִ�����
//        pool-1-thread-1,����1,15:17:55��ʼִ��

        //��ʼʱ�ӳ�5sִ�У����ν���3s���´β����С����ϴ�����Ľ���ʱ��Ϊ׼
//        exe.scheduleWithFixedDelay(new RunnableTask(1), 5, 3, TimeUnit.SECONDS);
/*        15:20:10
        pool-1-thread-1,����1,15:20:15��ʼִ��
        pool-1-thread-1,����1,15:20:16ִ�����
        pool-1-thread-1,����1,15:20:19��ʼִ��
*/

//        exe.scheduleAtFixedRate(new RunnableTaskException(1), 5, 3, TimeUnit.SECONDS);
/*        15:41:00
        pool-1-thread-1,����1,15:41:05��ʼִ��
        pool-1-thread-1,����1,15:41:06ִ�����
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:269)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,����1,15:41:08��ʼִ��
        pool-1-thread-1,����1,15:41:09ִ�����
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:269)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,����1,15:41:11��ʼִ��
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:269)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,����1,15:41:12ִ�����*/

//        exe.scheduleWithFixedDelay(new RunnableTaskException(1), 5, 3, TimeUnit.SECONDS);
/*        15:36:43
        pool-1-thread-1,����1,15:36:48��ʼִ��
        pool-1-thread-1,����1,15:36:49ִ�����
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:248)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,����1,15:36:52��ʼִ��
        pool-1-thread-1,����1,15:36:53ִ�����
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:248)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,����1,15:36:56��ʼִ��
        java.lang.ArithmeticException: / by zero
        at testpackage.ScheduledThreadPoolTest$RunnableTaskException.run(ScheduledThreadPoolTest.java:248)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        pool-1-thread-1,����1,15:36:57ִ�����*/

        //�������ִ��ʱ����ڼ��ʱ�䣬���ϴ�����ִ����ɺ��´�����Ż�����ִ�У��������ڴﵽʱ����ʱ���������´�����ȥ����ִ��
//        exe.scheduleAtFixedRate(new RunnableLongTask(1), 5, 3, TimeUnit.SECONDS);
/*        15:50:09
        pool-1-thread-1,����1,15:50:14��ʼִ��
        pool-1-thread-1,����1,15:50:24ִ�����
        pool-1-thread-1,����1,15:50:24��ʼִ��
        pool-1-thread-1,����1,15:50:34ִ�����
        pool-1-thread-1,����1,15:50:34��ʼִ��*/

        //�´�������Ȼ����3s,��������ִ��
//        exe.scheduleWithFixedDelay(new RunnableLongTask(1), 5, 3, TimeUnit.SECONDS);
/*        15:53:16
        pool-1-thread-1,����1,15:53:21��ʼִ��
        pool-1-thread-1,����1,15:53:31ִ�����
        pool-1-thread-1,����1,15:53:34��ʼִ��
        pool-1-thread-1,����1,15:53:44ִ�����
        pool-1-thread-1,����1,15:53:47��ʼִ��*/

//        exe.shutdown();//���shutdown���ã���رն�ʱ����
    }

    //�Զ������
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
            if (id % 2 == 0) {//�жϽ��˳���Ƿ�������˳��һ��
                Thread.sleep(5000);
            } else {
                Thread.sleep(1000);
            }
            return new Result("����" + id + "ִ�����");
        }
    }


    class RunnableTask implements Runnable {
        int id;

        public RunnableTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "," + "����=>" + id + "," + sdf.format(new Date()) + "��ʼִ��");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "," + "����<=" + id + "," + sdf.format(new Date()) + "ִ�����");
        }
    }

    class RunnableTaskException implements Runnable {
        int id;

        public RunnableTaskException(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "," + "����" + id + "," + sdf.format(new Date()) + "��ʼִ��");
            try {
                Thread.sleep(1000);
                Integer a = 2 / 0;//��try..catch��ÿ��ִ�ж��Ჶ������쳣����ʱ���������ִ�С����뻹��д��try..catch�бȽϺ�
            } catch (Exception e) {
                e.printStackTrace();
            }
//            Integer a = 2 / 0;//��һ��ִ������ʱ�ͻ�����ס��Ҳ�����쳣
            System.out.println(Thread.currentThread().getName() + "," + "����" + id + "," + sdf.format(new Date()) + "ִ�����");
        }
    }



    class RunnableLongTask implements Runnable {
        int id;

        public RunnableLongTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "," + "����" + id + "," + sdf.format(new Date()) + "��ʼִ��");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "," + "����" + id + "," + sdf.format(new Date()) + "ִ�����");
        }
    }

}