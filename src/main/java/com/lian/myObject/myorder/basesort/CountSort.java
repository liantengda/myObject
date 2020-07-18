package com.lian.myObject.myorder.basesort;

/**
 * 计数排序
 *
 * 指定小范围内，大数据量的排序
 *
 *
 * 案例：高考成绩 0-750分， 一共1000w人参加考试，如果你考了549分，你的排名是多少。
 *
 * @author Ted
 * @date 2020/7/13 9:46
 */
public class CountSort implements Sort{



    public static void main(String[] args) {

        int[] arr = {0,549,1,20,30,749,549,533,459,40,50,750,749,260,441,549,640,630,300,200,400,500,532,491,488,356,475};
        Integer myScore = 549;

        CountSort countSort = new CountSort();
        arr = countSort.sort(arr, "asc");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        int myOrder = 0;

        for (int i=0;i<arr.length;i++){
            if(arr[i]==myScore){
                myOrder = i;
                break;
            }
        }

        System.out.println("我的排名:"+myOrder);
    }

    @Override
    public int[] sort(int[] arr, String sortType) {
        System.out.println("----------计数排序------------");
        if(sortType.toLowerCase().equals("asc")){
            arr = sortAsc(arr);
        }else if(sortType.toLowerCase().equals("desc")){
            arr = sortDesc(arr);
        }
        return arr;
    }

    /**
     * 计数排序--正数
     * @param arr
     * @return
     */
    private int[] sortAsc(int[] arr){
        int max = 0;
        int min = 0;
        if(arr==null){
            return null;
        }
        for (int i =0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        int[] countArray = new int[max-min+1];

        for (int i=0;i<arr.length;i++){
            countArray[arr[i]]++;
        }

        int index = 0;
        for (int i=0;i<countArray.length;i++){
            if(countArray[i]>0){
                for (int j =0;j<countArray[i];j++){
                    arr[index++] = i;
                }
            }
        }
        return arr;
    }

    /**
     * 计数排序 -- 倒序
     * @param arr
     * @return
     */
    private int[] sortDesc(int[] arr){
        int max = 0;
        int min = 0;
        for (int i =0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        int[] countArray = new int[max-min+1];

        for (int i=0;i<arr.length;i++){
            countArray[arr[i]]++;
        }

        int index = 0;
        for (int i=countArray.length-1;i>=0;i--){
            if(countArray[i]>0){
                for (int j =0;j<countArray[i];j++){
                    arr[index++] = i;
                }
            }
        }
        return arr;
    }
}
