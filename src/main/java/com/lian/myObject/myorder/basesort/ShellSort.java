package com.lian.myObject.myorder.basesort;

/**
 * 希尔排序
 *
 * 将数组按照某个间距大小分组，每隔一个间距分到一组。
 *
 * 对每个分组进行插入排序
 * @author Ted
 * @date 2020/7/13 13:29
 */
public class ShellSort implements Sort{

    private Integer groupFactor;

    public ShellSort(Integer groupFactor){
        this.groupFactor = groupFactor;
    }

    @Override
    public int[] sort(int[] arr, String sortType) {
        System.out.println("-----------希尔排序----------");
        Integer i;
        for ( i=groupFactor;i>=1;i = i/2){
            int[] orderedArray = new int[arr.length];
            int groupNum;
            int loop;
            if(orderedArray.length%i==0){
                groupNum = orderedArray.length/i>0?orderedArray.length/i:1;
                loop = orderedArray.length/groupNum;
            }else {
                groupNum = orderedArray.length/i>0?(orderedArray.length/i)+1:1;
                loop = orderedArray.length/groupNum+1;
            }
            for (int j=0;j<loop;j++){
                if(sortType.toLowerCase().equals("asc")){
                    insertAsc(orderedArray, i, j,arr);
                }else if(sortType.toLowerCase().equals("desc")){
                    insertDesc(orderedArray,i,j,arr);
                }
            }
            //每完成一波排序，变换一次arr。
            arr = orderedArray;
        }
        return arr;
    }


    /**
     * 插入排序 -- 正序
     * @return
     */
    public int[] insertAsc(int[] orderedArray, int gap, int j,int[] arr){
        if(arr==null){
            return null;
        }
        int i,k;
        String gapStr = "-";
        for (int l=0;l<gap-1;l++){
            gapStr += gapStr;
        }

        for (i=j;i<orderedArray.length;i+=gap){
            System.out.print(arr[i]+gapStr);
            for (k = i;k>j;k-=gap){
                if(orderedArray[k-gap]>arr[i]){
                    orderedArray[k] = orderedArray[k-gap];
                }else {
                    break;
                }
            }
            orderedArray[k] = arr[i];
        }
        System.out.println();
        for (Integer integer : orderedArray) {
            System.out.print(integer+" ");
        }
        System.out.println();
        return orderedArray;
    }

    /**
     * 插入排序 -- 逆序
     * @return
     */
    public int[] insertDesc(int[] orderedArray, int gap, int j,int[] arr){
        if(arr==null){
            return null;
        }
        int i,k;
        String gapStr = "-";
        for (int l=0;l<gap-1;l++){
            gapStr += gapStr;
        }
        for (i=j;i<orderedArray.length-1;i+=gap){
            System.out.print(arr[i]+gapStr);
            for (k = i;k>j;k-=gap){
                if(orderedArray[k-gap]<arr[i]){
                    orderedArray[k] = orderedArray[k-gap];
                }else {
                    break;
                }
            }
            orderedArray[k] = arr[i];
        }
        System.out.println();
        for (Integer integer : orderedArray) {
            System.out.print(integer+" ");
        }
        System.out.println();
        return orderedArray;
    }


    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort( 4);
//        int[] arr = {16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int[] arr = {5,4,3,2,1};
        int[] order = shellSort.sort(arr,"asc");
        for (Integer integer : order) {
            System.out.print(" "+integer);
        }
    }


}
