package com.mjy.java.lock.aqs;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mo Jianyue
 * @Description
 * @Date: 2022/5/16 下午5:26
 * @Modified By
 */
public class FutureTask实现探索 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> integerFutureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(10);
            return 1;
        });
        FutureTask<Integer> integerFutureTask2 = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(10);
            return 1;
        });
        new Thread(integerFutureTask).start();
        new Thread(integerFutureTask2).start();

        integerFutureTask.get();
        integerFutureTask2.get();
        System.out.println("主线程结束");
    }
}
