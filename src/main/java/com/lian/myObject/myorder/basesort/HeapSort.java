package com.lian.myObject.myorder.basesort;

/**
 * 堆排序
 * @author Ted
 * @version 1.0
 * @date 2020/7/15 23:01
 */
public class HeapSort implements Sort<int[]> {

    @Override
    public int[] sort(int[] arr, String sortType) {
        if(arr==null){
            return null;
        }
        System.out.println("---------堆排序------------");
        if(sortType.toLowerCase().equals("asc")){
            heapSort(arr,arr.length);
        }else if(sortType.toLowerCase().equals("desc")){
            heapSort(arr,arr.length);
        }
        return arr;
    }
    /**
     * 创建堆函数
     * @param arr
     * @param n
     * @param i
     */
    private void heapCreate(int arr[], int n, int i)
    {
        int lagest = i; // 将第一个非叶子节点设置为堆顶元素
        int left = 2*i + 1; // left = 2*i + 1
        int right = 2*i + 2; // right = 2*i + 2

        // 如果 left 比 root 大的话
        if (left < n && arr[left] > arr[lagest])
            lagest = left;

        // I如果 right 比 root 大的话
        if (right < n && arr[right] > arr[lagest])
            lagest = right;

        if (lagest != i)
        {
            int tmp = arr[i];
            arr[i] = arr[lagest];
            arr[lagest] = tmp;
            // 递归地定义子堆
            heapCreate(arr, n, lagest);
        }
    }

    /**
     * n位数组长度
     * @param arr
     * @param n
     */
   private void heapSort(int arr[], int n)
    {
        // 建立一个头部元素最大的堆
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
        HeapSort heapSort = new HeapSort();
        int[] arr = new int[]{6,4,2,1,8,7,9,5,3};
        heapSort.sort(arr,"asc");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
