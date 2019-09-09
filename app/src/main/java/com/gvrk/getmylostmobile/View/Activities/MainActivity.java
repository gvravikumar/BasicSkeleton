package com.gvrk.getmylostmobile.View.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends BasicActivity {

    @BindView(R.id.tv_lost_mobile)
    TextView tv_lost_mobile;
    @BindView(R.id.tv_register)
    TextView tv_register;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private FirebaseAnalytics mFirebaseAnalytics;
    private String experiment1_variant;
    private String bg_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
//        tv_lost_mobile.setOnClickListener(lostMobile -> startActivity(new Intent(this, TrackLostMobileActivity.class)));
        tv_lost_mobile.setOnClickListener(lostMobile -> {
            Bundle params = new Bundle();
            params.putString(FirebaseAnalytics.Param.LOCATION, experiment1_variant);
            mFirebaseAnalytics.logEvent("engagement_party", params);
            Toast.makeText(this, "'engagement_party' event triggered!", Toast.LENGTH_LONG).show();
        });
        tv_register.setOnClickListener(register -> startActivity(new Intent(this, RegistrationActivity.class)));
        new Thread(() -> FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(instanceIdResult -> {
            Log.v("token", instanceIdResult.getToken());
            Log.v("token id", instanceIdResult.getId());
        })).start();
        fetchData();
    }

    private void fetchData() {
        mFirebaseRemoteConfig.fetch(0).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                mFirebaseRemoteConfig.fetchAndActivate();
                experiment1_variant = mFirebaseRemoteConfig.getString("experiment_variant");
                bg_color = mFirebaseRemoteConfig.getString("bg_color");
                tv_lost_mobile.setText(experiment1_variant + "");
                if (bg_color.length() > 0)
                    tv_lost_mobile.setBackgroundColor(Color.parseColor(bg_color));
            }
        });
    }
}
