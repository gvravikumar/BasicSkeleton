package com.gvrk.getmylostmobile.Dagger.module;

import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.View.Activities.RegistrationActivity;
import com.gvrk.getmylostmobile.View.Activities.MainActivity;
import com.gvrk.getmylostmobile.View.Activities.TrackLostMobileActivity;
import com.gvrk.getmylostmobile.View.Fragments.MapsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {FirebaseModule.class})
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = {FirebaseModule.class})
    abstract RegistrationActivity registrationActivity();

    @ContributesAndroidInjector(modules = {FirebaseModule.class})
    abstract TrackLostMobileActivity trackLostMobileActivity();

    @ContributesAndroidInjector(modules = {FirebaseModule.class})
    abstract BasicActivity basicActivity();

    @ContributesAndroidInjector(modules = {PojoModule.class})
    abstract MapsFragment mapsFragment();
}
