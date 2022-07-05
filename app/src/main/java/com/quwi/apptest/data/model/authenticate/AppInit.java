package com.quwi.apptest.data.model.authenticate;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AppInit {

    @SerializedName("user")
    public User user;

    @SerializedName("user_settings_global")
    public UserSettingsGlobal userSettingsGlobal;

    @SerializedName("user_settings")
    public UserSettings userSettings;

    @SerializedName("companies")
    public ArrayList<Company> companies;

    @SerializedName("auth_items")
    public AuthItems authItems;

    @SerializedName("chats_count_unread")
    public int chatsCountUnread;

    @SerializedName("hidden_projects")
    public ArrayList<String> hidden_projects;

}
