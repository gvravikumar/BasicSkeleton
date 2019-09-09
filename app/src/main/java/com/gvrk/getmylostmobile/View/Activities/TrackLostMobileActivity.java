package com.gvrk.getmylostmobile.View.Activities;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.R;

import java.util.HashMap;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class TrackLostMobileActivity extends BasicActivity {

    @Inject
    FirebaseDatabase firebaseDatabase;
    DatabaseReference registeredUsersDatabase;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_lost_mobile);
        AndroidInjection.inject(this);
        registeredUsersDatabase = firebaseDatabase.getReference("registeredUsers");
        registeredUsersDatabase.child(Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID))
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        HashMap<String, String> values = (HashMap<String, String>) dataSnapshot.getValue();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
}
