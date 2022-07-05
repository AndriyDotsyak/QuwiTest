package com.quwi.apptest.network.api;

import com.quwi.apptest.data.model.authenticate.AuthResponse;
import com.quwi.apptest.data.model.authenticate.Credentials;
import com.quwi.apptest.data.model.authenticate.Registration;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticateApi {

    @POST("auth/login")
    Flowable<AuthResponse> login(@Body Credentials body);

    @POST("auth/signup")
    Flowable<AuthResponse> signup(@Body Registration body);

}
