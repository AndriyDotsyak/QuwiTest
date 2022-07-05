package com.quwi.apptest.base.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public abstract class BasePreferencesManager {

    private Context context;
    private SharedPreferences preferences;

    private static final int DEFAULT_NUMBER = 0;
    private static final boolean DEFAULT_BOOLEAN = false;

    public BasePreferencesManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(getPreferencesName(), Context.MODE_PRIVATE);
    }

    protected abstract String getPreferencesName();

    protected void putString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    protected String getString(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    protected String getString(String key) {
        return getString(key, "");
    }

    protected void putInt(String key, int value) {
        preferences.edit().putInt(key, value).apply();
    }

    protected int getInt(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    protected int getInt(String key) {
        return getInt(key, DEFAULT_NUMBER);
    }

    protected void putLong(String key, Long value) {
        preferences.edit().putLong(key, value).apply();
    }

    protected Long getLong(String key, Long defaultValue) {
        return preferences.getLong(key, defaultValue);
    }

    protected Long getLong(String key) {
        return getLong(key, (long) DEFAULT_NUMBER);
    }

    protected void putBoolean(String key, Boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }

    protected boolean getBoolean(String key, Boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    protected boolean getBoolean(String key) {
        return getBoolean(key, DEFAULT_BOOLEAN);
    }

    protected void putFloat(String key, Float value) {
        preferences.edit().putFloat(key, value).apply();
    }

    protected float getFloat(String key, Float defaultValue) {
        return preferences.getFloat(key, defaultValue);
    }

    protected float getFloat(String key) {
        return getFloat(key, (float) DEFAULT_NUMBER);
    }

    protected <T> void putObject(String key, T obj) {
        preferences.edit().putString(key, new Gson().toJson(obj)).apply();
    }

    protected <T> T getObject(String key, Class<T> classType) {
        try {
            return new Gson().fromJson(getString(key), classType);
        } catch (Exception error) {
            return null;
        }
    }

    protected boolean contains(String key) {
        return preferences.contains(key);
    }

    public void clear() {
        preferences.edit().clear().apply();
    }

}
