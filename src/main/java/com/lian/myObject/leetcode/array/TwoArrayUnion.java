package com.lian.myObject.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数组交集
 * @author Ted
 * @version 1.0
 * @date 2021/10/14 14:42
 */
public class TwoArrayUnion {


    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,2,1};
        int[] arr2 = new int[]{1,2,1};

        int[] union = arrayUnion(arr1, arr2);

        for (int i : union) {
            System.out.println(i);
        }
    }


    public static int[] arrayUnion(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return arrayUnion(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
