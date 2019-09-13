package com.gvrk.getmylostmobile.Dagger.module;

import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.View.Activities.MainActivity;
import com.gvrk.getmylostmobile.View.Activities.RegistrationActivity;
import com.gvrk.getmylostmobile.View.Activities.TrackLostMobileActivity;
import com.gvrk.getmylostmobile.View.Fragments.MapsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    //modules scope to respective Views
    @ContributesAndroidInjector(modules = {})
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = {})
    abstract RegistrationActivity registrationActivity();

    @ContributesAndroidInjector(modules = {})
    abstract TrackLostMobileActivity trackLostMobileActivity();

    @ContributesAndroidInjector(modules = {})
    abstract BasicActivity basicActivity();

    @ContributesAndroidInjector(modules = {})
    abstract MapsFragment mapsFragment();
}
