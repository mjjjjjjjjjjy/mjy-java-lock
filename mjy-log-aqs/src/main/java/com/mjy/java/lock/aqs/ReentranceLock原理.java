package com.mjy.java.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Mo Jianyue
 * @Description
 * @Date: 2022/5/16 下午8:14
 * @Modified By
 */
public class ReentranceLock原理 {

    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(()->{
            reentrantLock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("执行完成");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();
        System.out.println("释放锁，执行完成");

    }
}
