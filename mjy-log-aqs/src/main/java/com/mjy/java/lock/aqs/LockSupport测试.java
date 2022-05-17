package com.mjy.java.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: Mo Jianyue
 * @Description
 * @Date: 2022/5/16 下午6:14
 * @Modified By
 */
public class LockSupport测试 {
    public static void main(String[] args) throws InterruptedException {

//        int a = 10;
//
//        for (int i = 0; i < a; i++) {
//            LockSupport.unpark(Thread.currentThread());
//        }
//        System.out.println("发放许可结束");
//        for (int i = 0; i < a; i++) {
//            LockSupport.park();
//            System.out.println("释放锁 "+i);
//        }
//        System.out.println("结束");


        final int a = 10;
        Thread thread = new Thread(() -> {
            System.out.println("准备锁");
//            LockSupport.park();
//            System.out.println("锁1");
//            LockSupport.park();
//            System.out.println("锁2");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < a; i++) {
                System.out.println("循环上锁开始，c="+i);
                LockSupport.park();
                System.out.println("循环上锁完成，c="+i);

            }
            System.out.println("循环结束，线程执行完毕");

        });
        thread.start();
//        TimeUnit.SECONDS.sleep(10);
//        LockSupport.unpark(thread);
//        System.out.println("释放锁1");
//        TimeUnit.SECONDS.sleep(10);
//        LockSupport.unpark(thread);
//        System.out.println("释放锁2");
        for (int i = 0; i < a; i++) {
            LockSupport.unpark(thread);
            System.out.println("发放许可 数量"+i);
        }


    }
}
