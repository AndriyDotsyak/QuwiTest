package com.quwi.apptest.data.model.authenticate;

import com.google.gson.annotations.SerializedName;

public class UserSettings {

    @SerializedName("lang")
    public String lang;

    @SerializedName("mute_until_period")
    public int muteUntilPeriod;

    @SerializedName("is_mute_chats")
    public boolean isMuteChats;

    @SerializedName("dta_mute_until")
    public String dataMuteUntil;

    @SerializedName("client_settings")
    public Object clientSettings;

    @SerializedName("cache_updated")
    public boolean cacheUpdated;

}
