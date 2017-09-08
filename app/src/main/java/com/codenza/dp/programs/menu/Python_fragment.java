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
import com.codenza.dp.programs.python.algo.AlgoPY;
import com.codenza.dp.programs.python.basic.BasicPY;
import com.codenza.dp.programs.python.date.DatePY;
import com.codenza.dp.programs.python.dictionary.DictPY;
import com.codenza.dp.programs.python.function.FunctPY;
import com.codenza.dp.programs.python.io.IOPY;
import com.codenza.dp.programs.python.list.ListPY;
import com.codenza.dp.programs.python.math.MathPY;
import com.codenza.dp.programs.python.misc.MiscPY;
import com.codenza.dp.programs.python.pyclass.ClassPY;
import com.codenza.dp.programs.python.re.REPY;
import com.codenza.dp.programs.python.sets.SetsPY;
import com.codenza.dp.programs.python.string.StringPY;
import com.codenza.dp.programs.python.tuple.TuplePY;


public class Python_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] spa_prog = {"Basic", "Class", "Dictionary", "Functions", "Input Output", "Algorithms","List","Miscellaneous","Sets","String","Tuple","Date & Time","Math","Regular Expression"," "};
    ListView listViewMenu;
    ArrayAdapter<String> menuAdapter;
    Fragment fragment_new;
    MainActivity mf;
    FloatingActionButton fab2;


    public Python_fragment() {
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
            fragment_new = new BasicPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1801;
        }else if(position == 1){
            fragment_new = new ClassPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1802;
        }else if(position == 2){
            fragment_new = new DictPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1803;
        }else if(position == 3){
            fragment_new = new FunctPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1804;
        }else if(position == 4){
            fragment_new = new IOPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1805;
        }else if(position == 5){
            fragment_new = new AlgoPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1806;
        }else if(position == 6){
            fragment_new = new ListPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1807;
        }else if(position==7){
            fragment_new = new MiscPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1808;
        }else if(position==8){
            fragment_new = new SetsPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1809;
        }else if(position==9){
            fragment_new = new StringPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1810;
        }else if(position==10){
            fragment_new = new TuplePY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1811;
        }else if(position==11){
            fragment_new = new DatePY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1812;
        }else if(position==12){
            fragment_new = new MathPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1813;
        }else if(position==13){
            fragment_new = new REPY();
            getActivity().setTitle("Python Programs");
            mf.navItemIndex = 1814;
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
        mf.navItemIndex = 18;

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