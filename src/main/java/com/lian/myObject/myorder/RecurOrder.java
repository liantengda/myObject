package com.lian.myObject.myorder;

/**
 * 归并排序
 *
 * @author Ted
 * @version 1.0
 * @date 2020/7/14 21:15
 */
public class RecurOrder {

    private Integer[] orderArray;

    public RecurOrder(Integer[] orderArray){
        this.orderArray = orderArray;
    }


    public Integer[] recurOrder(Integer leftPor,Integer rightPor,Integer splitPos){
        if(leftPor == splitPos){
            System.out.println(splitPos);
            return merge(leftPor,rightPor,splitPos);
        }
        // 左半边排序
        recurOrder(leftPor,splitPos,(splitPos+leftPor)/2);
        //右半边排序
        recurOrder(splitPos,rightPor,(splitPos+rightPor)/2);

        return null;
    }

    /**
     * 对某排好顺序的两个数组进行合并
     * @param leftPor 左边界
     * @param rightPor 右边界
     * @param splitPos 分隔点
     * @return
     */
    public Integer[] merge(Integer leftPor, Integer rightPor,Integer splitPos){
        Integer[] totalArray = new Integer[rightPor-leftPor+1];
        int i=leftPor,k=splitPos,index =0;
        while (index<=totalArray.length-1){
            if(k<=rightPor&&i<splitPos){
                if(orderArray[i]<orderArray[k]){
                    totalArray[index] = orderArray[i];
                    i++;
                    index++;
                }else if(orderArray[k]<orderArray[i]) {
                    totalArray[index] = orderArray[k];
                    k++;
                    index++;
                }
            }else if(i>=splitPos){
                while (k<=rightPor){
                    totalArray[index] = orderArray[k];
                    k++;
                    index++;
                }
            }else if(k>rightPor){
                while (i<=splitPos-1){
                    totalArray[index] = orderArray[i];
                    i++;
                    index++;
                }
            }
            System.out.println(index);
        }
        return totalArray;
    }


    public static void main(String[] args) {
        RecurOrder recurOrder = new RecurOrder(new Integer[]{3,6,8,9,13,10,11,17,23,56});
        recurOrder.recurOrder(0, recurOrder.orderArray.length - 1, 5);

    }
}
