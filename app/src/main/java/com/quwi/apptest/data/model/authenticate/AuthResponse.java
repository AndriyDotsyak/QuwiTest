package com.quwi.apptest.data.model.authenticate;

import com.google.gson.annotations.SerializedName;

public class AuthResponse {

    @SerializedName("token")
    public String token = "";

    @SerializedName("app_init")
    public AppInit data;

    @SerializedName("already_join_project")
    public String alreadyJoinProject = null;

}
