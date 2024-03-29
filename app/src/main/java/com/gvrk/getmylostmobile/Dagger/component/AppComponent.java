package com.gvrk.getmylostmobile.Dagger.component;

import com.gvrk.getmylostmobile.Dagger.module.ActivityBuilder;
import com.gvrk.getmylostmobile.Dagger.module.ContextModule;
import com.gvrk.getmylostmobile.Dagger.module.FirebaseModule;
import com.gvrk.getmylostmobile.Dagger.module.PojoModule;
import com.gvrk.getmylostmobile.MainApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        FirebaseModule.class,
        ContextModule.class,
        PojoModule.class,})
//app scope modules
public interface AppComponent {
    void inject(MainApp app);
}