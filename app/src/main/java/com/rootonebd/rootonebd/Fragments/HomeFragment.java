package com.rootonebd.rootonebd.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootonebd.rootonebd.R;

/**
 * Created by IMATPC-12 on 20-Jan-18.
 */

public class HomeFragment extends Fragment{

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        //Initialize View
        initView(view);

        return view;
    }

    private void initView(View view) {
    }

}
