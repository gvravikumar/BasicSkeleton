package com.gvrk.getmylostmobile.View.Activities;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.gvrk.getmylostmobile.Adapters.TrackUsersAdapter;
import com.gvrk.getmylostmobile.BasicActivity;
import com.gvrk.getmylostmobile.Model.User;
import com.gvrk.getmylostmobile.R;
import com.gvrk.getmylostmobile.Utils.StringConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersListActivity extends BasicActivity {

    @BindView(R.id.fab_add_other_user)
    FloatingActionButton fab_add_other_user;
    @BindView(R.id.rv_track_users)
    RecyclerView rv_track_users;
    List<User> userList = new ArrayList<>();
    @Inject
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        ButterKnife.bind(this);
        Objects.requireNonNull(getSupportActionBar()).setTitle(StringConstants.TRACK_USERS);
        fab_add_other_user.setOnClickListener(addOtherUser);
        getAllContacts();
        rv_track_users.setLayoutManager(new LinearLayoutManager(this));
        rv_track_users.setAdapter(new TrackUsersAdapter(inflater, this, userList));
        //TrackLostMobileActivity
    }

    private void getAllContacts() {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if ((cur != null ? cur.getCount() : 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                    pCur.close();
                }
            }
        }
        if (cur != null) {
            cur.close();
        }
    }

    View.OnClickListener addOtherUser = v -> startActivity(new Intent(UsersListActivity.this, AddOtherUserActivity.class));
}
