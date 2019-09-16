package com.gvrk.getmylostmobile.Dagger.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;

import com.gvrk.getmylostmobile.Utils.PreferenceManager;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return this.context;
    }

    @Provides
    static SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences("LOST_MOBILE", Context.MODE_PRIVATE);
    }

    @Provides
    static PreferenceManager providePreferenceManger(SharedPreferences sharedPreferences) {
        return new PreferenceManager(sharedPreferences);
    }

    @Provides
    static LayoutInflater provideLayoutIn(Context context) {
        return LayoutInflater.from(context);
    }
}
