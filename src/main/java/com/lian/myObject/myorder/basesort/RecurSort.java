package com.lian.myObject.myorder.basesort;

/**
 * 归并排序
 * 真是难
 *
 * 首先每次排序都需要传入排序数组，每次合并完成都需要赋值给排序数组。这样便可以更新数组。更新成排序完成的样子。
 *
 *
 * @author Ted
 * @version 1.0
 * @date 2020/7/14 21:15
 */
public class RecurSort implements Sort<int[]> {



    @Override
    public int[] sort(int[] arr, String sortType) {
        System.out.println("-----------归并排序-----------");
        if(arr==null){
            return null;
        }
        if(sortType.toLowerCase().equals("asc")){
            recurSortAsc(arr,0,arr.length-1);
        }else if(sortType.toLowerCase().equals("desc")){
            recurSortDesc(arr,0,arr.length-1);
        }
        return arr;
    }


    private void recurSortAsc(int[] arr, int leftPor, int rightPor){

        if(leftPor>=rightPor){
            return ;
        }
        int mid = leftPor+ ((rightPor-leftPor)>>1);
        System.out.println("中间位:"+mid);
        // 左半边排序
        recurSortAsc(arr,leftPor,mid);
        //右半边排序
        recurSortAsc(arr,mid+1,rightPor);
        mergeAsc(arr,leftPor,rightPor,mid);
    }

    /**
     * 对某排好顺序的两个数组进行合并 ---正序
     * @param leftPor 左边界
     * @param rightPor 右边界
     * @param mid 分隔点
     * @return
     */
    private void mergeAsc(int[] arr, Integer leftPor, Integer rightPor, Integer mid){
        Integer[] totalArray = new Integer[rightPor-leftPor+1];
        int p1=leftPor,p2=mid+1,index =0;
        while (p2<=rightPor&&p1<=mid) {
            if (arr[p1] < arr[p2]) {
                totalArray[index] = arr[p1];
                p1++;
                index++;
            } else {
                totalArray[index] = arr[p2];
                p2++;
                index++;
            }
        }
        while (p2<=rightPor){
            totalArray[index] = arr[p2];
            p2++;
            index++;
        }
        while (p1<=mid){
            totalArray[index] = arr[p1];
            p1++;
            index++;
        }

        for (int j =0;j<totalArray.length;j++){
            arr[j+leftPor]=totalArray[j];
        }
    }

    /**
     * 逆序
     * @param arr
     * @param leftPor
     * @param rightPor
     */
    private void recurSortDesc(int[] arr, int leftPor, int rightPor){

        if(leftPor>=rightPor){
            return ;
        }
        int mid = leftPor+ ((rightPor-leftPor)>>1);
        System.out.println("中间位:"+mid);
        // 左半边排序
        recurSortDesc(arr,leftPor,mid);
        //右半边排序
        recurSortDesc(arr,mid+1,rightPor);
        mergeDesc(arr,leftPor,rightPor,mid);
    }

    /**
     * 对某排好顺序的两个数组进行合并 -- 逆序
     * @param leftPor 左边界
     * @param rightPor 右边界
     * @param mid 分隔点
     * @return
     */
    private void mergeDesc(int[] arr, Integer leftPor, Integer rightPor, Integer mid){
        Integer[] totalArray = new Integer[rightPor-leftPor+1];
        int p1=leftPor,p2=mid+1,index =0;

        while (p2<=rightPor&&p1<=mid) {
            if (arr[p1] > arr[p2]) {
                totalArray[index] = arr[p1];
                p1++;
                index++;
            } else {
                totalArray[index] = arr[p2];
                p2++;
                index++;
            }
        }
        while (p2<=rightPor){
            totalArray[index] = arr[p2];
            p2++;
            index++;
        }
        while (p1<=mid){
            totalArray[index] = arr[p1];
            p1++;
            index++;
        }

        for (int j =0;j<totalArray.length;j++){
            arr[j+leftPor]=totalArray[j];
        }
    }


    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10, 11, 12, 101};
        RecurSort recurSort = new RecurSort();
        recurSort.sort(arr,"desc");
        System.out.println("-----------------------");
        for (Integer integer : arr) {
            System.out.print(integer+" ");
        }

    }


}
