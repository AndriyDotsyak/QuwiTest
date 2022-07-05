package com.quwi.apptest.data.model.chat;

import com.google.gson.annotations.SerializedName;
import com.quwi.apptest.data.model.authenticate.User;

public class Message {

    @SerializedName("id")
    public int id;

    @SerializedName("id_user")
    public int idUser;

    @SerializedName("user")
    public User user = new User();

    @SerializedName("id_channel")
    public int idChannel;

    @SerializedName("dta_create")
    public String dataCreate;

    @SerializedName("is_read")
    public int read;

    @SerializedName("is_starred")
    public boolean isStarred;

    @SerializedName("is_edited")
    public boolean isEdited;

    @SerializedName("text")
    public String text;

    @SerializedName("snippet")
    public String snippet;

    @SerializedName("replyOn")
    public Object reply_on;

    @SerializedName("file")
    public Object file;

    public boolean isRead() {
        return read == 1;
    }
}
