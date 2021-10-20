package com.lian.myObject.myorder.evolveSort;

/**
 * @author Ted
 * @version 1.0
 * @date 2021/9/19 14:30
 */
public class Selection {

    public static void sort(int[] arr){
        int N = arr.length;
        for (int i=0;i<N;i++){
            int min = i;
            for (int j= i+1;j<N;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
                exchange(arr,i,min);
            }
        }
    }

    /**
     * 互换位置
     * @param arr
     * @param index1
     * @param index2
     */
    private static void exchange(int[] arr, int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,5,6,0,10,234,543,11,24,26};
        sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
