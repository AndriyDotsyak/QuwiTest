package com.quwi.apptest.data.model.chat;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ChatResponse {

    @SerializedName("channels")
    public ArrayList<Channel> channels;

}
