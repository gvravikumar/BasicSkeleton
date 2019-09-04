package com.gvrk.getmylostmobile.Dagger.module;

import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {

    @Provides
    FirebaseDatabase getFirebaseDatabaseInstance() {
        return FirebaseDatabase.getInstance();
    }
}
