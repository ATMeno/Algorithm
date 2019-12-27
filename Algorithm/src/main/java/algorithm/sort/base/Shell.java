package algorithm.sort.base;

import java.util.Arrays;

/**
 * @Description 希尔排序:
 * @Author maoty
 * @Date 2019-12-24 9:47
 */
public class Shell {
    public static void main(String[] args) {
        Integer[] data = {888, 3, 2, 1, 6, 5, 4, 3, 52, 5, 12, 45};

        Shell insertion = new Shell();
        System.out.println(Arrays.toString(data));
        System.out.println("-----------------------------------------------------------------------");
        insertion.sort(data);

    }

    public static void sort(Comparable[] data) {
        if (data != null && data.length < 2) return;


    }
}
