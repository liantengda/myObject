package com.lian.myObject.myorder;

/**
 * 快速排序
 *
 * 思想：先从数组中选择一个数作为基数，然后将比它的数放到右边，将比它小的数放到左边。最后留下一个位置就是这个基数的精准位置。
 *
 * @author Ted
 * @version 1.0
 * @date 2020/7/15 23:26
 */
public class QuickOrder {

    private Integer[] orderArray;

    public QuickOrder(Integer[] orderArray){
        this.orderArray = orderArray;
    }


    public void  recurQuick(int leftPtr,int baseIndex,int rightPtr){

        if(leftPtr>=rightPtr){
            return;
        }

        Integer base = quickOrder(leftPtr, orderArray[baseIndex], rightPtr);

        //递归左侧
        recurQuick(leftPtr,leftPtr,base-1);
        //递归右侧
        recurQuick(base+1,base+1,rightPtr);
    }


    public Integer quickOrder(int leftPtr,int baseNum,int rightPtr){
        //需要的循环次数
        int needTimes = rightPtr-leftPtr-1;
        int loop = 0;

        while (loop<=needTimes){
            //如果右侧数大于基数，则循环右侧直到右侧数小于基数
          while (orderArray[rightPtr]>baseNum&&loop<=needTimes) {
              rightPtr--;
              loop++;
          }
          if(loop<=needTimes){
              //将右侧数赋值给左侧数，左侧指针+1
              orderArray[leftPtr++] = orderArray[rightPtr];
              loop++;
          }
          // 循环左侧数直到左侧数大于基数
          while (orderArray[leftPtr]<baseNum&&loop<=needTimes){
                leftPtr++;
                loop++;
          }
          if(loop<=needTimes){
              orderArray[rightPtr--]= orderArray[leftPtr];
              loop++;
          }
        }
        orderArray[leftPtr] = baseNum;
        return leftPtr;
    }

    public static void main(String[] args) {
        QuickOrder quickOrder = new QuickOrder(new Integer[]{9,100,22,10,38,74, 1, 20,33,2,3,22,19});
        quickOrder.recurQuick(0,0,quickOrder.orderArray.length-1);
        for (Integer integer : quickOrder.orderArray) {
            System.out.print(integer+" ");
        }
    }
}
