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
import com.codenza.dp.programs.csharp.arrays.ArraysCS;
import com.codenza.dp.programs.csharp.basic.BasicCS;
import com.codenza.dp.programs.csharp.conversions.ConversionsCS;
import com.codenza.dp.programs.csharp.datastructure.DataStructureCS;
import com.codenza.dp.programs.csharp.delegate.DelegateCS;
import com.codenza.dp.programs.csharp.events.EventsCS;
import com.codenza.dp.programs.csharp.exception.ExceptionCS;
import com.codenza.dp.programs.csharp.files.FilesCS;
import com.codenza.dp.programs.csharp.functions.FunctionsCS;
import com.codenza.dp.programs.csharp.gamesthreads.GamesThreadsCS;
import com.codenza.dp.programs.csharp.inhertiance.InheritanceCS;
import com.codenza.dp.programs.csharp.linq.LinqCS;
import com.codenza.dp.programs.csharp.math.MathCS;
import com.codenza.dp.programs.csharp.matrix.MatrixCS;
import com.codenza.dp.programs.csharp.others.OthersCS;
import com.codenza.dp.programs.csharp.sorting.SortingCS;
import com.codenza.dp.programs.csharp.strings.StringsCS;
import com.codenza.dp.programs.python.list.ListPY;


public class CSharp_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] spa_prog = {"Basic", "Arrays", "Conversions", "Data Structures", "Delegates", "Events","Exceptions","Files","Functions","Games & Threads","Inheritance & Interface","LINQ","Math","Matrix","Sorting","Strings","Others"};
    ListView listViewMenu;
    ArrayAdapter<String> menuAdapter;
    Fragment fragment_new;
    MainActivity mf;
    FloatingActionButton fab2;


    public CSharp_fragment() {
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
            fragment_new = new BasicCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1901;
        }else if(position == 1){
            fragment_new = new ArraysCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1902;
        }else if(position == 2){
            fragment_new = new ConversionsCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1903;
        }else if(position == 3){
            fragment_new = new DataStructureCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1904;
        }else if(position == 4){
            fragment_new = new DelegateCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1905;
        }else if(position == 5){
            fragment_new = new EventsCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1906;
        }else if(position == 6){
            fragment_new = new ExceptionCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1907;
        }else if(position==7){
            fragment_new = new FilesCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1908;
        }else if(position==8){
            fragment_new = new FunctionsCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1909;
        }else if(position==9){
            fragment_new = new GamesThreadsCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1910;
        }else if(position==10){
            fragment_new = new InheritanceCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1911;
        }else if(position==11){
            fragment_new = new LinqCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1912;
        }else if(position==12){
            fragment_new = new MathCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1913;
        }else if(position==13){
            fragment_new = new MatrixCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1914;
        }else if(position==14){
            fragment_new = new SortingCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1915;
        }else if(position==15){
            fragment_new = new StringsCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1916;
        }else if(position==16){
            fragment_new = new OthersCS();
            getActivity().setTitle("C# Programs");
            mf.navItemIndex = 1917;
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
        mf.navItemIndex = 19;

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