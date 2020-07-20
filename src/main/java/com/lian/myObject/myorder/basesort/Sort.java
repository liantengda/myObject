package com.lian.myObject.myorder.basesort;

/**
 *
 * 排序算法
 * @author Ted
 * @version 1.0
 * @date 2020/7/18 13:51
 */
public interface Sort<T> {

    /**
     * 对某数组进行排序
     * @param arr 待排序数组
     * @param sortType 排序类型 asc 为从小到大 desc为从大到小
     */
    T sort(T arr,String sortType);

}
