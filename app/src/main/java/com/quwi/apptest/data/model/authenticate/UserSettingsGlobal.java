package com.quwi.apptest.data.model.authenticate;

import com.google.gson.annotations.SerializedName;

public class UserSettingsGlobal {

    @SerializedName("client_settings")
    public Object clientSettings;

    @SerializedName("is_chat_email_notification")
    public boolean isChatEmailNotification;

}
