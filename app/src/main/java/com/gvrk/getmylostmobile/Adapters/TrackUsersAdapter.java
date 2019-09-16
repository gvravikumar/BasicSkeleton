package com.gvrk.getmylostmobile.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gvrk.getmylostmobile.Model.User;
import com.gvrk.getmylostmobile.R;

import java.util.List;

public class TrackUsersAdapter extends RecyclerView.Adapter<TrackUsersAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<User> userList;

    public TrackUsersAdapter(LayoutInflater inflater, Context context, List<User> userList) {
        this.inflater = inflater;
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public TrackUsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrackUsersAdapter.ViewHolder(inflater.inflate(R.layout.track_user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrackUsersAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
