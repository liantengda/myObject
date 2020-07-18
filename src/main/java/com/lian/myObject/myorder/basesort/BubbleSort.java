package com.lian.myObject.myorder.basesort;

/**
 * 冒泡排序
 *
 * 依次比较相邻两个数的值
 * @author Ted
 * @date 2020/7/13 13:29
 */
public class BubbleSort implements Sort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {8, 5, 6, 2, 1, 0, 4, 3, 7, 9};
        bubbleSort.sort(arr,"desc");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }


    @Override
    public int[] sort(int[] arr, String sortType) {
        System.out.println("--------冒泡排序----------");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        String sortTypeLowerCase = sortType.toLowerCase();
        if(sortTypeLowerCase.equals("asc")){
            ascSort(arr);
        }else if(sortTypeLowerCase.equals("desc")){
            descSort(arr);
        }
        return arr;
    }

    /**
     * 正序
     * @param arr
     */
    private void ascSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j =0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    Integer tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
            for (int element : arr) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    /**
     * 倒序
     * @param arr
     */
    private void descSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j =0;j<arr.length-1;j++){
                if(arr[j]<arr[j+1]){
                    Integer tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
            for (int element : arr) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

}
