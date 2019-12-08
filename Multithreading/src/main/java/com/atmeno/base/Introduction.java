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
     *
     *   ThreadPoolExecutor(
         int corePoolSize,                  //线程池保有的最小线程数
         int maximumPoolSize,               //线程池创建的最大线程数
         long keepAliveTime,                //如果一个线程空闲了keepAliveTime & unit这么久，而且线程池的线程数大于 corePoolSize ，那么这个空闲的线程就要被回收了
         TimeUnit unit,
         BlockingQueue<Runnable> workQueue, //工作队列
         ThreadFactory threadFactory,       //自定义如何创建线程,，例如你可以给线程指定一个有意义的名字
         RejectedExecutionHandler handler)  //自定义任务的拒绝策略
                                            //ThreadPoolExecutor 已经提供了以下 4 种策略。
                                            //CallerRunsPolicy：提交任务的线程自己去执行该任务。
                                            //AbortPolicy：默认的拒绝策略，会 throws RejectedExecutionException。
                                            //DiscardPolicy：直接丢弃任务，没有任何异常抛出。
                                            //DiscardOldestPolicy：丢弃最老的任务，其实就是把最早进入工作队列的任务丢弃，然后把新任务加入到工作队列。
                                            //Java 在 1.6 版本还增加了 allowCoreThreadTimeOut(boolean value) 方法，它可以让所有线程都支持超时，这意味着如果项目很闲，就会将项目组的成员都撤走。
     */

}
