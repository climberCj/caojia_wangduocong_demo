package com.caojiawangduocongdemo.utils.shejimoshi.iterator.v3;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.iterator
 * @ClassName:LinkedList_
 * @Description:底层为链表的容器
 * @Author:caojia
 * @Date:2021/6/2922:37
 */
public class LinkedList_ implements Collection_ {
    //头结点
    private Node head;
    //尾节点
    private Node tail;
    //定义计数
    private int size;

    @Override
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
    @Override
    public int size(){
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator_{

        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index >= size)
                return false;
            return true;
        }

        @Override
        public Object next() {
            Node n = head;
            head = head.next;
            index++;
            return n.o;
        }
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
}
