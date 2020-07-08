package com.lian.myObject.slideWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * 滑动窗口获取最大值
 *
 * 窗口向右滑动，每次获取的值与双端队列中的尾部比较，比自己小的都扔掉
 * 窗口左侧，每次丢失的值与双端队列中的首部比较，如果相等，则丢弃。
 *
 * 每时每刻双端队列队首的值就是当前窗口的最大值
 * @author Ted
 * @version 1.0
 * @date 2020/7/8 21:19
 */
public class SlideWindow {
    private Integer[] array;

    private LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque();

    private ArrayList<Integer> maxList = new ArrayList<>();

    private  Integer left = 0;
    private  Integer right ;
    private Integer weight;

    public SlideWindow(Integer[] array,Integer weight){
        this.right = weight-1;
        this.weight = weight;
        this.array = array;
    }

    public void initialDeque(){
        for (int i=0;i<right;i++){
            if(deque.size()>0){
                while (deque.size()>0&&array[i]>=deque.getLast()){
                    deque.pollLast();
                }
            }
            deque.addLast(array[i]);
        }
    }


    public Integer slide(){

        if(deque.size()>0){
            while (deque.size()>0&&array[right]>=deque.getLast()){
                deque.pollLast();
            }
        }
        deque.addLast(array[right]);

        if(deque.getFirst()!=null&&left>=1&&array[left-1]==deque.getFirst()){
            deque.pollFirst();
        }

        this.right++;
        this.left++;

        return deque.getFirst();
    }

    public List<Integer> addWindowMax(Integer e){
        maxList.add(e);
        return maxList;
    }

    public static void main(String[] args) {
        SlideWindow slideWindow = new SlideWindow(new Integer[]{1, 2, 3, 4, 5,9,6,7}, 4);
        slideWindow.initialDeque();
        while (slideWindow.right<=slideWindow.array.length-1){
            Integer slide = slideWindow.slide();
            slideWindow.addWindowMax(slide);
        }
        System.out.println(slideWindow.maxList);
    }

}
