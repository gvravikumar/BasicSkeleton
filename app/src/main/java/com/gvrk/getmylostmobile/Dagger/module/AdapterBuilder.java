package com.gvrk.getmylostmobile.Dagger.module;

import com.gvrk.getmylostmobile.Adapters.TrackUsersAdapter;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AdapterBuilder {

    @ContributesAndroidInjector()
    abstract TrackUsersAdapter trackUsersAdapter();
}
