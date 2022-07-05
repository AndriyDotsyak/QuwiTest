package com.quwi.apptest.data.model.authenticate;

import com.google.gson.annotations.SerializedName;

public class Registration {

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    public Registration(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
