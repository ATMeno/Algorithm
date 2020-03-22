package algorithm.sort.base;

import algorithm.util.Tool;

import java.util.Arrays;

/**
 * @Description 选择排序
 * 分为已排序区间和未排序区间
 * 从未排序区间中找到最小的，与未排序的第一个进行交换
 * 破坏了相对位置，是不稳定的
 * @Author maoty
 * @Date 2019-12-24 8:50
 */
public class Selection {
    public static void main(String[] args) {
        Integer[] data = {888, 3, 2, 1, 6, 5, 4, 3, 52, 5, 12, 45};

        Selection bubble = new Selection();
        System.out.println(Arrays.toString(data));
        System.out.println(
                "-----------------------------------------------------------------------");
        bubble.sort(data);
    }

    public void sort(Comparable[] data) {
        if (data != null && data.length < 2) return;

        int minIndex = 0;
        for (int i = 0; i < data.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minIndex].compareTo(data[j]) > 0)
                    minIndex = j;
            }
            if (minIndex != i) {
                Tool.swap(data, i, minIndex);
                System.out.println(Arrays.toString(data));
            }

        }
    }
}
