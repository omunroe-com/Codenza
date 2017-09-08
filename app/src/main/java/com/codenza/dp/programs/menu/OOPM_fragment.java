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
import com.codenza.dp.programs.oopm.apijava.ApiJava;
import com.codenza.dp.programs.oopm.appletawtjava.AppletAwtJava;
import com.codenza.dp.programs.oopm.basicsjava.BasicsJava;
import com.codenza.dp.programs.oopm.cgjava.CgJava;
import com.codenza.dp.programs.oopm.computationaljava.ComputationalJava;
import com.codenza.dp.programs.oopm.corejava.CoreJava;
import com.codenza.dp.programs.oopm.dsjava.DsJava;
import com.codenza.dp.programs.oopm.graphjava.GraphJava;
import com.codenza.dp.programs.oopm.hardgraphjava.HardGraphJava;
import com.codenza.dp.programs.oopm.numericaljava.NumericalJava;
import com.codenza.dp.programs.oopm.searchingsortingjava.SearchingSortingJava;
import com.codenza.dp.programs.oopm.servlets.ServletsSessionSwingUtilJava;
import com.codenza.dp.programs.oopm.xml.XmlJava;

public class OOPM_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] java_prog = {"Basics", "Numerical Problems", "Searching & Sorting Algorithms", "Graph Problems/Algorithms", "Hard Graph Problems", "Computational Geometry", "Data Structures", "API Problems","Computer Graphics","Core Java","Applet & AWT","XML & Others"," Servlets, Session, Swing, Util"};
    ListView listViewMenu;
    ArrayAdapter<String> menuAdapter;
    Fragment fragment_new;
    FloatingActionButton fab2;
    MainActivity mf;
    public OOPM_fragment() {
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
            fragment_new = new BasicsJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 211;
        }else if(position == 1){
            fragment_new = new NumericalJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 212;
        }else if(position == 2){
            fragment_new = new SearchingSortingJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 213;
        }else if(position == 3){
            fragment_new = new GraphJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 214;
        }else if(position == 4){
            fragment_new = new HardGraphJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 215;
        }else if(position == 5){
            fragment_new = new ComputationalJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 216;
        }else if(position == 6){
            fragment_new = new DsJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 217;
        }else if(position == 7){
            fragment_new = new ApiJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 218;
        }else if(position == 8){
            fragment_new = new CgJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 219;
        }else if(position == 9){
            fragment_new = new CoreJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 220;
        }else if(position == 10){
            fragment_new = new AppletAwtJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 221;
        }else if(position == 11){
            fragment_new = new XmlJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 222;
        }else if(position == 12){
            fragment_new = new ServletsSessionSwingUtilJava();
            getActivity().setTitle("Java");
            mf.navItemIndex = 223;
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
        mf.navItemIndex = 2;

        View view = inflater.inflate(R.layout.frag_spa, container, false);
        listViewMenu = (ListView) view.findViewById(R.id.listView);
        menuAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, java_prog);
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