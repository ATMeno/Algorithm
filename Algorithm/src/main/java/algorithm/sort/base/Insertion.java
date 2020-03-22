package algorithm.sort.base;

import algorithm.util.Tool;

import java.util.Arrays;

/**
 * @Description 插入排序
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
        System.out.println(Arrays.toString(data));
    }

    /**
     * 分已排序区间和未排序区间
     * 假设前面的数据是有序的，每次取后面的数据插入前面有序数组
     * 稳定
     * @param data
     */
    public static void sort(Comparable[] data) {
        if (data != null && data.length < 2) return;

        for (int i = 1; i < data.length; i++) {
            //从后往前进行比较
            Comparable tempData = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(tempData.compareTo(data[j]) >= 0){
                    break;
                }else {
                    //依次往后移
                    data[j+1] = data[j];
                }
            }
            data[j+1] = tempData;
        }
    }
}
