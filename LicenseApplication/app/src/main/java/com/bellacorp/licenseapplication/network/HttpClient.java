package com.bellacorp.licenseapplication.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpClient {
    public OkHttpClient client;

    public HttpClient() {
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder().addInterceptor(chain -> {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Connection", "close")
                        .addHeader("Content-Type", "application/xml;charset=UTF-8").build();
                return chain.proceed(request);
            })
        .connectTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(logger)
        .build();

    }
}
