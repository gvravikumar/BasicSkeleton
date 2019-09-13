package com.gvrk.getmylostmobile.Dagger.module;

import android.content.Context;

import com.gvrk.getmylostmobile.MainApp;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    @Provides
    Context context(MainApp app) {
        return app;
    }
}
