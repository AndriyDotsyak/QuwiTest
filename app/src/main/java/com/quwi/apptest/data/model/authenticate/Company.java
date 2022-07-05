package com.quwi.apptest.data.model.authenticate;

import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("id")
    public int id;

    @SerializedName("uid")
    public String uid;

    @SerializedName("name")
    public String name;

    @SerializedName("logo_url")
    public String logoUrl;

    @SerializedName("owner_fullname")
    public String ownerFullName;

    @SerializedName("dta_create")
    public String dataCreate;

    @SerializedName("id_user")
    public int idUser;

    @SerializedName("timezone")
    public String timezone;

    @SerializedName("timezone_offset")
    public int timezoneOffset;

    @SerializedName("screens_interval")
    public int screensInterval;

    @SerializedName("screens_quality")
    public int screensQuality;

    @SerializedName("updated")
    public int updated;

    @SerializedName("max_file_count")
    public int maxFileCount;

    @SerializedName("max_file_size")
    public int maxFileSize;

    @SerializedName("is_plan_almost_used")
    public boolean isPlanAlmostUsed;

    @SerializedName("isMy")
    public boolean isMy;

}
