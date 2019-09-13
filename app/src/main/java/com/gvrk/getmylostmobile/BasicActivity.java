package com.gvrk.getmylostmobile;

import android.os.Bundle;

import androidx.annotation.Nullable;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class BasicActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
    }
}
