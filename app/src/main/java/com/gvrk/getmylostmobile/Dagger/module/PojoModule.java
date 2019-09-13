package com.gvrk.getmylostmobile.Dagger.module;

import com.gvrk.getmylostmobile.Model.SampleResponse;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PojoModule {
    @Provides
    @Singleton
    SampleResponse sampleResponse() {
        return new SampleResponse();
    }
}
