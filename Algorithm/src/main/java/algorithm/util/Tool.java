package algorithm.util;

import java.util.Random;

/**
 * @Description TODO
 * @Author maoty
 * @Date 2019-12-23 14:35
 */
public class Tool {

    /**
     * 交换index1和Index2的数据
     * @param t
     * @param index1
     * @param index2
     * @param <T>
     */
    public static <T> void swap(T[] t,int index1,int index2){
        T temp = t[index1];
        t[index1] = t[index2];
        t[index2] = temp;
    }

    public static Integer[] ramdom(int num,int low,int high){
        Random random = new Random();
        Integer[] integers = new Integer[num];
        for (int i = 0; i < num; i++) {
            integers[i] = random.nextInt(high - low) + low;
        }
        return  integers;
    }
}
