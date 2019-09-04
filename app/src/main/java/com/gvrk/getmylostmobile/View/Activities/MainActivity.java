package com.gvrk.getmylostmobile.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends BasicActivity {

    @BindView(R.id.tv_lost_mobile)
    TextView tv_lost_mobile;
    @BindView(R.id.tv_register)
    TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tv_lost_mobile.setOnClickListener(lostMobile -> startActivity(new Intent(this, TrackLostMobileActivity.class)));
        tv_register.setOnClickListener(register -> startActivity(new Intent(this, RegistrationActivity.class)));
    }
}
