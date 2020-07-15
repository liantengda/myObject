package com.lian.myObject.myorder;

/**
 * 归并排序
 * 真是难
 *
 * 首先每次排序都需要传入排序数组，每次合并完成都需要赋值给排序数组。这样便可以更新数组。更新成排序完成的样子。
 *
 *
 * @author Ted
 * @version 1.0
 * @date 2020/7/14 21:15
 */
public class RecurOrder {
    //原数组
    private Integer[] orderArray;


    public RecurOrder(Integer[] orderArray){
        this.orderArray = orderArray;
    }


    public void recurOrder(Integer leftPor, Integer rightPor){

        if(leftPor>=rightPor){
            return ;
        }
        int mid = leftPor+ ((rightPor-leftPor)>>1);
        System.out.println("中间位:"+mid);
        // 左半边排序
        recurOrder(leftPor,mid);
        //右半边排序
        recurOrder(mid+1,rightPor);
        merge(leftPor,rightPor,mid);
    }

    /**
     * 对某排好顺序的两个数组进行合并
     * @param leftPor 左边界
     * @param rightPor 右边界
     * @param mid 分隔点
     * @return
     */
    public void merge(Integer leftPor, Integer rightPor,Integer mid){
        Integer[] totalArray = new Integer[rightPor-leftPor+1];
        int p1=leftPor,p2=mid+1,index =0;

        while (p2<=rightPor&&p1<=mid) {
            if (orderArray[p1] < orderArray[p2]) {
                totalArray[index] = orderArray[p1];
                p1++;
                index++;
            } else {
                totalArray[index] = orderArray[p2];
                p2++;
                index++;
            }
        }
        while (p2<=rightPor){
            totalArray[index] = orderArray[p2];
            p2++;
            index++;
        }
        while (p1<=mid){
            totalArray[index] = orderArray[p1];
            p1++;
            index++;
        }

        for (int j =0;j<totalArray.length;j++){
            orderArray[j+leftPor]=totalArray[j];
        }
    }


    public static void main(String[] args) {
        RecurOrder recurOrder = new RecurOrder(new Integer[]{38,27,43,3,9,82,10,11,12,101});
        recurOrder.recurOrder(0, recurOrder.orderArray.length-1);
        System.out.println("-----------------------");
        for (Integer integer : recurOrder.orderArray) {
            System.out.print(integer+" ");
        }

    }
}
