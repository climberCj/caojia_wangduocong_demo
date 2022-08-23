package com.caojiawangduocongdemo.utils.io.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.io.client
 * @ClassName:Client
 * @Description:传统模式下同步阻塞式io客户端，请求服务端时，每一个连接请求，服务端都会创建一个线程来应对
 * @Author:caojia
 * @Date:2021/8/523:04
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println("服务端您好");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
