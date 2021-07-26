package com.caojiawangduocongdemo.utils.shejimoshi.iterator.v4;


/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.iterator
 * @ClassName:ArrayList_
 * @Description: 可以动态扩展的容器
 * @Author:caojia
 * @Date:2021/6/2922:26
 */
public class ArrayList_<E> implements Collection_<E> {
    //定义一个长度为10的数组
    E[] objects = (E[])new Object[10];
    //定义一个记录容器中元素的变量
    int size = 0;
    //添加元素的方法
    @Override
    public void add(E o){
        //初始数组已经满了
        if(size == objects.length){
            //新建一个长度为原来数组两倍的数组
            E[] newObjects = (E[])new Object[objects.length * 2];
            //数组的拷贝 将旧数组中的元素拷贝到新数组中
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects = newObjects;
        }
        objects[size] = o;
        size ++;
    }

    //获取容器中元素的个数
    @Override
    public int size(){
        return size;
    }

    @Override
    public Iterator_<E> iterator() {
        return new ArrayListIterator<E>();
    }

    private class ArrayListIterator<E> implements Iterator_<E> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index >= size)
                return false;
            return true;
        }

        @Override
        public E next() {
            E o = (E) objects[index];
            index ++;
            return o;
        }
    }

    /*public static void main(String[] args) {
        ArrayList_ arrayList_ = new ArrayList_();
        for(int i = 0 ; i < 15 ; i ++){
            arrayList_.add(i+"s");
        }
        System.out.println("容器中的元素个数："+arrayList_.size());
    }*/
}
