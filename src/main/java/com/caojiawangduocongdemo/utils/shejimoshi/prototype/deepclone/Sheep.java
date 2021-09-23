package com.caojiawangduocongdemo.utils.shejimoshi.prototype.deepclone;

import java.io.*;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.prototype.deepclone
 * @ClassName:Sheep
 * @Description: 对象的深拷贝
 * @Author:caojia
 * @Date:2021/7/2622:47
 */
public class Sheep implements Serializable,Cloneable {


    private static final long serialVersionUID = -5243468778442266614L;
    private String name;
    private Integer age;
    private Dog friend;

    public Sheep(String name, Integer age, Dog friend) {
        this.name = name;
        this.age = age;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dog getFriend() {
        return friend;
    }

    public void setFriend(Dog friend) {
        this.friend = friend;
    }

    //Object的clone方法默认为浅拷贝，即基本数据类型和String类型进行值的拷贝，引用类型是引用的拷贝，即指向同一块内存地址
    //实现深拷贝的方式有两种，1、重写clone方法；2、利用对象的序列化和反序列化进行对象的深拷贝

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep = null;
        sheep = (Sheep) super.clone();
        sheep.friend = (Dog) sheep.getFriend().clone();
        return sheep;
    }

    /**
     * 实现对象深拷贝的方法
     * @return
     */
    public Object deepClone(){
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Sheep sheep = (Sheep) ois.readObject();
            return sheep;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
