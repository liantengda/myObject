package com.lian.myObject.myorder.basesort;

/**
 * 快速排序
 *
 * 思想：先从数组中选择一个数作为基数，然后将比它大的数放到右边，将比它小的数放到左边。最后留下一个位置就是这个基数的精准位置。
 *
 * @author Ted
 * @version 1.0
 * @date 2020/7/15 23:26
 */
public class QuickSort implements Sort<int[]> {

    @Override
    public int[] sort(int[] arr, String sortType) {
        System.out.println("----------快速排序----------");
        if(arr==null){
            return null;
        }
        if(sortType.toLowerCase().equals("asc")){
            recurQuickAsc(arr,0,0,arr.length-1);
        }else if(sortType.toLowerCase().equals("desc")){
            recurQuickDesc(arr,0,0,arr.length-1);
        }
        return arr;
    }


    /**
     * 递归---正序
     * @param arr
     * @param leftPtr
     * @param baseIndex
     * @param rightPtr
     */
    public void recurQuickAsc(int[] arr, int leftPtr, int baseIndex, int rightPtr){

        if(leftPtr>=rightPtr){
            return;
        }

        Integer base = quickSortAsc(arr,leftPtr, arr[baseIndex], rightPtr);

        //递归左侧
        recurQuickAsc(arr,leftPtr,leftPtr,base-1);
        //递归右侧
        recurQuickAsc(arr,base+1,base+1,rightPtr);
    }

    /**
     * 找到基数准确位置 -- 正序
     * @param arr
     * @param leftPtr
     * @param baseNum
     * @param rightPtr
     * @return
     */
    public Integer quickSortAsc(int[] arr, int leftPtr, int baseNum, int rightPtr){
        //需要的循环次数
        int needTimes = rightPtr-leftPtr-1;
        int loop = 0;
        while (loop<=needTimes){
            //如果右侧数大于基数，则循环右侧直到右侧数小于基数
          while (arr[rightPtr]>baseNum&&loop<=needTimes) {
              rightPtr--;
              loop++;
          }
          if(loop<=needTimes){
              //将右侧数赋值给左侧数，左侧指针+1
              arr[leftPtr++] = arr[rightPtr];
              loop++;
          }
          // 循环左侧数直到左侧数大于基数
          while (arr[leftPtr]<baseNum&&loop<=needTimes){
                leftPtr++;
                loop++;
          }
          if(loop<=needTimes){
              arr[rightPtr--]= arr[leftPtr];
              loop++;
          }
        }
        arr[leftPtr] = baseNum;
        return leftPtr;
    }

    /**
     * 递归 -- 逆序
     * @param arr
     * @param leftPtr
     * @param baseIndex
     * @param rightPtr
     */
    public void recurQuickDesc(int[] arr, int leftPtr, int baseIndex, int rightPtr){

        if(leftPtr>=rightPtr){
            return;
        }

        Integer base = quickSortDesc(arr,leftPtr, arr[baseIndex], rightPtr);

        //递归左侧
        recurQuickDesc(arr,leftPtr,leftPtr,base-1);
        //递归右侧
        recurQuickDesc(arr,base+1,base+1,rightPtr);
    }

    /**
     * 找到基数准确位置 -- 逆序
     * @param arr
     * @param leftPtr
     * @param baseNum
     * @param rightPtr
     * @return
     */
    public Integer quickSortDesc(int[] arr, int leftPtr, int baseNum, int rightPtr){
        //需要的循环次数
        int needTimes = rightPtr-leftPtr-1;
        int loop = 0;

        while (loop<=needTimes){
            //如果右侧数大于基数，则循环右侧直到右侧数小于基数
            while (arr[rightPtr]<baseNum&&loop<=needTimes) {
                rightPtr--;
                loop++;
            }
            if(loop<=needTimes){
                //将右侧数赋值给左侧数，左侧指针+1
                arr[leftPtr++] = arr[rightPtr];
                loop++;
            }
            // 循环左侧数直到左侧数大于基数
            while (arr[leftPtr]>baseNum&&loop<=needTimes){
                leftPtr++;
                loop++;
            }
            if(loop<=needTimes){
                arr[rightPtr--]= arr[leftPtr];
                loop++;
            }
        }
        arr[leftPtr] = baseNum;
        return leftPtr;
    }


    public static void main(String[] args) {
        int[] arr = {9, 100, 22, 10, 38, 74, 1, 20, 33, 2, 3, 22, 19};
        QuickSort quickSort = new QuickSort();
        arr = quickSort.sort(arr, "asc");
        for (Integer integer : arr) {
            System.out.print(integer+" ");
        }
    }


}
