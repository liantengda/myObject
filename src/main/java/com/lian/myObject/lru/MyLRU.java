package com.lian.myObject.lru;

import org.omg.CORBA.OBJECT_NOT_EXIST;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 实现LRU算法
 *
 * 最近使用的数据全部放到内存尾部
 * 内存头部永远为最不常用数据。
 * 当内存即将撑爆，将不常用数据移除内存，将新数据插入队尾。
 *
 * @author Ted
 * @date 2020/7/14 10:53
 */
public class MyLRU<K,V> {
    //头节点
    private MemoryNode<K,V> head;
    //尾部节点
    private MemoryNode<K,V> tail;
    //内存hash表
    private Map<K,MemoryNode> memoryMap = new HashMap<>();

    //内存空间
    private Integer memorySize;


    public MyLRU(Integer memorySize){
        this.memorySize = memorySize;
    }

    /**
     * 从内存中获取数据，如果不存在则需要从磁盘加载进内存中
     * 如果存在，则把该数据节点放到链表尾部
     */
    public V get(K key){
        MemoryNode memoryNode = memoryMap.get(key);
        if(memoryNode!=null){

            MemoryNode prev = memoryNode.prev;
            MemoryNode next = memoryNode.next;

            //前后节点连接
            prev.next = next;
            next.prev = prev;

            //插入尾部
            tail.next = memoryNode;
            memoryNode.prev = tail;
            memoryNode.next = null;
            tail = memoryNode;
        }
        return (V) memoryNode.value;
    }

    /**
     * 将数据加载到内存中
     * 同时将节点存入hash表中
     *
     * @param key
     * @param value
     */
    public void load(K key,V value){
        //如果内存已经撑爆，则把头部节点移除
        if(memoryMap.size()>=memorySize){
            K removeKey = head.key;
            V removeValue = head.value;
            MemoryNode<K,V> newHead = head.next;
            newHead.prev = null;
            head.next =null;
            head = newHead;
            memoryMap.remove(removeKey);
            System.out.println("移除头部节点-->key:"+removeKey+"-->value:"+removeValue);
        }

        if(head == null){
            MemoryNode<K,V> newNode = new MemoryNode(null, null, key,value);
            head = newNode;
            tail = newNode;
            memoryMap.put(key,newNode);
        }else {
            MemoryNode<K,V> newNode = new MemoryNode(tail, null,key, value);
            tail.next = newNode;
            tail = newNode;
            memoryMap.put(key,newNode);
        }
    }

    /**
     * 内存数据存储节点
     * @param <K>
     * @param <V>
     */
    private static class MemoryNode<K,V>{
        MemoryNode<K,V> prev;
        MemoryNode<K,V> next;
        K key;
        V value;

        MemoryNode(MemoryNode<K,V> prev,MemoryNode<K,V> next,K key,V value){
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }

    }

    @Override
    public String toString() {
        MemoryNode temp = head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (temp!=null){
            stringBuilder.append(temp.key+":"+temp.value+"  ");

            temp =temp.next;
        }
        stringBuilder.append("]");

        new Hashtable<String,Object>();

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyLRU<Integer,String> memory = new MyLRU<>(8);
        for (int i=0;i<10;i++){
            memory.load(i,"哈哈哈哈"+i);
        }
        System.out.println("1100");
        String s = memory.get(5);
        System.out.println(s);
        memory.load(1001,"喵喵喵");
        String s1 = memory.get(5);
        System.out.println(s1);
    }
}
