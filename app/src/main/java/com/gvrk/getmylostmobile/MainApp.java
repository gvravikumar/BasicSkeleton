package com.gvrk.getmylostmobile;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;

import com.gvrk.getmylostmobile.Dagger.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasContentProviderInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainApp extends Application implements HasActivityInjector,
        HasSupportFragmentInjector, HasServiceInjector, HasBroadcastReceiverInjector,
        HasContentProviderInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<androidx.fragment.app.Fragment> dispatchingAndroidFragmentInjector;
    @Inject
    DispatchingAndroidInjector<Service> dispatchingAndroidServiceInjector;
    @Inject
    DispatchingAndroidInjector<BroadcastReceiver> dispatchingAndroidBroadcastReceiverInjector;
    @Inject
    DispatchingAndroidInjector<ContentProvider> dispatchingAndroidContentProviderInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<androidx.fragment.app.Fragment> supportFragmentInjector() {
        return dispatchingAndroidFragmentInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return dispatchingAndroidServiceInjector;
    }

    @Override
    public AndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {
        return dispatchingAndroidBroadcastReceiverInjector;
    }

    @Override
    public AndroidInjector<ContentProvider> contentProviderInjector() {
        return dispatchingAndroidContentProviderInjector;
    }
}
