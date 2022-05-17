package com.mjy.java.lock.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mo Jianyue
 * @Description
 * @Date: 2022/5/16 下午2:39
 * @Modified By
 */
public class 测试countDownLatch在异常情况下的使用 {

    public static void main(String[] args) throws InterruptedException {
        int cycle = 5;
        CountDownLatch countDownLatch = new CountDownLatch(cycle);
        for (int i = 0; i < cycle; i++) {
            final int fi = i;
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(fi);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行线程"+fi);
                if (fi == 3){
                    int  a = 0;
                    //抛出异常
                    int i1 = 1 / a;
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("执行成功");
    }
}
