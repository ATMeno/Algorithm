package com.atmeno.base;

/**
 * @Description TODO
 * @Author maoty
 * @Date 2019-11-30 9:55
 */
public class Introduction {
    /**
     * 一.休眠
     * Thread.sleep();
     *
     * 二.暂停
     * 1.suspend和resume   已废弃
     * 2.Thread.yield();  放弃当前cpu资源，重新进行竞争
     *
     * 三.停止
     * 1.stop   已废弃
     * 2.Thread.currentThread().interrupt();    在当前线程中打了一个停止的标记，并不是真正停止线程
     *      判断线程是否是停止状态:
     *          interrupted():当前线程是否已经是中断状态，执行后具有将状态标志清除为false的功能,为static方法
     *          isInterrupted（）：是否已经是中断状态，但是不清除状态标志
     *
     * 四.等待-通知
     * join()   阻塞调用此方法的线程
     * wait(),notify(),notifyall(),与syschronized配合使用,
     * 如果在syschronized外部调用，会抛出无效监控状态异常
     *  wait():进入等待队列，会释放所持有的锁
     *
     * 五.锁
     *  死锁
     *  活锁  解决方案：尝试等待一个随机时间 例：raft分布式一致性算法
     *  饥饿  解决方案：使用公平锁，即先到先得
     *
     *  乐观锁
     *  悲观锁
     *
     *  公平锁
     *  非公平锁
     *
     *  可重入锁
     *  非可重入锁
     *
     *  独占
     *  共享
     *
     *
     *  六.无锁算法与数据结构
     *
     *
     *
     *
     *  JUC编程Tools
     *  包含5个工具类：Executors   Semaphore   Exchange    CyclicBarrier   CountDownLatch
     *  1.Executors 不建议使用   Executors 提供的很多方法默认使用的都是无界的 LinkedBlockingQueue，高负载情境下，无界队列很容易导致 OOM
     *   ThreadPoolExecutor
     */
}
