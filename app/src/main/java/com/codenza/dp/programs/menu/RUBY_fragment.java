package com.codenza.dp.programs.menu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codenza.dp.programs.MainActivity;
import com.codenza.dp.programs.R;
import com.codenza.dp.programs.ruby.algo.RubyAlgo;
import com.codenza.dp.programs.ruby.arrays.RubyArrays;
import com.codenza.dp.programs.ruby.basics.RubyBasics;
import com.codenza.dp.programs.ruby.ds.RubyDs;
import com.codenza.dp.programs.ruby.patterns.RubyPatterns;

public class RUBY_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] dsf_prog = {"Basics", "Arrays", "Algorithms", "Data Structures","Patterns"};
    ListView listViewMenu1;
    ArrayAdapter<String> menuAdapter;
    MainActivity mf;
    FloatingActionButton fab2;
    public RUBY_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position != -1) {
            remove_layout();
            Fragment fragment_new = null;
            //Selecting the respective fragment
            if (position == 0) {
                fragment_new = new RubyBasics();
                getActivity().setTitle("Ruby Programs");
                mf.navItemIndex = 2501;
            }else if(position == 1){
                fragment_new = new RubyArrays();
                getActivity().setTitle("Ruby Programs");
                mf.navItemIndex = 2502;
            }else if(position == 2){
                fragment_new = new RubyAlgo();
                getActivity().setTitle("Ruby Programs");
                mf.navItemIndex = 2503;
            }else if(position == 3){
                fragment_new = new RubyDs();
                getActivity().setTitle("Ruby Programs");
                mf.navItemIndex = 2504;
            }else if(position == 4){
                fragment_new = new RubyPatterns();
                getActivity().setTitle("Ruby Programs");
                mf.navItemIndex = 2505;
            }

            //Starting the respective Fragment
            if (fragment_new != null) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, fragment_new)
                        .addToBackStack(null)
                        .commit();
            }
        }
    }

    public void remove_layout(){
        listViewMenu1.setVisibility(View.GONE);
        fab2.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mf.navItemIndex = 25;

        View view = inflater.inflate(R.layout.frag_spa, container, false);
        listViewMenu1 = (ListView) view.findViewById(R.id.listView);
        menuAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dsf_prog);
        listViewMenu1.setAdapter(menuAdapter);
        listViewMenu1.setOnItemClickListener(this);
        fab2 = (FloatingActionButton) view.findViewById(R.id.fab2);
        fab2.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        drawer.openDrawer(Gravity.LEFT);
    }
}
