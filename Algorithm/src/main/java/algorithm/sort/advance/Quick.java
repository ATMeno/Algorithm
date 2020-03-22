package algorithm.sort.advance;

import algorithm.util.Tool;

import java.util.Arrays;

/**
 * 快速排序
 */
public class Quick {
    public static void main(String[] args) {
        //Integer[] data = {888, 3, 2, 1, 6, 5, 4, 3, 52, 5, 12, 45};
        //Integer[] data = {36, 60, 46, 95, 47, 1, 19, 69, 87, 89};
        Integer[] data = Tool.ramdom(10,0, 100);

        Quick insertion = new Quick();
        System.out.println(Arrays.toString(data));
        System.out.println("-----------------------------------------------------------------------");
        //insertion.sortPlus(data, 0, data.length - 1, 0);
        insertion.sort(data, 0, data.length - 1);
    }

    /**
     * 思路：
     * 取基准数(默认第一个)
     * 从后面往前找到比基准数小的数进行对换，从前面往后面找比基准数大的进行对换
     * 重复上一步骤直到左边数都小于基准数，右边数都大于基准数
     * <p>
     * 特点：原地排序
     * <p>
     * 优化思路：
     * 基准数取值（三数取中）
     *
     * @param data
     * @param left
     * @param right
     */
    public void sort(Comparable[] data, int left, int right) {
        int endIndx = div(data, left, right, left);
        //递归，分为三部分，左右继续快排
        if (left < endIndx)
            this.sort(data, left, endIndx - 1);
        if (endIndx < right)
            this.sort(data, endIndx + 1, right);
    }

    /**
     * 优化：基准数取值（三数取中）
     * @param data
     * @param left
     * @param right
     * @param midIndex
     */
    public void sortPlus(Comparable[] data, int left, int right, int midIndex) {
        int endIndex = div(data, left, right, midIndex);
        //递归，分为三部分，左右继续快排
        if (left < endIndex)
            this.sortPlus(data, left, endIndex - 1, mid(data, left, left + (endIndex - 1 - left >> 1), endIndex - 1));
        if (endIndex < right)
            this.sortPlus(data, endIndex + 1, right, mid(data, endIndex + 1, endIndex + 1 + (right - endIndex - 1 >> 1), right));
    }

    /**
     * 按照基准数分割成左右两块
     *
     * @param data
     * @param left
     * @param right
     * @param midIndex
     * @return
     */
    private int div(Comparable[] data, int left, int right, int midIndex) {
        Comparable base = data[midIndex]; //基准数，取中等大小那个
        Tool.swap(data,left,midIndex); //将基准数移到第一个位置
        System.out.print("base:" + base + " left:" + left + " right:" + right);
        while (left < right) {
            //从后往前找比基准数小的
            while (left < right && data[right].compareTo(base) >= 0) {
                right--;
            }
            //表示是找到有的
            if (left < right) {
                Tool.swap(data, left, right);
                left++;
            }
            //从前往前找比基准数大的
            while (left < right && data[left].compareTo(base) <= 0) {
                left++;
            }
            if (left < right) {
                Tool.swap(data, left, right);
                right--;
            }
        }

        System.out.println(Arrays.toString(data));
        return right;
    }

    /**
     * 获取三个数中间那个数的下标
     *
     * @param data
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private int mid(Comparable[] data, int left, int mid, int right) {
        if (data[left].compareTo(data[mid]) * data[left].compareTo(data[right]) <= 0) return left;
        if (data[right].compareTo(data[mid]) * data[right].compareTo(data[mid]) <= 0) return right;
        return mid;
    }
}
