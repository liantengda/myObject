package com.lian.myObject.myorder;

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
public class CountOrder {

    private static Integer[] myArray = {0,549,1,20,30,749,549,533,459,40,50,750,749,260,441,549,640,630,300,200,400,500,532,491,488,356,475};

    private static Integer myScore = 549;

    public static void main(String[] args) {

        Integer[] countArray = new Integer[751];

        for (int i=0;i<countArray.length;i++){
            countArray[i] = 0;
        }

        for (int i=0;i<myArray.length;i++){
            System.out.println(myArray[i]);
            countArray[myArray[i]]++;
        }
        int myOrder = 0;
        for (int i=0;i<countArray.length;i++){
            if(i==myScore){
                break;
            }
            myOrder += countArray[i];
        }
        System.out.println(myArray.length);
        System.out.println("我的排名:"+myOrder);
    }
}
