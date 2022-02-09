package com.block.demo01;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/9
 */
public class test {
    public static void main(String[] args) throws InterruptedException {

        final BlockingQueue blockingQueue = new BlockingQueue(20);
        final Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    while (true) {
                        for (int i = 0; i < 20; i++) {
                            blockingQueue.enqueue(i);
                        }
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                super.run();
            }
        };
        thread.start();


        while (true) {
            final Object dequeue = blockingQueue.dequeue();
            System.out.println(dequeue);

        }


    }
}
