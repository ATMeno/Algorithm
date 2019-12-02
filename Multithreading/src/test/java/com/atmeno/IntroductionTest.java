package com.atmeno;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author maoty
 * @Date 2019-11-30 15:32
 */
public class IntroductionTest {

    private List<String> resource = new ArrayList<String>(){{add("1");add("2");}};
    @Test
    public void wait_notify_test() {
        /**
         * 等待-通知
         * wait(),notify(),notifyAll(),与syschronized配合使用,
         * 如果在syschronized外部调用，会抛出无效监控状态异常
         *  wait():进入等待队列，会释放所持有的锁
         *  尽量使用notifyAll()
         */


    }

    //申请资源
     synchronized void apply(String r1,String r2){
        while (!resource.contains(r1) || !resource.contains(r2)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resource.add(r1);resource.add(r2);
    }

    //释放资源
    synchronized void release(String r1,String r2){
        resource.remove(r1);
        resource.remove(r2);
        this.notifyAll();
    }}
