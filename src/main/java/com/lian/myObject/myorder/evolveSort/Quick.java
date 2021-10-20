package com.lian.myObject.myorder.evolveSort;

/**
 *
 * 快速排序
 * @author Ted
 * @version 1.0
 * @date 2021/9/19 8:43
 */
public class Quick {


    public static void main(String[] args) {
        int[] arr = new int[]{9,5,6,0,10,234,543,11,24,26};
        //排序
        sort(arr,0,arr.length-1);
        //打印输出
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    /**
     * 排序
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr,int left,int right){
        if(right<=left) return;
        int baseIndex = partition(arr, left, right);
        sort(arr,left,baseIndex-1);
        sort(arr,baseIndex+1,right);
    }

    /**
     * 分区
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr,int left,int right){
        int i = left,j = right+1;
        int baseNum = arr[left];
        //循环完整个排序数组，找到 baseNum的基准位置
        while (true){
            //从左侧遍历 直到 左侧大于基数的值出现
            while (arr[++i]<baseNum){
                if (i==right)
                    break;
            }
            // 从右侧遍历 直到 右侧小于基数的值出现
            while (baseNum<arr[--j]){
                if(j==left)
                    break;
            }
            //左指针 与 右 指针相遇 就结束大循环
            if(i>=j)break;
            //左侧和右侧互换
            exchange(arr,i,j);
        }
        //循环完成, 基数移动到基准位置
        exchange(arr,left,j);
        //返回下标
        return j;
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

}
