package com.gvrk.getmylostmobile.View.Fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.gvrk.getmylostmobile.Model.SampleResponse;
import com.gvrk.getmylostmobile.R;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends DaggerFragment {

    @Inject
    SampleResponse sampleResponse;

    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        AndroidSupportInjection.inject(this);
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

}
