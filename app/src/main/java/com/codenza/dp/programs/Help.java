package com.codenza.dp.programs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Help extends Fragment {
    MainActivity mf;
    public Help() {
        // Required empty public constructor

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mf.navItemIndex = 3333;

        View view = inflater.inflate(R.layout.help, container, false);

        TextView txt = (TextView) view.findViewById(R.id.textview1);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "MYRIADAT.TTF");
        txt.setTypeface(font);
        // Inflate the layout for this fragment
        return view;
    }
}