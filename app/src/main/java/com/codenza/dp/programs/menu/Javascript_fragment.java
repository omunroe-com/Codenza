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
import com.codenza.dp.programs.js.jsalgo.JsAlgo;
import com.codenza.dp.programs.js.jsarray.JsArray;
import com.codenza.dp.programs.js.jsbasic.JsBasic;
import com.codenza.dp.programs.js.jsconditional.JsConditional;
import com.codenza.dp.programs.js.jsdate.JsDate;
import com.codenza.dp.programs.js.jsdrawing.JsDrawing;
import com.codenza.dp.programs.js.jsfunctions.JsFunctions;
import com.codenza.dp.programs.js.jshtmldom.JsHtmldom;
import com.codenza.dp.programs.js.jsmath.JsMath;
import com.codenza.dp.programs.js.jsobject.JsObject;
import com.codenza.dp.programs.js.jsrecursion.JsRecursion;
import com.codenza.dp.programs.js.jsstring.JsString;
import com.codenza.dp.programs.js.jsvre.JsWRE;
import com.codenza.dp.programs.js.jsvwre.JsWORE;
import com.codenza.dp.programs.js.other.JsOthers;
import com.codenza.dp.programs.spa.arrays.ArraysC;
import com.codenza.dp.programs.spa.bitwise.bitwise;
import com.codenza.dp.programs.spa.control_statements.ControlStatements;
import com.codenza.dp.programs.spa.data_input_output.DataIPandOP;
import com.codenza.dp.programs.spa.functions.Functions;
import com.codenza.dp.programs.spa.matrix.matrix;
import com.codenza.dp.programs.spa.numerical.NumericalC;
import com.codenza.dp.programs.spa.pattern_programs.PatternPrograms;
import com.codenza.dp.programs.spa.recursion.RecursionC;
import com.codenza.dp.programs.spa.searchsort.SearchSortC;
import com.codenza.dp.programs.spa.series_programs.SeriesPrograms;
import com.codenza.dp.programs.spa.simple.BasicC;
import com.codenza.dp.programs.spa.stringop.StringC;
import com.codenza.dp.programs.spa.structures_unions.StructuresUnions;
import com.codenza.dp.programs.spa.wrecursion.Wrecursion;


public class Javascript_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] spa_prog = {"Algorithms","Arrays","Basic","Conditional Statement & Loops","Date","Drawing","Functions","HTML-DOM","Math","Object","Recursion","String","Validation with RE","Validation without RE","Other"};
    ListView listViewMenu;
    ArrayAdapter<String> menuAdapter;
    Fragment fragment_new;
    MainActivity mf;
    FloatingActionButton fab2;


    public Javascript_fragment() {
        //required empty public class.
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        fab2.setVisibility(View.GONE);
        fab2.setVisibility(View.INVISIBLE);
        remove_layout();
        fragment_new = null;
        //Selecting the respective fragment
        if(position == 0){
            fragment_new = new JsAlgo();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1600;
        }else if(position == 1){
            fragment_new = new JsArray();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1601;
        }else if(position == 2){
            fragment_new = new JsBasic();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1602;
        }else if(position == 3){
            fragment_new = new JsConditional();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1603;
        }else if(position == 4){
            fragment_new = new JsDate();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1604;
        }else if(position == 5){
            fragment_new = new JsDrawing();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1605;
        }else if(position == 6){
            fragment_new = new JsFunctions();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1606;
        }else if(position == 7){
            fragment_new = new JsHtmldom();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1607;
        }else if(position == 8){
            fragment_new = new JsMath();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1608;
        }else if(position == 9){
            fragment_new = new JsObject();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1609;
        }else if(position == 10){
            fragment_new = new JsRecursion();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1610;
        }else if(position == 11){
            fragment_new = new JsString();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1611;
        }else if(position == 12){
            fragment_new = new JsWRE();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1612;
        }else if(position == 13){
            fragment_new = new JsWORE();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1613;
        }else if(position == 14){
            fragment_new = new JsOthers();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 1614;
        }
        if (fragment_new != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment_new)
                    .addToBackStack(null)
                    .commit();
        }
    }


    public void remove_layout(){
        listViewMenu.setVisibility(View.GONE);
        fab2.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mf.navItemIndex = 16;

        View view = inflater.inflate(R.layout.frag_spa, container, false);
        listViewMenu = (ListView) view.findViewById(R.id.listView);
        menuAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, spa_prog);
        listViewMenu.setAdapter(menuAdapter);
        listViewMenu.setOnItemClickListener(this);
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