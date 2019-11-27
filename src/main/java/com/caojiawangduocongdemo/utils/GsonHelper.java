package com.caojiawangduocongdemo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;

/**
 * Gson helper.
 *
 * @author Yang XuePing
 */
public class GsonHelper {
    public static final MediaType GSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    public static final Gson DEFAULT_GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create();
}
