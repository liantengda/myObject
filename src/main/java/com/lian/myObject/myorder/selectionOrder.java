package com.lian.myObject.myorder;

/**
 * 选择排序
 * 最简单，最没用
 * @author Ted
 * @version 1.0
 * @date 2020/7/15 23:26
 */
public class selectionOrder {

    private Integer[] orderArray;

    public selectionOrder(Integer[] orderArray){
        this.orderArray = orderArray;
    }

    public void selectOrder(){
        for(int i=0;i<orderArray.length;i++){
            int min = orderArray[i];
            int k =i;
            for(int j=i;j<orderArray.length;j++){
                if(min>orderArray[j]){
                    min = orderArray[j];
                    k = j;
                }
            }
            orderArray[k] = orderArray[i];
            orderArray[i] = min;
        }
    }

    public static void main(String[] args) {
        selectionOrder selectionOrder = new selectionOrder( new Integer[]{9,2,3,5,1,6,8,7,0,100,43,23,97,65,57,84,30});
        selectionOrder.selectOrder();
        for (Integer integer : selectionOrder.orderArray) {
            System.out.print(integer + " ");
        }
    }

}
