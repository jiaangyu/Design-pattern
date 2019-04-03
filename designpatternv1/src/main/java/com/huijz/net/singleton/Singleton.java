package com.huijz.net.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * @author huijz
 * @date 2019/04/03
 */
public class Singleton {
    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 1000;

    public static void main(String[] args) throws Exception {
        //单线程请求
        Emperor stemperor1 = Emperor.getInstance();
        Emperor stemperor2 = Emperor.getInstance();
        stemperor2.emperorInfo();
        Emperor stemperor3 = Emperor.getInstance();
        stemperor3.emperorInfo();
        System.out.println("stemperor3==stemperor1?:"+(stemperor3 == stemperor1));
        System.out.println("stemperor3==stemperor2?:"+(stemperor3 == stemperor2));
        System.out.println("stemperor3.equal.stemperor2?:"+(stemperor3.equals(stemperor2)));
        System.out.println("stemperor1.equal.stemperor2?:"+(stemperor1.equals(stemperor2)));

        //多线程并发请求
        ExecutorService executorService = newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(finalI);
                    Emperor emperor1 = Emperor.getInstance();
                    Emperor emperor2 = Emperor.getInstance();
                    emperor2.emperorInfo();
                    Emperor emperor3 = Emperor.getInstance();
                    emperor3.emperorInfo();

                    System.out.println(emperor3 == emperor1);
                    System.out.println(emperor3 == emperor2);
                    System.out.println(emperor3.equals(emperor2));
                    System.out.println(emperor1.equals(emperor2));
                    semaphore.release();
                } catch (Exception e) {
                    System.out.println(e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }
}
