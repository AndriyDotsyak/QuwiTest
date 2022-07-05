package com.quwi.apptest.utils;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtil {

    private static final long READ_TIMEOUT = 30L;
    private static final long WRITE_TIMEOUT = 30L;
    private static final long CONNECT_TIMEOUT = 30L;
    private static final long PING_TIMEOUT = 30L;

    public static Retrofit buildRetrofit(String url, OkHttpClient httpClient) {
        return new  Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(createGsonConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static OkHttpClient.Builder getOkHttpBuilder() {
        return new  OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.MINUTES)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .pingInterval(PING_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(getLoggingInterceptor());
    }

    private static GsonConverterFactory createGsonConverterFactory() {
        return GsonConverterFactory.create(new GsonBuilder().create());
    }

    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        return loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

}
