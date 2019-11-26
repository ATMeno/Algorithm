package java8.time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.*;

/**
 *
 */
public class Introduction {
    //JDK1.0 Deprecated
    Date date;

    //JDK1.1 可以做一些日期运算  不提供时区的支持
    Calendar calendar;

    //JDK1.1 时区
    TimeZone timeZone;

    //日期格式化
    SimpleDateFormat simpleDateFormat;
    /**
     * 以上所在包不同，不规范；并且线程不安全
     */
    //例如
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> callable = () -> dateFormat.parse("20191127");

        ExecutorService pool = Executors.newFixedThreadPool(10);
        ArrayList<Future<Date>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            futures.add(pool.submit(callable));
        }

        for (Future<Date> future : futures) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }

    /**
     * java8新增时间类均在java.time及其子包下,线程安全
     * @see     java.time                   对时间日期操作
     * @see     java.time.LocalDate
     * @see     java.time.LocalTime
     * @see     java.time.LocalDateTime
     * @see     java.time.Instant           时间戳
     * @see     java.time.ZoneId            时区
     *
     * @see     java.time.chrono            特殊时间处理，比如日本、台湾
     *
     * @see     java.time.format            格式化
     *
     * @see     java.time.temporal          时间校正器
     *
     * @see     java.time.zone              时区操作
     */

}
