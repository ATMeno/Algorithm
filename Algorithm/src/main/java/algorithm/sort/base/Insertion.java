package algorithm.sort.base;

import algorithm.util.Tool;

import java.util.Arrays;

/**
 * @Description 插入排序:假设前面的数据是有序的，每次取后面的数据插入前面有序数组
 * @Author maoty
 * @Date 2019-12-23 16:25
 */
public class Insertion {
    public static void main(String[] args) {
        Integer[] data = {888, 3, 2, 1, 6, 5, 4, 3, 52, 5, 12, 45};

        Insertion insertion = new Insertion();
        System.out.println(Arrays.toString(data));
        System.out.println("-----------------------------------------------------------------------");
        insertion.sort(data);
    }

    public static void sort(Comparable[] data) {
        if (data != null && data.length < 2) return;

        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j].compareTo(data[j - 1]) >= 0){
                    break;
                }
                Tool.swap(data, j, j - 1);
                System.out.println(Arrays.toString(data));
            }
        }
    }
}
