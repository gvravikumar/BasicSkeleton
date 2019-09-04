package com.gvrk.getmylostmobile.View.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.Model.UserRegistration;
import com.gvrk.getmylostmobile.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class RegistrationActivity extends BasicActivity {

    @Inject
    FirebaseDatabase firebaseDatabase;
    DatabaseReference registeredUsersDatabase;

    @BindView(R.id.et_self)
    EditText et_self;
    @BindView(R.id.et_other)
    EditText et_other;
    @BindView(R.id.et_mail)
    EditText et_mail;
    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.tv_register)
    TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        tv_register.setOnClickListener(register);
    }

    @SuppressLint("HardwareIds")
    View.OnClickListener register = v -> {
        if (isValid()) {
            registeredUsersDatabase = firebaseDatabase.getReference("registeredUsers");
            UserRegistration userRegistration = new UserRegistration();
            userRegistration.setSelf(et_self.getText().toString());
            userRegistration.setOther(et_other.getText().toString());
            userRegistration.setEmail(et_mail.getText().toString());
            userRegistration.setName(et_name.getText().toString());
            registeredUsersDatabase.child(Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID))
                    .setValue(userRegistration, (databaseError, databaseReference) -> finish());
            finish();
        }
    };

    private boolean isValid() {
        boolean isValid = false;
        if (et_self.getText().toString().trim().length() < 10)
            et_self.setError(getString(R.string.self_error));
        else if (et_other.getText().toString().trim().length() < 10)
            et_other.setError(getString(R.string.other_error));
        else if ((TextUtils.isEmpty(et_mail.getText().toString()) || !et_mail.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")))
            et_mail.setError(getString(R.string.mail_error));
        else if (et_name.getText().toString().trim().length() <= 0)
            et_name.setError(getString(R.string.name_error));
        else isValid = true;
        return isValid;
    }
}
