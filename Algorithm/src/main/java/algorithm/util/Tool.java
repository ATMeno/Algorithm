package algorithm.util;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author maoty
 * @Date 2019-12-23 14:35
 */
public class Tool {

    public static <T> void swap(T[] t,int index1,int index2){
        T temp = t[index1];
        t[index1] = t[index2];
        t[index2] = temp;
    }
}
