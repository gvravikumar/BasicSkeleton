package com.gvrk.getmylostmobile.Dagger.module;

import com.gvrk.getmylostmobile.View.Activities.Main2Activity;
import com.gvrk.getmylostmobile.View.Activities.MainActivity;
import com.gvrk.getmylostmobile.View.Fragments.MapsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {PojoModule.class})
    abstract MainActivity contributeProductListActivity();

    @ContributesAndroidInjector(modules = {PojoModule.class})
    abstract Main2Activity main2Activity();

    @ContributesAndroidInjector(modules = {PojoModule.class})
    abstract MapsFragment mapsFragment();
}
