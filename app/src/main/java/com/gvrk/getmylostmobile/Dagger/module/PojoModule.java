package com.gvrk.getmylostmobile.Dagger.module;

import com.gvrk.getmylostmobile.Model.SampleResponse;

import dagger.Module;
import dagger.Provides;

@Module
public class PojoModule {
    @Provides
    SampleResponse sampleResponse() {
        return new SampleResponse();
    }
}
