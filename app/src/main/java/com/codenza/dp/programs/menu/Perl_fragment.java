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
import com.codenza.dp.programs.csharp.sorting.SortingCS;
import com.codenza.dp.programs.csharp.strings.StringsCS;
import com.codenza.dp.programs.perl.array.ArrayPerl;
import com.codenza.dp.programs.perl.basics.BasicsPerl;
import com.codenza.dp.programs.perl.cgi.CgiPerl;
import com.codenza.dp.programs.perl.classperl.ClassPerl;
import com.codenza.dp.programs.perl.database.DatabasePerl;
import com.codenza.dp.programs.perl.datatype.DatatypePerl;
import com.codenza.dp.programs.perl.file.FilePerl;
import com.codenza.dp.programs.perl.gui.GuiPerl;
import com.codenza.dp.programs.perl.hash.HashPerl;
import com.codenza.dp.programs.perl.network.NetworkPerl;
import com.codenza.dp.programs.perl.re.RePerl;
import com.codenza.dp.programs.perl.report.ReportPerl;
import com.codenza.dp.programs.perl.statement.StatementPerl;
import com.codenza.dp.programs.perl.string.StringPerl;
import com.codenza.dp.programs.perl.subroutine.SubroutinePerl;
import com.codenza.dp.programs.perl.systemfunction.SystemfunctionPerl;
import com.codenza.dp.programs.perl.win32.Win32Perl;
import com.codenza.dp.programs.perl.xml.XmlPerl;


public class Perl_fragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    String[] spa_prog = {"Network", "Regular Expression", "CGI", "Win 32", "XML", "GUI","Subroutine","System Function","Data Type","Arrays","Class","File","Report","Database","Hash","Basics","Statement","String"};
    ListView listViewMenu;
    ArrayAdapter<String> menuAdapter;
    Fragment fragment_new;
    MainActivity mf;
    FloatingActionButton fab2;


    public Perl_fragment() {
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
            fragment_new = new NetworkPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2001;
        }else if(position == 1){
            fragment_new = new RePerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2002;
        }else if(position == 2){
            fragment_new = new CgiPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2003;
        }else if(position == 3){
            fragment_new = new Win32Perl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2004;
        }else if(position == 4){
            fragment_new = new XmlPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2005;
        }else if(position == 5){
            fragment_new = new GuiPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2006;
        }else if(position == 6){
            fragment_new = new SubroutinePerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2007;
        }else if(position==7){
            fragment_new = new SystemfunctionPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2008;
        }else if(position==8){
            fragment_new = new DatatypePerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2009;
        }else if(position==9){
            fragment_new = new ArrayPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2010;
        }else if(position==10){
            fragment_new = new ClassPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2011;
        }else if(position==11){
            fragment_new = new FilePerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2012;
        }else if(position==12){
            fragment_new = new ReportPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2013;
        }else if(position==13){
            fragment_new = new DatabasePerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2014;
        }else if(position==14){
            fragment_new = new HashPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2015;
        }else if(position==15){
            fragment_new = new BasicsPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2016;
        }else if(position==16){
            fragment_new = new StatementPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2017;
        }else if(position==17){
            fragment_new = new StringPerl();
            getActivity().setTitle("Perl Programs");
            mf.navItemIndex = 2018;
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
        mf.navItemIndex = 20;

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