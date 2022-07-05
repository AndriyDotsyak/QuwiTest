package com.quwi.apptest.manager;

import android.content.Context;

import com.quwi.apptest.base.manager.BasePreferencesManager;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class AccountManager extends BasePreferencesManager {

    private static final String PREFERENCES_NAME = "PREFERENCES_ACCOUNT";
    private static final String KEY_TOKEN = "KEY_TOKEN";

    @Inject
    public AccountManager(@ApplicationContext Context context) {
        super(context);
    }

    public void putToken(String token) {
        putString(KEY_TOKEN, token);
    }

    public String getToken() {
        return getString(KEY_TOKEN);
    }

    public String getBearerToken() {
        return "Bearer " + getToken();
    }

    public boolean hasToken() {
        return contains(KEY_TOKEN);
    }

    @Override
    public String getPreferencesName() {
        return PREFERENCES_NAME;
    }
}
