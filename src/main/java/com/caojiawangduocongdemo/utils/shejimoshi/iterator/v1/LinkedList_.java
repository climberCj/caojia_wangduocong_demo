package com.caojiawangduocongdemo.utils.shejimoshi.iterator.v1;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.iterator
 * @ClassName:LinkedList_
 * @Description:自定义一个底层为链表的容器
 * @Author:caojia
 * @Date:2021/6/2922:37
 */
public class LinkedList_ {
    //头结点
    private Node head;
    //尾节点
    private Node tail;
    //定义计数
    private int size;

    public void add(Object o){
        //创建节点对象
        Node n = new Node(o);
        //添加到结尾
        n.next = null;

        if(head == null){
            head = n;
            tail = n;
        }

        tail.next = n;
        tail = n;
        size ++;
    }

    //容器中元素的个数
    public int size(){
        return size;
    }
    //内部类 定义节点对象
    private class Node{
        //节点中的数据
        private Object o;
        //指向下一个节点的指针
        private Node next;

        public Node(Object o){
            this.o = o;
        }
    }

    public static void main(String[] args) {
        LinkedList_ list_ = new LinkedList_();
        for(int i = 0 ; i < 15 ; i ++){
            list_.add(i+"s");
        }
        System.out.println("链表中元素的个数为："+list_.size());
    }
}
