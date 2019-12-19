package com.caojiawangduocongdemo.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
    public static SimpleHash getHashPass(String hashAlgorithName,String password,int hashIterations){
        ByteSource credentialsSalt = ByteSource.Util.bytes("heis");
        SimpleHash obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        return obj;
    }
    public static void main(String[] args){
        System.out.println(getHashPass("MD5","123456",1024));
    }
}
