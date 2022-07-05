package com.quwi.apptest.data.model.chat;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Objects;

public class Channel {

    @SerializedName("id")
    public int id;

    @SerializedName("type")
    public String type;

    @SerializedName("dta_create")
    public String dataCreate;

    @SerializedName("id_project")
    public Object idProject;

    @SerializedName("id_partner")
    public int idPartner;

    @SerializedName("dta_last_read")
    public String dataLastRead;

    @SerializedName("is_unread_manual")
    public boolean isUnreadManual;

    @SerializedName("dta_change_msg")
    public String dataChangeMsg;

    @SerializedName("message_last")
    public Message messageLast = new Message();

    @SerializedName("id_users")
    public ArrayList<Integer> idUsers;

    @SerializedName("is_starred")
    public boolean isStarred;

    @SerializedName("is_mute")
    public boolean isMute;

    @SerializedName("mute_until_period")
    public int muteUntilPeriod;

    @SerializedName("is_hide_in_chats_list")
    public boolean isHideInChatsList;

    @SerializedName("dta_pin")
    public Object dataPin;

    @SerializedName("pin_to_top")
    public boolean pinToTop;

    @SerializedName("custom_info")
    public Object customInfo;

    @SerializedName("draft")
    public Draft draft;

    public String requireAvatarUrl() {
        String url = "";
        if (Objects.nonNull(messageLast) && Objects.nonNull(messageLast.user)) {
            url = messageLast.user.avatarUrl;
        }
        return url;
    }

    public String requireName() {
        String name = "";
        if (Objects.nonNull(messageLast) && Objects.nonNull(messageLast.user)) {
            name = messageLast.user.name;
        }
        return name;
    }

    public String requireLastMessageSnippet() {
        String snippet = "";
        if (Objects.nonNull(messageLast)) {
            snippet = messageLast.snippet;
        }
        return snippet;
    }

    public String requireLastMessageDate() {
        String snippet = "";
        if (Objects.nonNull(messageLast)) {
            snippet = messageLast.dataCreate;
        }
        return snippet;
    }

    public boolean requireLastMessageRead() {
        boolean snippet = false;
        if (Objects.nonNull(messageLast)) {
            snippet = messageLast.isRead();
        }
        return snippet;
    }
}