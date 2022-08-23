package com.caojiawangduocongdemo.utils.io.io2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.io.io2
 * @ClassName:Server
 * @Description:模拟多客户端请求服务端，服务端进行消息接收
 * @Author:caojia
 * @Date:2021/8/523:52
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            while(true){
                Socket socket = ss.accept();
                new ServerThreadReader(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
