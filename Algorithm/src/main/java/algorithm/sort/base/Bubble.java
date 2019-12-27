package algorithm.sort.base;

import algorithm.util.Tool;

import java.util.Arrays;

/**
 * @Description 冒泡排序:从第一个比较到最后一个，每次将最大的数移动到最后
 * @Author maoty
 * @Date 2019-12-23 14:43
 */
public class Bubble {
    public static void main(String[] args) {
        Integer[] data = {888, 3, 2, 1, 6, 5, 4, 3, 52, 5, 12, 45};

        Bubble bubble = new Bubble();
        System.out.println(Arrays.toString(data));
        System.out.println("-----------------------------------------------------------------------");
        bubble.sortOpt1(data);
    }

    public void sort(Comparable[] data) {
        if(data != null && data.length < 2) return;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0)
                    Tool.swap(data, j, j + 1);
            }
        }
    }

    /**
     * 优化1：增加交换标志位flag,如果没有交换，则表示有序
     *
     * @param data
     */
    public void sortOpt1(Comparable[] data) {
        if(data != null && data.length < 2) return;

        boolean flag = false;//是否有数据交换
        for (int i = 0; i < data.length; i++) {
            flag  = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    Tool.swap(data, j, j + 1);
                    System.out.println(Arrays.toString(data));
                    flag = true;
                }
            }

            if (!flag) break;
        }
    }
}
