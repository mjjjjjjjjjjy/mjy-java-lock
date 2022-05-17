package com.mjy.java.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.test.AbstractQueuedSynchronizer;

/**
 * @Author: Mo Jianyue
 * @Description
 * @Date: 2022/5/16 下午5:13
 * @Modified By
 */
public class 自己实现Aql {

    public static void main(String[] args) {
        sync sync = new sync();
        sync.setStates(0);
        new Thread(()-> {
            if (sync.go()){
                System.out.println("执行任务_"+Thread.currentThread().getName());
            }
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("休息结束");
            sync.stop();
        },"1").start();
        new Thread(()-> {
            if (sync.go()){
                System.out.println("执行任务_"+Thread.currentThread().getName());
            }
            System.out.println("执行结束");
        },"2").start();
    }

    public static class sync extends AbstractQueuedSynchronizer {
        public void setStates(int a){
            setState(0);
        }
        public boolean stop(){
            return compareAndSetState(1,0);
        }


        public boolean go(){
            boolean a = false;
            while (!a){
                System.out.println("cas");
                 if (compareAndSetState(0,1)){
                     a = true;
                 }
            }
            return a;
        }


    }
}
