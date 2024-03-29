package com.gvrk.getmylostmobile.Dagger.module;

import com.gvrk.getmylostmobile.Adapters.TrackUsersAdapter;
import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.View.Activities.MainActivity;
import com.gvrk.getmylostmobile.View.Activities.RegistrationActivity;
import com.gvrk.getmylostmobile.View.Activities.SplashScreenActivity;
import com.gvrk.getmylostmobile.View.Activities.TrackLostMobileActivity;
import com.gvrk.getmylostmobile.View.Activities.UsersListActivity;
import com.gvrk.getmylostmobile.View.Fragments.MapsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    //modules scope to respective Views
    //every fragment, activity must be registered here.
    @ContributesAndroidInjector()
    abstract BasicActivity basicActivity();

    @ContributesAndroidInjector()
    abstract SplashScreenActivity splashScreenActivity();

    @ContributesAndroidInjector()
    abstract RegistrationActivity registrationActivity();

    @ContributesAndroidInjector()
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector()
    abstract UsersListActivity usersListActivity();

    @ContributesAndroidInjector()
    abstract TrackLostMobileActivity trackLostMobileActivity();

    @ContributesAndroidInjector()
    abstract MapsFragment mapsFragment();
}
