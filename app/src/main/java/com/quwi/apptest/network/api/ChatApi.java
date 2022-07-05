package com.quwi.apptest.network.api;

import com.quwi.apptest.data.model.chat.ChatResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ChatApi {

    @GET("chat-channels")
    Flowable<ChatResponse> getChat();

}
