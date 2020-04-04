package com.caojiawangduocongdemo.utils;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author caojia
 * @time 下午 9:27
 */
public class TimeUtil {
    public static String getCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(now);
    }
    public static void main(String[] args){
        System.out.println(getCurrentTime());
    }

}
