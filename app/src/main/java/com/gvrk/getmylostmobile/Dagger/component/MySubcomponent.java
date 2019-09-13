package com.gvrk.getmylostmobile.Dagger.component;

import com.gvrk.getmylostmobile.MainApp;

import dagger.Subcomponent;

@Subcomponent(modules = {})
public interface MySubcomponent {
    void inject(MainApp app);
}
