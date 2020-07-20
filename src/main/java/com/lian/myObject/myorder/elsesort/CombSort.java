package com.lian.myObject.myorder.elsesort;

import java.util.Random;
import java.util.Scanner;

/**
 * 梳排序
 * @author Ted
 * @version 1.0
 * @date 2020/7/16 22:14
 */
public class CombSort {

    public static void myComSort(int[] arr){
        int i,j;
        int increment;
        if(arr==null){
            return;
        }
        increment = arr.length;
        while (true){
            increment /=1.3;
            for (i = 0;i<increment;i++){
                for (j = i+increment;j<arr.length;j+=increment){
                    if(arr[j]<arr[j-increment]){
                        int tmp = arr[j-increment];
                        arr[j-increment] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
            if(increment<=1){
                break;
            }
        }
        return;
    }

    /**
     * 这个梳子排序是错误的
     * @param num
     * @param n
     */
    public static void combSort(int []num,int n)
    {
        int incre = n;
        while(incre >= 1)
        {
            int i = 0;
            incre /= 1.1;
            while(i + incre < n)
            {
                if(num[i] > num[i + incre])
                {
                    int t = num[i];
                    num[i] = num[i + incre];
                    num[i + incre] = t;
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {18, 31, 5, 28, 5, 9, 25, 8, 32, 4, 37, 8, 30, 12, 34, 3, 9, 39, 8, 38, 33, 1, 11, 10, 24, 6, 46, 6, 9};
        for (int i : arr) {
            System.out.print(i+" ");
        }
        myComSort(arr);
        System.out.println();
        System.out.println("----------------");
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }


}
