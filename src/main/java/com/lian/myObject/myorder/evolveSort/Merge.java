package com.lian.myObject.myorder.evolveSort;

/**
 * @author Ted
 * @version 1.0
 * @date 2021/9/19 10:58
 */
public class Merge {

    private static int[] aux;

    public static void sort(int[] arr){
        aux = new int[arr.length];//一次性分配空间
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr,int left,int right){
        if(right<=left) return;
        int mid = left+(right-left)/2;
        sort(arr,left,mid);//左侧排序
        sort(arr,mid+1,right);//右侧排序
        merge(arr,left,mid,right);//合并
    }

    public static void merge(int[] arr,int left,int mid,int right){
        int i = left, j = mid+1;
        for (int k = left;k<= right;k++){
            aux[k] = arr[k];//复制到辅助空间
        }
        for (int k=left;k<=right;k++){
            if(i>mid)               arr[k] = aux[j++];
            else if(j>right)        arr[k] = aux[i++];
            else if(aux[j]<aux[i])  arr[k] = aux[j++];
            else                    arr[k] = aux[i++];
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{9,5,6,0,10,234,543,11,24,26};
        sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }


}
