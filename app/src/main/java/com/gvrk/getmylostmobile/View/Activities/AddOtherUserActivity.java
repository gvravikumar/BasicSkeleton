package com.gvrk.getmylostmobile.View.Activities;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;
import com.gvrk.getmylostmobile.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AddOtherUserActivity extends DaggerAppCompatActivity {
    @Inject
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_other_user);
        //get all contacts.
    }
}
