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
import com.codenza.dp.programs.cpp.combinationalcpp.CombinationalCPP;
import com.codenza.dp.programs.cpp.computationalcpp.ComputationalCPP;
import com.codenza.dp.programs.cpp.hdcpp.HardGraphCPP;
import com.codenza.dp.programs.cpp.introcpp.IntroCPP;
import com.codenza.dp.programs.cpp.numericalcpp.NumericalCPP;
import com.codenza.dp.programs.cpp.others.OtherCPP;
import com.codenza.dp.programs.cpp.overviewcpp.OverviewCPP;
import com.codenza.dp.programs.cpp.setstringscpp.SetsStringsCPP;


public class CPP_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] cpp_prog = {"Overview", "Intro", "Numerical Problems/Algorithms", "Combinational Problems/Algorithms", "Computational Problems/Algorithms", "Hard Graph Problems", "Sets & Strings","Others"};
    ListView listViewMenu;
    ArrayAdapter<String> menuAdapter;
    Fragment fragment_new;
    FloatingActionButton fab2;
    MainActivity mf;
    public CPP_fragment() {
        //required empty public class.
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        remove_layout();
        fragment_new = null;
        //Selecting the respective fragment
        if(position == 0){
            fragment_new = new OverviewCPP();
            getActivity().setTitle("C++");
            mf.navItemIndex = 311;
        }
        else if(position == 1){
            fragment_new = new IntroCPP();
            getActivity().setTitle("C++");
            mf.navItemIndex = 312;
        }
        else if(position == 2){
            fragment_new = new NumericalCPP();
            getActivity().setTitle("C++");
            mf.navItemIndex = 313;
        }
        else if(position == 3){
            fragment_new = new CombinationalCPP();
            getActivity().setTitle("C++");
            mf.navItemIndex = 314;
        }
        else if(position == 4){
            fragment_new = new ComputationalCPP();
            getActivity().setTitle("C++");
            mf.navItemIndex = 315;
        }
        else if(position == 5){
            fragment_new = new HardGraphCPP();
            getActivity().setTitle("C++");
            mf.navItemIndex = 316;
        }
        else if(position == 6){
            fragment_new = new SetsStringsCPP();
            getActivity().setTitle("C++");
            mf.navItemIndex = 317;
        }else if(position == 7){
            fragment_new = new OtherCPP();
            getActivity().setTitle("C++");
            mf.navItemIndex = 318;
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

    }


    public void remove_layout(){
        listViewMenu.setVisibility(View.GONE);
        fab2.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mf.navItemIndex = 3;

        View view = inflater.inflate(R.layout.frag_spa, container, false);
        listViewMenu = (ListView) view.findViewById(R.id.listView);
        menuAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, cpp_prog);
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