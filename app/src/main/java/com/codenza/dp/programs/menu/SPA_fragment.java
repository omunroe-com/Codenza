package com.codenza.dp.programs.menu;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


public class SPA_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] spa_prog = {"Basic", "Control Statements", "Data Input and File Operations", "Functions", "Pattern Programs", "Series Programs",
            "Structures and Unions","Matrix","Bitwise Operations","Numerical","Recursion","Searching & Sorting","Arrays","Strings Operations","Without Recursion","    "};
    ListView listViewMenu;
    ArrayAdapter<String> menuAdapter;
    Fragment fragment_new;
    MainActivity mf;
    FloatingActionButton fab2;


    public SPA_fragment() {
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
            fragment_new = new BasicC();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 111;
        }else if(position == 1){
            fragment_new = new ControlStatements();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 112;
        }else if(position == 2){
            fragment_new = new DataIPandOP();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 113;
        }else if(position == 3){
            fragment_new = new Functions();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 114;
        }else if(position == 4){
            fragment_new = new PatternPrograms();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 115;
        }else if(position == 5){
            fragment_new = new SeriesPrograms();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 116;
        }else if(position == 6){
            fragment_new = new StructuresUnions();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 117;
        }else if(position==7){
            fragment_new = new matrix();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 118;
        }else if(position==8){
            fragment_new = new bitwise();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 119;
        }else if(position==9){
            fragment_new = new NumericalC();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 120;
        }else if(position==10){
            fragment_new = new RecursionC();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 121;
        }else if(position==11){
            fragment_new = new SearchSortC();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 122;
        }else if(position==12){
            fragment_new = new ArraysC();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 123;
        }else if(position==13){
            fragment_new = new StringC();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 124;
        }else if(position==14){
            fragment_new = new Wrecursion();
            getActivity().setTitle("C Programs");
            mf.navItemIndex = 125;
        }
        //Starting the respective Fragment
        if(fragment_new != null){
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment_new)
                    .addToBackStack(null)
                    .commit();
        }
//        else{
//            fragment_new = new ArraysC();
//            FragmentManager fragmentManager = getFragmentManager();
//            fragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment_new)
//                    .addToBackStack(null)
//                    .commit();
//        }

    }


    public void remove_layout(){
        listViewMenu.setVisibility(View.GONE);
        fab2.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mf.navItemIndex = 1;

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