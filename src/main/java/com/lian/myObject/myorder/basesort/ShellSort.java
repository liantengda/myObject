package com.lian.myObject.myorder.basesort;

/**
 * 希尔排序
 *
 * 将数组按照某个间距大小分组，每隔一个间距分到一组。
 *
 * 对每个分组进行插入排序
 * @author Ted
 * @date 2020/7/13 13:29
 */
public class ShellSort implements Sort<int[]>{


    @Override
    public  int[] sort(int[] array,String sortType) {
        System.out.println("---------希尔排序--------");
        if(array==null){
            return null;
        }
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int index = i - gap;
                while (index >= 0 && array[index] > temp) {
                    array[index + gap] = array[index];
                    index -= gap;
                }
                array[index + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 9, 3, 2, 7, 2};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arr,"asc");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
