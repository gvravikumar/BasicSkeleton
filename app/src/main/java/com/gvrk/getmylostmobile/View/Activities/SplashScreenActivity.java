package com.gvrk.getmylostmobile.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.R;
import com.gvrk.getmylostmobile.Utils.PreferenceManager;
import com.gvrk.getmylostmobile.Utils.StringConstants;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SplashScreenActivity extends BasicActivity {

    @Inject
    PreferenceManager preferenceManager;
    String user_name;
    Handler countDown = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        user_name = preferenceManager.get(StringConstants.USER_NAME, StringConstants.DEFAULT);
        countDown.postDelayed(this::loadLandingScreen, 500);
    }

    private void loadLandingScreen() {
        if (user_name != null && user_name.length() > 0)
            startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        else
            startActivity(new Intent(SplashScreenActivity.this, RegistrationActivity.class));
        finish();
    }
}
