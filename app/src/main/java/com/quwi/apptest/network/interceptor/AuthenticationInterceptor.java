package com.quwi.apptest.network.interceptor;

import android.content.Context;

import androidx.annotation.NonNull;

import com.quwi.apptest.manager.AccountManager;
import com.quwi.apptest.screen.authenticate.AuthenticateActivity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private final AccountManager accountManager;
    private final Context context;

    public AuthenticationInterceptor(Context context, AccountManager accountManager) {
        this.context = context;
        this.accountManager = accountManager;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = getRequest(chain);
        Response response = chain.proceed(request);

        if (response.code() == CODE_UNAUTHORIZED) {
            accountManager.clear();
            AuthenticateActivity.start(context);
        }

        return response;
    }

    private Request getRequest(Interceptor.Chain chain) {
        String token = accountManager.getBearerToken();
        Request.Builder requestBuilder = chain.request().newBuilder();
        if (!token.isEmpty()) {
            requestBuilder.addHeader(HEADER_AUTHORIZATION, token);
        }
        return requestBuilder.build();
    }

    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final int CODE_UNAUTHORIZED = 401;

}
