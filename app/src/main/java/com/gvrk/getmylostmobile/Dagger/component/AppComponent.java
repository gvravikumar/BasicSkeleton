package com.gvrk.getmylostmobile.Dagger.component;

import com.gvrk.getmylostmobile.Dagger.module.ActivityBuilder;
import com.gvrk.getmylostmobile.MainApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBuilder.class})
public interface AppComponent {
    void inject(MainApp app);
}
