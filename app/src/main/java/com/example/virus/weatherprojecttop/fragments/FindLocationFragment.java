package com.example.virus.weatherprojecttop.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virus.weatherprojecttop.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class FindLocationFragment extends Fragment {


    public FindLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find_location, container, false);
        return view; }

}
