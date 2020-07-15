package com.lian.myObject.myorder;

/**
 * 堆排序
 * @author Ted
 * @version 1.0
 * @date 2020/7/15 23:01
 */
public class HeapOrder {


    /**
     * 创建堆函数
     * @param arr
     * @param n
     * @param i
     */
    public void heapCreate(int arr[], int n, int i)
    {
        int largest = i; // 将最大元素设置为堆顶元素
        int left = 2*i + 1; // left = 2*i + 1
        int right = 2*i + 2; // right = 2*i + 2

        // 如果 left 比 root 大的话
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // I如果 right 比 root 大的话
        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i)
        {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            // 递归地定义子堆
            heapCreate(arr, n, largest);
        }
    }

    /**
     * n位数组长度
     * @param arr
     * @param n
     */
   public void heapSort(int arr[], int n)
    {
        // 建立堆
        for (int i = n / 2 - 1; i >= 0; i--)
            heapCreate(arr, n, i);

        // 一个个从堆顶取出元素
        for (int i=n-1; i>=0; i--)
        {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapCreate(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        HeapOrder heapOrder = new HeapOrder();
        int[] arr = new int[]{6,4,2,1,8,9,10,5,3};
        heapOrder.heapSort(arr,9);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }


}
