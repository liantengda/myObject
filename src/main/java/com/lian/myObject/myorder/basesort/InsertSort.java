package com.lian.myObject.myorder.basesort;

/**
 * 插入排序
 *
 * 基本有序，或者规模较小的时候有用
 *
 * 先插入一个到新的空间，接着插入第二个到新的空间，但是需要与第一个比较，
 *
 * 再插入一个到新的空间，但是需要与前两个比较。。。一次类推
 *
 * @author Ted
 * @date 2020/7/14 14:56
 */
public class InsertSort implements Sort<int[]>{

    @Override
    public int[] sort(int[] arr, String sortType) {
        System.out.println("--------插入排序---------");
        if(sortType.toLowerCase().equals("asc")){
            arr = sortAsc(arr);
        }else if(sortType.toLowerCase().equals("desc")){
            arr = sortDesc(arr);
        }
        return arr;
    }

    /**
     * 正序
     * @param arr
     * @return
     */
    private int[] sortAsc(int[] arr){
        if(arr==null){
            return null;
        }
        int i,k;
        int[] orderedArray = new int[arr.length];
        for (i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
            for (k = i; k > 0; k--) {
                if (orderedArray[k - 1] > arr[i]) {
                    orderedArray[k] = orderedArray[k - 1];
                } else {
                    break;
                }
            }
            orderedArray[k] = arr[i];
        }
        return orderedArray;
    }

    /**
     * 倒序
     * @param arr
     * @return
     */
    private int[] sortDesc(int[] arr){
        if(arr==null){
            return null;
        }
        int i,k;
        int[] orderedArray = new int[arr.length];
        for (i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
            for (k = i; k > 0; k--) {
                if (orderedArray[k - 1] < arr[i]) {
                    orderedArray[k] = orderedArray[k - 1];
                } else {
                    break;
                }
            }
            orderedArray[k] = arr[i];
        }
        return orderedArray;
    }




    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        arr = insertSort.sort(arr, "asc");
        System.out.println();
        for (Integer integer : arr) {
            System.out.print(integer+" ");
        }
    }
}
