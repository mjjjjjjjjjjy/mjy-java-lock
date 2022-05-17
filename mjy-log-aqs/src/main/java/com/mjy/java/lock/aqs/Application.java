package com.mjy.java.lock.aqs;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mo Jianyue
 * @Description
 * @Date: 2022/3/23 下午2:56
 * @Modified By
 */
public class Application {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(()->{
            TimeUnit.SECONDS.sleep(1);
            System.out.println("执行futureTask");
            return 1;
        });

        new Thread(integerFutureTask).start();
        new Thread(()-> System.out.println("执行异步任务2")).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("主线程提交任务完成");
        Integer integer = integerFutureTask.get();
        System.out.println("获取 integerFutureTask 执行结果");
    }
}
