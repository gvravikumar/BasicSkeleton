package com.gvrk.getmylostmobile.View.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.Model.SampleResponse;
import com.gvrk.getmylostmobile.R;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

public class MainActivity extends BasicActivity {

    @BindView(R.id.tv_lost_mobile)
    TextView tv_lost_mobile;
    @BindView(R.id.tv_register)
    TextView tv_register;
    @Inject
    FirebaseRemoteConfig mFirebaseRemoteConfig;
    @Inject
    FirebaseAnalytics mFirebaseAnalytics;
    @Inject
    Crashlytics crashlytics;
    @Inject
    SampleResponse sampleResponse;
    private String experiment1_variant;
    private String bg_color;
    Bundle params = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFirebaseAnalytics.logEvent("app_started", new Bundle());
//        tv_lost_mobile.setOnClickListener(lostMobile -> startActivity(new Intent(this, TrackLostMobileActivity.class)));
        tv_lost_mobile.setOnClickListener(lostMobile -> {
            params.putString(FirebaseAnalytics.Param.CURRENCY, experiment1_variant);
            mFirebaseAnalytics.logEvent("engagement_party", params);
            Toast.makeText(this, "'engagement_party' event triggered!", Toast.LENGTH_LONG).show();
        });
        tv_register.setOnClickListener(register -> {
            mFirebaseAnalytics.logEvent("registration", params);
            startActivity(new Intent(this, RegistrationActivity.class));
        });
        new Thread(() -> FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(instanceIdResult -> {
            Log.v("token", instanceIdResult.getToken());
            Log.v("token id", instanceIdResult.getId());
        })).start();
        fetchData();
//        Crashlytics.getInstance().crash(); // Force a crash
    }

    private void fetchData() {
        mFirebaseRemoteConfig.fetch(0).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                mFirebaseRemoteConfig.fetchAndActivate();
                experiment1_variant = mFirebaseRemoteConfig.getString("experiment_variant");
                bg_color = mFirebaseRemoteConfig.getString("bg_color");
                tv_lost_mobile.setText(experiment1_variant + "");
                if (bg_color.length() > 0) {
                    mFirebaseAnalytics.logEvent("ABTesting", params);
                    tv_lost_mobile.setBackgroundColor(Color.parseColor(bg_color));
                }
                mFirebaseAnalytics.setUserProperty("bg_clr", bg_color);
            }
        });
    }
}
