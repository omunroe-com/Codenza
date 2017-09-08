package com.codenza.dp.programs;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Request extends Fragment {
    MainActivity mf;
    public Request() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mf.navItemIndex = 2222;
        View view = inflater.inflate(R.layout.request, container, false);
        TextView txt = (TextView) view.findViewById(R.id.textview1);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "MYRIADAT.TTF");
        txt.setTypeface(font);
        // Inflate the layout for this fragment
        return view;
    }
}