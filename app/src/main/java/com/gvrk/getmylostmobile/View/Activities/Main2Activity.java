package com.gvrk.getmylostmobile.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.gvrk.getmylostmobile.Model.SampleResponse;
import com.gvrk.getmylostmobile.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class Main2Activity extends AppCompatActivity {

    @Inject
    SampleResponse sampleResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AndroidInjection.inject(this);
        Log.v("Dagger Second", sampleResponse.getName());
    }
}
