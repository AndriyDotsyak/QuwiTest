package com.quwi.apptest.di;

import static com.quwi.apptest.utils.NetworkUtil.buildRetrofit;

import android.content.Context;

import com.quwi.apptest.BuildConfig;
import com.quwi.apptest.manager.AccountManager;
import com.quwi.apptest.network.api.AuthenticateApi;
import com.quwi.apptest.network.api.ChatApi;
import com.quwi.apptest.network.interceptor.AuthenticationInterceptor;
import com.quwi.apptest.utils.NetworkUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    AuthenticateApi provideAuthenticateApi(OkHttpClient httpClient) {
        return buildRetrofit(BuildConfig.ENDPOINT, httpClient)
                .create(AuthenticateApi.class);
    }

    @Provides
    ChatApi provideChatApi(OkHttpClient httpClient) {
        return buildRetrofit(BuildConfig.ENDPOINT, httpClient)
                .create(ChatApi.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(
            @ApplicationContext Context context,
            AccountManager accountManager
    ) {
        return NetworkUtil.getOkHttpBuilder()
                .addInterceptor(new AuthenticationInterceptor(context, accountManager))
                .build();
    }

}
