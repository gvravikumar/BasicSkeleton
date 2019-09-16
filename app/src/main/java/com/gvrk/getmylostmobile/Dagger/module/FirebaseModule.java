package com.gvrk.getmylostmobile.Dagger.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.gvrk.getmylostmobile.MainApp;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {

    @Provides
    static FirebaseDatabase getFirebaseDatabaseInstance() {
        return FirebaseDatabase.getInstance();
    }

    @Provides
    static FirebaseRemoteConfig getFirebaseRemoteConfig() {
        return FirebaseRemoteConfig.getInstance();
    }

    @Provides
    static Crashlytics getCrashlytics() {
        return Crashlytics.getInstance();
    }

    @Provides
    static FirebaseAnalytics getFirebaseAnalytics(Context app) {
        return FirebaseAnalytics.getInstance(app);
    }
}
