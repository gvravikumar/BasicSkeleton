package com.gvrk.getmylostmobile.Dagger.module;

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
    FirebaseDatabase getFirebaseDatabaseInstance() {
        return FirebaseDatabase.getInstance();
    }

    @Provides
    FirebaseRemoteConfig getFirebaseRemoteConfig() {
        return FirebaseRemoteConfig.getInstance();
    }

    @Provides
    Crashlytics getCrashlytics() {
        return Crashlytics.getInstance();
    }

    @Provides
    FirebaseAnalytics getFirebaseAnalytics(MainApp app) {
        return FirebaseAnalytics.getInstance(app);
    }
}
