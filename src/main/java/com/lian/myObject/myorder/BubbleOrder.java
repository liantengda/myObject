package com.lian.myObject.myorder;

/**
 * 冒泡排序
 *
 * 依次比较相邻两个数的值
 * @author Ted
 * @date 2020/7/13 13:29
 */
public class BubbleOrder {

    private static Integer[] myArray = {3,2,5,8,8,1,1,4};
    public static void main(String[] args) {
        for (int i=0;i<myArray.length;i++){
            for (int j =0;j<myArray.length-1;j++){
                if(myArray[j]<myArray[j+1]){
                    Integer tmp = myArray[j+1];
                    myArray[j+1] = myArray[j];
                    myArray[j] = tmp;
                }
            }
        }

        for (Integer integer : myArray) {
            System.out.print(integer+" ");
        }
    }
}
