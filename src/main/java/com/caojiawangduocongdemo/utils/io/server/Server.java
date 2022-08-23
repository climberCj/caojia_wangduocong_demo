package com.caojiawangduocongdemo.utils.io.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.io.server
 * @ClassName:Server
 * @Description:服务端
 * @Author:caojia
 * @Date:2021/8/522:59
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            //阻塞方法
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg = null;
            if((msg = br.readLine()) != null){
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
