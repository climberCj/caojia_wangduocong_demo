package com.caojiawangduocongdemo.utils.shejimoshi.iterator.v1;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.iterator
 * @ClassName:ArrayList_
 * @Description: 自定义了一个可以动态扩展的容器
 * @Author:caojia
 * @Date:2021/6/2922:26
 */
public class ArrayList_ {
    //定义一个长度为10的数组
    Object[] objects = new Object[10];
    //定义一个记录容器中元素的变量
    int index = 0;
    //添加元素的方法
    public void add(Object o){
        //初始数组已经满了
        if(index == objects.length){
            //新建一个长度为原来数组两倍的数组
            Object[] newObjects = new Object[objects.length * 2];
            //数组的拷贝 将旧数组中的元素拷贝到新数组中
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index ++;
    }

    //获取容器中元素的个数
    public int size(){
        return index;
    }

    public static void main(String[] args) {
        ArrayList_ arrayList_ = new ArrayList_();
        for(int i = 0 ; i < 15 ; i ++){
            arrayList_.add(i+"s");
        }
        System.out.println("数组中的元素个数："+arrayList_.size());
    }
}
