package com.gvrk.getmylostmobile.View.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.Model.SampleResponse;
import com.gvrk.getmylostmobile.R;
import com.gvrk.getmylostmobile.Receivers.SmsReceiver;
import com.judemanutd.autostarter.AutoStartPermissionHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BasicActivity {

    private static final int SMS_PERMISSION_CODE = 1212;
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
        tv_lost_mobile.setOnClickListener(lostMobile -> startActivity(new Intent(this, TrackLostMobileActivity.class)));
        tv_register.setOnClickListener(register -> {
            mFirebaseAnalytics.logEvent("registration", params);
            startActivity(new Intent(this, RegistrationActivity.class));
        });
        new Thread(() -> FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(instanceIdResult -> {
            Log.v("token", instanceIdResult.getToken());
            Log.v("token id", instanceIdResult.getId());
        })).start();
        fetchData();
        if (!isSmsPermissionGranted())
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, SMS_PERMISSION_CODE);

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

    public boolean isSmsPermissionGranted() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case SMS_PERMISSION_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else
                    Toast.makeText(this, "SMS permissions are must required.", Toast.LENGTH_LONG).show();
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
