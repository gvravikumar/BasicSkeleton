package com.gvrk.getmylostmobile.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.gvrk.getmylostmobile.Model.SampleResponse;
import com.gvrk.getmylostmobile.R;
import com.gvrk.getmylostmobile.View.Fragments.MapsFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    SampleResponse sampleResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        sampleResponse.setName("gvrk");
        getSupportFragmentManager().beginTransaction().replace(R.id.cl_main, new MapsFragment()).commit();
        Log.v("Dagger Setup", "in Activity is " + (sampleResponse != null));
        Log.v("Dagger Setup", sampleResponse.getName());
        startActivity(new Intent(this, Main2Activity.class));
    }
}
