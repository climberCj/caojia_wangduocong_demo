package com.caojiawangduocongdemo.utils.sort;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.sort
 * @ClassName:SelectionTest
 * @Description: 选择排序算法：假设第一个元素为最小的数
 * @Author:caojia
 * @Date:2021/6/1122:30
 */
public class SelectionTest {
    public static void main(String[] args) {
        int[] arr = {3,5,8,2,9,1,4,7,6};
        for(int i = 0;i < arr.length;i ++){
            //假定最小数值的索引
            int minPos = i;
            for(int j = i + 1; j < arr.length;j ++){
                if(arr[minPos] > arr[j] ){
                    minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }

        for (int a:arr) {
            System.out.print(a + " ");
        }
    }
}
