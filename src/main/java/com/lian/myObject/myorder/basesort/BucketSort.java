package com.lian.myObject.myorder.basesort;

import cn.hutool.core.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 桶排序  先将数组分成几部分，然后对每一部分进行排序。
 * @author Ted
 * @version 1.0
 * @date 2020/7/16 22:08
 */
public class BucketSort implements Sort{
    /**
     * 分组因子
     */
    private int groupFactor;
    /**
     * 分组数组
     */
    private int[][] groupArray;

    private int[] groupIndex;

    private static List<Sort> sortList = new ArrayList<>();

    static {
        sortList.add(new BubbleSort());
        sortList.add(new CountSort());
        sortList.add(new InsertSort());
        sortList.add(new QuickSort());
        sortList.add(new RecurSort());
        sortList.add(new ShellSort(3));
        sortList.add(new SelectionSort());
        sortList.add(new BucketSort(4));
        sortList.add(new HeapSort());
    }

    public BucketSort(Integer groupFactor){
        this.groupFactor = groupFactor;
        groupArray = new int[groupFactor][];
        groupIndex = new int[groupFactor];
    }

    @Override
    public int[] sort(int[] arr, String sortType) {
        System.out.println("----------桶排序----------");
        if(arr==null){
            return null;
        }
       if(sortType.toLowerCase().equals("asc")){
           bucketSortAsc(arr);
       }else if(sortType.toLowerCase().equals("desc")){
           bucketSortDesc(arr);
       }
       return arr;
    }

    /**
     * 正序
     * @param arr
     */
    public void bucketSortAsc(int[] arr){
        //排序数组长度
        Integer total = arr.length;
        Integer max = arr[0];
        Integer min = arr[0];
        for (int i=0;i<total;i++){
            if(max<arr[i]){
                max = arr[i];
            }
            if(min>arr[i]){
                min = arr[i];
            }
        }
        //最大值和最小值 除以桶的数量，得到桶之间的gap
        int gap = (max - min) / groupFactor+1;
        //将每个桶的下标初始化
        for (int i=0;i<groupFactor;i++){
            groupIndex[i] = 0;
        }
        //将排序数组元素分配到每个桶中
        for (int i=0;i<total;i++){
            for (int j=0;j<groupFactor;j++){
                if(arr[i]>=min+j*gap&&arr[i]<min+(j+1)*gap){
                    int[] newArray = new int[groupIndex[j] + 1];
                    if(groupArray[j]!=null){
                        ArrayUtil.copy(groupArray[j],newArray,groupArray[j].length);
                    }
                    newArray[groupIndex[j]++] = arr[i];
                    groupArray[j] = newArray;
                }
            }
        }
        //给每个桶进行排序
        for (int i=0;i<groupFactor;i++){
            Sort sort = sortList.get(new Random().nextInt(sortList.size() - 1));
            groupArray[i] = sort.sort(groupArray[i], "asc");
        }

        int index = 0;
        for (int i=0;i<groupFactor;i++){
            for (int j=0;j<groupArray[i].length;j++){
                if(groupArray[i][j]!=0){
                    arr[index++] = groupArray[i][j];
                }
            }
        }

    }

    /**
     * 逆序
     * @param arr
     */
    public void bucketSortDesc(int[] arr){
        //排序数组长度
        Integer total = arr.length;
        Integer max = 0;
        Integer min = 0;
        for (int i=0;i<total;i++){
            if(max<arr[i]){
                max = arr[i];
            }
            if(min>arr[i]){
                min = arr[i];
            }
        }
        //最大值和最小值 除以桶的数量，得到桶之间的gap
        int gap = (max - min) / groupFactor;
        //给每个桶初始化,并且将每个桶的下标初始化
        for (int i=0;i<groupFactor;i++){
            groupArray[i] = new int[total];
            groupIndex[i] = 0;
        }
        //将排序数组元素分配到每个桶中
        for (int i=0;i<total;i++){
            for (int j=0;j<groupFactor;j++){
                if(arr[i]>=min+j*gap&&arr[i]<max+j*gap){
                    groupArray[j][groupIndex[j]++] = arr[i];
                }
            }
        }
        //给每个桶进行排序
        for (int i=0;i<groupFactor;i++){
            Sort sort = sortList.get(new Random().nextInt(sortList.size() - 1));
            groupArray[i] = sort.sort(groupArray[i], "desc");
        }

        int index = 0;
        for (int i=groupFactor;i>=0;i++){
            for (int j=0;j<groupArray[i].length;j++){
                arr[index++] = groupArray[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        BucketSort bucketSort = new BucketSort(4);
        arr = bucketSort.sort(arr, "asc");
        System.out.println();
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }


}
