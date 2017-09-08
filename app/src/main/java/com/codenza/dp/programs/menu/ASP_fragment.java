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
import com.codenza.dp.programs.asp.active.ActiveAsp;
import com.codenza.dp.programs.asp.code.CodeAsp;
import com.codenza.dp.programs.asp.components.ComponentsAsp;
import com.codenza.dp.programs.asp.data.DataAsp;
import com.codenza.dp.programs.asp.files.FilesAsp;
import com.codenza.dp.programs.asp.misc.MiscAsp;
import com.codenza.dp.programs.asp.others.OthersAsp;
import com.codenza.dp.programs.asp.sessions.SessionsAsp;
import com.codenza.dp.programs.asp.strings.StringsAsp;


public class ASP_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] spa_prog = {"ActiveX ADO Arrays","Components","Data-Access/Date-Time","Files & Maths","Miscellaneous","More Code Snippets","Others","Sessions/SQl","Strings"};
    ListView listViewMenu;
    ArrayAdapter<String> menuAdapter;
    Fragment fragment_new;
    MainActivity mf;
    FloatingActionButton fab2;


    public ASP_fragment() {
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
            fragment_new = new ActiveAsp();
            getActivity().setTitle("ASP");
            mf.navItemIndex = 2301;
        }else if(position == 1){
            fragment_new = new ComponentsAsp();
            getActivity().setTitle("ASP");
            mf.navItemIndex = 2302;
        }else if(position == 2){
            fragment_new = new DataAsp();
            getActivity().setTitle("ASP");
            mf.navItemIndex = 2303;
        }else if(position == 3){
            fragment_new = new FilesAsp();
            getActivity().setTitle("ASP");
            mf.navItemIndex = 2304;
        }else if(position == 4){
            fragment_new = new MiscAsp();
            getActivity().setTitle("ASP");
            mf.navItemIndex = 2305;
        }else if(position == 5){
            fragment_new = new CodeAsp();
            getActivity().setTitle("ASP");
            mf.navItemIndex = 2306;
        }else if(position == 6){
            fragment_new = new OthersAsp();
            getActivity().setTitle("Javascript");
            mf.navItemIndex = 2307;
        }else if(position == 7){
            fragment_new = new SessionsAsp();
            getActivity().setTitle("ASP");
            mf.navItemIndex = 2308;
        }else if(position == 8){
            fragment_new = new StringsAsp();
            getActivity().setTitle("ASP");
            mf.navItemIndex = 2309;
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
        mf.navItemIndex = 23;

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