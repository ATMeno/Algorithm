package algorithm.sort.division;

import algorithm.sort.base.Selection;
import algorithm.util.Tool;

import java.util.Arrays;

/**
 * @Description 归并排序
 * @Author maoty
 * @Date 2019-12-26 11:41
 */
public class Merge {
    public static void main(String[] args) {
        Integer[] data = {888, 3, 2, 1, 6, 5, 4, 3, 52, 5, 12, 45};

        Merge bubble = new Merge();
        System.out.println(Arrays.toString(data));
        System.out.println(
                "-----------------------------------------------------------------------");
        bubble.sort(data);
    }

    public Comparable[] sort(Comparable[] data) {
        if (data != null && data.length < 2) return data;
        return  null;
    }

    /**
     * @param data1 有序数组1
     * @param data2 有序数组2
     * @return 数组1和数组2合并后的有序数组
     */
    private Comparable[] mergeSort(Comparable[] data1, Comparable[] data2) {
        int index1 = 0;
        int index2 = 0;
        Comparable[] temp = new Comparable[data1.length + data2.length];

        while (index1 < data1.length && index2 < data2.length) {
            if (data1[index1].compareTo(data2[index2]) < 0) {
                temp[index1 + index2] = data1[index1];
                index1++;
            } else {
                temp[index1 + index2] = data2[index2];
                index2++;
            }
        }

        if (index1 < data1.length) {
            for (int i = index1; i < data1.length; i++) {
                temp[index1 + index2] = data1[index1];
                index1++;
            }
        } else if (index2 < data2.length) {
            for (int i = index2; i < data2.length; i++) {
                temp[index1 + index2] = data1[index2];
                index2++;
            }
        }

        return temp;
    }
}
