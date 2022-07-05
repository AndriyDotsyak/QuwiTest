package com.quwi.apptest.data.model.authenticate;

import com.google.gson.annotations.SerializedName;

public class AuthItems {

    @SerializedName("owner")
    public boolean owner;

    @SerializedName("coder")
    public boolean coder;

    @SerializedName("can_edit_time")
    public boolean canEditTime;

    @SerializedName("disc_space")
    public boolean discSpace;

    @SerializedName("tracked_timer_month")
    public boolean trackedTimerMonth;

    @SerializedName("screens_month")
    public boolean screensMonth;

    @SerializedName("chat")
    public boolean chat;

    @SerializedName("instant_screen")
    public boolean instantScreen;

    @SerializedName("timelapse_video")
    public boolean timelapseVideo;

    @SerializedName("member_area")
    public boolean memberArea;

    @SerializedName("trial")
    public boolean trial;

}
