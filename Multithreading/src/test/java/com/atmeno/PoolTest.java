package com.atmeno;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author maoty
 * @Date 2019-12-10 14:52
 */
public class PoolTest {

    @Test
    public void test1() {
        /**
         * 烧水泡茶
         * 1：洗水壶->烧开水
         * 2：洗茶壶->洗茶杯->拿茶叶
         * 3：任务1和任务2完成后执行：泡茶
         */


        try {
            CompletableFuture<Void> t1 = CompletableFuture.runAsync(() -> {
                try {
                    System.out.println("T1:洗水壶...");
                    Thread.sleep(1000);
                    System.out.println("T1:烧开水...");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            CompletableFuture<String> t2 =
                    CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("T2:洗茶壶...");
                    Thread.sleep(1000);
                    System.out.println("T2:洗茶杯...");
                    Thread.sleep(2000);
                    System.out.println("T2:拿茶叶...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "龙井";
            });

            //t1.thenCombine(, )


        } catch (RuntimeException x) {
            //按需处理
        } catch (Throwable x) {
            //按需处理
        }
    }

    @Test
    public void test2(){
        System.out.println(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss").format(LocalDateTime.now()));

    }}
