package com.gvrk.getmylostmobile.Utils;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ravikumargv on 16/09/2019.
 */

@Singleton
public class PreferenceManager {

    private SharedPreferences mSharedPreferences;

    @Inject
    public PreferenceManager(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public void put(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public void deleteSavedData(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }
}
