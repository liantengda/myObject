package com.lian.myObject.myorder;

/**
 * 希尔排序
 *
 * 将数组按照某个间距大小分组，每隔一个间距分到一组。
 *
 * 对每个分组进行插入排序
 * @author Ted
 * @date 2020/7/13 13:29
 */
public class ShellOrder {

    private Integer[] orderArray;
    private Integer[] iteratorArray;
    private Integer groupFactor;

    public ShellOrder(Integer[] orderArray,Integer groupFactor){
        this.orderArray = orderArray;
        this.groupFactor = groupFactor;
        this.iteratorArray = orderArray;
        for (Integer integer : orderArray) {
            System.out.print(integer+" ");
        }
        System.out.println();
    }

    public Integer[] order(){
        Integer[] orderedArray = new Integer[iteratorArray.length];
        Integer i;
        for ( i=groupFactor;i>=1;i = i/2){
            Integer[] integers = new Integer[iteratorArray.length];
            for (int j=0;j<orderedArray.length/(orderedArray.length/i);j++){
                integers = insertOrder(orderedArray, i, j);
            }
            iteratorArray = integers;
        }
        return orderedArray;
    }

    /**
     * 插入排序
     * @return
     */
    public Integer[] insertOrder(Integer[] orderedArray, int gap, int j){
        if(iteratorArray==null){
            return null;
        }
        int i,k;
        String gapStr = "-";
        for (int l=0;l<gap-1;l++){
            gapStr += gapStr;
        }

        for (i=j;i<orderedArray.length;i+=gap){
            System.out.print(iteratorArray[i]+gapStr);
            for (k = i;k>j;k-=gap){
                if(orderedArray[k-gap]>iteratorArray[i]){
                    orderedArray[k] = orderedArray[k-gap];
                }else {
                    break;
                }
            }
            orderedArray[k] = iteratorArray[i];
        }
        System.out.println();
        for (Integer integer : orderedArray) {
            System.out.print(integer+" ");
        }
        System.out.println();
        return orderedArray;
    }


    public static void main(String[] args) {
        ShellOrder shellOrder = new ShellOrder(new Integer[]{8, 2, 1, 3, 5, 6, 7, 4}, 4);

        Integer[] order = shellOrder.order();
        for (Integer integer : order) {
            System.out.print(" "+integer);
        }
    }
}
