package com.mjy.java.lock.aqs;

import java.util.concurrent.locks.test.AbstractQueuedSynchronizer;

/**
 * @Author: Mo Jianyue
 * @Description
 * @Date: 2022/5/16 下午3:45
 * @Modified By
 */
public class 实现AQS类测试 {

    public static class CutomAqs extends AbstractQueuedSynchronizer {
        public Integer getStateS(){
            return getState();
        }

        public void setS(Integer integer){
             setState(integer);
        }

        public void cas(){
            compareAndSetState(1,2);
        }

    }
}
