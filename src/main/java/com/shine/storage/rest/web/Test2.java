package com.shine.storage.rest.web;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2019年01月25日 10:57
 */
public class Test2 {

    public static void main(String[] args) {
        thread1 i = new thread1();
        thread2 j = new thread2();
        thread3 k = new thread3();
        // Thread t1 = new Thread(i);
        // Thread t2 = new Thread(j);
        // t1.start();
        // t2.start();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(i);
        executorService.submit(k);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();//gracefully shutdown

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,1,10,TimeUnit.SECONDS,new ArrayBlockingQueue<>(1),new ThreadPoolExecutor.DiscardOldestPolicy());
    }


    static class thread1 extends Thread {

        private int ticket = 100;
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(ticket-- + " ---shine---- " + Thread.currentThread());

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class thread2 implements Runnable {

        private int ticket = 100;
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(ticket-- + " ---sunny---- " + Thread.currentThread());

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class thread3 implements Callable<String> {

        @Override
        public String call() throws Exception {

            for (int i = 0; i < 10; i++) {
                System.out.println(i +" ---callable--- " +Thread.currentThread().getName());
                sleep(1000);
            }
            return null;
        }
    }
}
