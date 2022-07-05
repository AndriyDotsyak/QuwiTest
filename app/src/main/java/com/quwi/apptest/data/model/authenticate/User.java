package com.quwi.apptest.data.model.authenticate;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User {

    @SerializedName("id")
    public int id = 0;

    @SerializedName("name")
    public String name = "";

    @SerializedName("nick")
    public String nick = "";

    @SerializedName("avatar_url")
    public String avatarUrl = "";

    @SerializedName("dta_create")
    public String dataCreate = "";

    @SerializedName("timezone_offset")
    public int timezoneOffset = 0;

    @SerializedName("is_online")
    public int isOnline;

    @SerializedName("is_chat_email_notification")
    public boolean isChatEmailNotification;

    @SerializedName("dta_activity")
    public String dataActivity;

    @SerializedName("is_active")
    public boolean isActive;

    @SerializedName("id_company")
    public int idCompany;

    @SerializedName("role")
    public String role;

    @SerializedName("due_penalties")
    public int duePenalties;

    @SerializedName("is_timer_online")
    public int isTimerOnline;

    @SerializedName("dta_timer_activity")
    public String dataTimerActivity;

    @SerializedName("timer_last")
    public Object timerLast;

    @SerializedName("is_shared_from_me")
    public boolean isSharedFromMe;

    @SerializedName("projects")
    public ArrayList<Object> projects;

    @SerializedName("email")
    public String email;

    @SerializedName("is_telegram_connected")
    public boolean isTelegramConnected;

    @SerializedName("telegram_connect_url")
    public String telegramConnectUrl;

}
