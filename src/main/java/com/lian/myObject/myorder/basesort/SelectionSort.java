package com.lian.myObject.myorder.basesort;

/**
 * 选择排序
 * 最简单，最没用
 * @author Ted
 * @version 1.0
 * @date 2020/7/15 23:26
 */
public class SelectionSort implements Sort {


    @Override
    public int[] sort(int[] arr, String sortType) {
        System.out.println("----------选择排序-----------");
       if(sortType.toLowerCase().equals("asc")){
           sortAsc(arr);
       }else if(sortType.toLowerCase().equals("desc")){
           sortDesc(arr);
       }
        return arr;
    }

    /**
     * 正序
     * @param arr
     */
    private void sortAsc(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min = arr[i];
            int k =i;
            for(int j=i;j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];
                    k = j;
                }
            }
            arr[k] = arr[i];
            arr[i] = min;
        }
    }

    /**
     * 逆序
     * @param arr
     */
    private void sortDesc(int[] arr){
        for(int i=0;i<arr.length;i++){
            int max = arr[i];
            int k =i;
            for(int j=i;j<arr.length;j++){
                if(max<arr[j]){
                    max = arr[j];
                    k = j;
                }
            }
            arr[k] = arr[i];
            arr[i] = max;
        }
    }


    public static void main(String[] args) {
        SelectionSort SelectionSort = new SelectionSort();
        int[] arr = {9, 2, 3, 5, 1, 6, 8, 7, 0, 100, 43, 23, 97, 65, 57, 84, 30};
         arr = SelectionSort.sort(arr, "desc");
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}
