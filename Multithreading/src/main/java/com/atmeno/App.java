package com.atmeno;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 */
public class App {
    private ReentrantLock lock = new ReentrantLock(true);
    private Semaphore semaphore = new Semaphore(1);
    private static int count;
    private void modify(String threadName){
        lock.lock();
        //System.out.println("通知 管理员 线程：--->" + threadName + "准备打水");
        count++;
        //System.out.println("线程:" + threadName + "打第" + count + "桶水");
        lock.lock();
        count++;
        //System.out.println("线程:" + threadName + "打第" + count + "桶水");
        lock.unlock();
        lock.unlock();

    }


    private void unsafe(String threadName){

        //System.out.println("通知 管理员 线程：--->" + threadName + "准备打水");
        count++;
        //System.out.println("线程:" + threadName + "打第" + count + "桶水");
        count++;
        //System.out.println("线程:" + threadName + "打第" + count + "桶水");

    }
    public static void main(String[] args) {
        App app = new App();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                app.modify(threadName);
            },"Thread:" + i).start();
        }

        /*for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                app.unsafe(threadName);
            },"Thread:" + i).start();
        }*/

    }
}
