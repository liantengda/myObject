package com.lian.myObject.myorder.evolveSort;

/**
 * @author Ted
 * @version 1.0
 * @date 2021/9/19 15:01
 */
public class Shell {

    /**
     *
     * @param arr
     */
    public static void sort(int[] arr){
        int N = arr.length;
        int h = 1;
        while (h<N/3) h=3*h+1;
        while (h>=1){
            for (int i=h;i<N;i++){
                for (int j=i;j>=h&&arr[j]<arr[j-h];j-=h){
                    exchange(arr,j,j-h);
                }
            }
            h = h/3;
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
