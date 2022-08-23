package com.caojiawangduocongdemo.utils.io.io2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.io.io2
 * @ClassName:ServerThreadReader
 * @Description:线程类，用来处理不同的客户端连接
 * @Author:caojia
 * @Date:2021/8/523:55
 */
public class ServerThreadReader extends Thread{
    private Socket socket;

    public ServerThreadReader(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while((msg = br.readLine()) != null){
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
