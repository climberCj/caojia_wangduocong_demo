package com.caojiawangduocongdemo.utils.io.io2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.io.io2
 * @ClassName:Client
 * @Description:
 * @Author:caojia
 * @Date:2021/8/523:59
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.print("请说：");
                String msg = scanner.nextLine();
                PrintStream ps = new PrintStream(socket.getOutputStream());
                ps.println(msg);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
