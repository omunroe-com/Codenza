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
import com.codenza.dp.programs.html.basics.HtmlBasics;
import com.codenza.dp.programs.html.form.HTMLForm;
import com.codenza.dp.programs.html.rendering.HtmlRendering;
import com.codenza.dp.programs.html.table.HtmlTable;
import com.codenza.dp.programs.html.tags.HtmlTags;
import com.codenza.dp.programs.html.text.HtmlText;

public class HTML_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] dsf_prog = {"Basics", "Forms", "Rendering Techniques", "Semantic Tags","Table","Text"};
    ListView listViewMenu1;
    ArrayAdapter<String> menuAdapter;
    MainActivity mf;
    FloatingActionButton fab2;
    public HTML_fragment() {
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
                fragment_new = new HtmlBasics();
                getActivity().setTitle("HTML Programs");
                mf.navItemIndex = 2401;
            }else if(position == 1){
                fragment_new = new HTMLForm();
                getActivity().setTitle("HTML Programs");
                mf.navItemIndex = 2402;
            }else if(position == 2){
                fragment_new = new HtmlRendering();
                getActivity().setTitle("HTML Programs");
                mf.navItemIndex = 2403;
            }else if(position == 3){
                fragment_new = new HtmlTable();
                getActivity().setTitle("HTML Programs");
                mf.navItemIndex = 2404;
            }else if(position == 4){
                fragment_new = new HtmlTags();
                getActivity().setTitle("HTML Programs");
                mf.navItemIndex = 2405;
            }else if(position == 5){
                fragment_new = new HtmlText();
                getActivity().setTitle("HTML Programs");
                mf.navItemIndex = 2406;
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
        mf.navItemIndex = 24;

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
