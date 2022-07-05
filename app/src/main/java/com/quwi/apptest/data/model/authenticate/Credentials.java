package com.quwi.apptest.data.model.authenticate;

import com.google.gson.annotations.SerializedName;

public class Credentials {

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
