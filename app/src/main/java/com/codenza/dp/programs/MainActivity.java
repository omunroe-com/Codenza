package com.codenza.dp.programs;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codenza.dp.programs.asp.active.ActiveAsp;
import com.codenza.dp.programs.asp.code.CodeAsp;
import com.codenza.dp.programs.asp.components.ComponentsAsp;
import com.codenza.dp.programs.asp.data.DataAsp;
import com.codenza.dp.programs.asp.files.FilesAsp;
import com.codenza.dp.programs.asp.misc.MiscAsp;
import com.codenza.dp.programs.asp.others.OthersAsp;
import com.codenza.dp.programs.asp.sessions.SessionsAsp;
import com.codenza.dp.programs.asp.strings.StringsAsp;
import com.codenza.dp.programs.cpp.combinationalcpp.CombinationalCPP;
import com.codenza.dp.programs.cpp.computationalcpp.ComputationalCPP;
import com.codenza.dp.programs.cpp.hdcpp.HardGraphCPP;
import com.codenza.dp.programs.cpp.introcpp.IntroCPP;
import com.codenza.dp.programs.cpp.numericalcpp.NumericalCPP;
import com.codenza.dp.programs.cpp.others.OtherCPP;
import com.codenza.dp.programs.cpp.overviewcpp.OverviewCPP;
import com.codenza.dp.programs.cpp.setstringscpp.SetsStringsCPP;
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
import com.codenza.dp.programs.dsf.basics.Basics;
import com.codenza.dp.programs.dsf.graphs.Graphs;
import com.codenza.dp.programs.dsf.linked_lists.LinkedLists;
import com.codenza.dp.programs.dsf.stack_queues.StacksQueues;
import com.codenza.dp.programs.html.basics.HtmlBasics;
import com.codenza.dp.programs.html.form.HTMLForm;
import com.codenza.dp.programs.html.rendering.HtmlRendering;
import com.codenza.dp.programs.html.table.HtmlTable;
import com.codenza.dp.programs.html.tags.HtmlTags;
import com.codenza.dp.programs.html.text.HtmlText;
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
import com.codenza.dp.programs.menu.AOA_fragment;
import com.codenza.dp.programs.menu.ASP_fragment;
import com.codenza.dp.programs.menu.Assembly_fragment;
import com.codenza.dp.programs.menu.CG_fragment;
import com.codenza.dp.programs.menu.CPP_fragment;
import com.codenza.dp.programs.menu.CSSS_fragment;
import com.codenza.dp.programs.menu.CSharp_fragment;
import com.codenza.dp.programs.menu.DSF_fragment;
import com.codenza.dp.programs.menu.HTML_fragment;
import com.codenza.dp.programs.menu.Javascript_fragment;
import com.codenza.dp.programs.menu.OOPM_fragment;
import com.codenza.dp.programs.menu.PHP_fragment;
import com.codenza.dp.programs.menu.Perl_fragment;
import com.codenza.dp.programs.menu.Python_fragment;
import com.codenza.dp.programs.menu.RUBY_fragment;
import com.codenza.dp.programs.menu.SPA_fragment;
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
import com.codenza.dp.programs.php.algo.AlgoPhp;
import com.codenza.dp.programs.php.arrays.ArraysPHP;
import com.codenza.dp.programs.php.basic.BasicPHP;
import com.codenza.dp.programs.php.math.MathPHP;
import com.codenza.dp.programs.php.sorting.SortingPHP;
import com.codenza.dp.programs.php.string.StringPHP;
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
import com.codenza.dp.programs.ruby.algo.RubyAlgo;
import com.codenza.dp.programs.ruby.arrays.RubyArrays;
import com.codenza.dp.programs.ruby.basics.RubyBasics;
import com.codenza.dp.programs.ruby.ds.RubyDs;
import com.codenza.dp.programs.ruby.patterns.RubyPatterns;
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
import com.facebook.CallbackManager;
import com.facebook.share.widget.LikeView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static String TAG = null;
    TextView tv1, tv2, tv3;
    Button bStart;
    Fragment fragment;
    Fragment li_fragment;
    FloatingActionButton fab;
    SharedPreferences prefs = null;
    public static int navItemIndex = 0;

    LinearLayout btnLoginToLike;
    LikeView likeView;
    CallbackManager callbackManager;
    WebView webView;
    private GoogleApiClient client;
    // tags used to attach the fragments

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView img = new TextView(this);

        prefs = getSharedPreferences("Codenza", MODE_PRIVATE);
        init();
        //generate_key_hash();
        isStoragePermissionGranted();
        //FaceBook Like View

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

   /* public void generate_key_hash(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.codenza.dp.programs",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }*/

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {
                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            File sdCard = Environment.getExternalStorageDirectory();
            String loc = sdCard.getAbsolutePath() + "/Codenza/";
            File directory = new File(loc);
            directory.mkdirs();
            // using the following line to edit/commit prefs
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            System.out.println("drawer " + getSupportFragmentManager().getBackStackEntryCount());
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            if ((navItemIndex == 1111) || (navItemIndex == 2222) || (navItemIndex == 3333) || (navItemIndex == 4444) ) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }else {
                System.out.println("hello " + navItemIndex);
                fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_main, fragment)
                        .addToBackStack(null)
                        .commit();
            }

        } else if((navItemIndex == 1111) || (navItemIndex == 2222) || (navItemIndex == 3333) || (navItemIndex == 4444)){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else {
            System.out.println("final else ");
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MainActivity.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("Stay!", null)
                    .setTitle("Confirm Response")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        remove_layout();
        li_fragment = null;

        if (id == R.id.content_main) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (id == R.id.about) {
            li_fragment = new About();
            navItemIndex = 1111;
        } else if (id == R.id.request) {
            li_fragment = new Request();
            navItemIndex = 2222;
        } else if (id == R.id.help) {
            li_fragment = new Help();
            navItemIndex = 3333;
        } else if (id == R.id.explan) {
                Intent myIntent = new Intent(MainActivity.this, CustomTabs.class);
                startActivity(myIntent);
                navItemIndex = 4444;
        }

        if (li_fragment != null) {
            final FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_main, li_fragment)
                    .addToBackStack(null)
                    .commit();
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void codenzawebsite (View view) {
        goToUrl ( "http://codenza.us/");
    }
    public void facebookpage (View view) {
        goToUrl ( "https://facebook.com/codenza/");
    }
    public void howto (View view) {
        goToUrl ( "http://codenza.us/how-to-run/");
    }
    public void gplus (View view) {
        goToUrl ( "https://plus.google.com/+CodenzaUs/");
    }
    public void ttg (View view) { goToUrl ( "http://thetechiesguide.com"); }
    public void init() {


        bStart = (Button) findViewById(R.id.buttonstart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Share Button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.codenza.dp.programs");
                intent.setType("text/plain");
                startActivity(intent);

            }
        });

        // Start Button
        final Button button = (Button) findViewById(R.id.buttonstart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Perform
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(Gravity.LEFT);
            }
        });


        final   Button aboutbutton = (Button) findViewById(R.id.about);
        aboutbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navItemIndex = 1111;
                FragmentManager fm = getSupportFragmentManager();
                About fragment = new About();
                fm.beginTransaction().add(R.id.content_main,fragment).commit();

            }
        });

        final   Button requestbutton = (Button) findViewById(R.id.request);
        requestbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                navItemIndex = 2222;
                FragmentManager fm = getSupportFragmentManager();
                Request fragment = new Request();
                fm.beginTransaction().add(R.id.content_main,fragment).commit();
            }
        });

        final   Button helpbutton = (Button) findViewById(R.id.help);
        helpbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                navItemIndex = 3333;
                FragmentManager fm = getSupportFragmentManager();
                Help fragment = new Help();
                fm.beginTransaction().add(R.id.content_main,fragment).commit();
            }
        });

        final   Button explanbutton = (Button) findViewById(R.id.explan);
        explanbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                navItemIndex = 4444;
                /*FragmentManager fm = getSupportFragmentManager();
                Explanations fragment = new Explanations();
                fm.beginTransaction().add(R.id.content_main,fragment).commit();*/
                Intent myIntent = new Intent(MainActivity.this, CustomTabs.class);
                startActivity(myIntent);
            }
        });

        final Button pro = (Button) findViewById(R.id.pro);
        pro.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.codenza.programs.pro")));
            }
        });

        final Button rateapp = (Button) findViewById(R.id.rate);
        rateapp.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.codenza.dp.programs")));
            }
        });

        // Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Welcome text 1 - <Code/>


        LikeView likeView = (LikeView) findViewById(R.id.likeView);
        likeView.setObjectIdAndType(
                "https://www.facebook.com/Codenza",
                LikeView.ObjectType.PAGE);
    }

    public void remove_layout() {

        bStart.setVisibility(View.GONE);
        fab.setVisibility(View.GONE);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        fragment = null;
        remove_layout();
        if (id == R.id.nav_spa) {
            setTitle("C Programs");
            fragment = new SPA_fragment();
            navItemIndex = 1;
        } else if (id == R.id.nav_oopm) {
            setTitle("Java (OOPM)");
            fragment = new OOPM_fragment();
            navItemIndex = 2;
        } else if (id == R.id.nav_cpp) {
            setTitle("C++");
            fragment = new CPP_fragment();
            navItemIndex = 3;
        } else if (id == R.id.nav_dsf) {
            setTitle("Data Structures - C");
            fragment = new DSF_fragment();
            navItemIndex = 4;
        } else if (id == R.id.nav_aoa) {
            setTitle("Algorithms");
            fragment = new AOA_fragment();
            navItemIndex = 5;
        } else if (id == R.id.nav_cg) {
            setTitle("Computer Graphics");
            fragment = new CG_fragment();
            navItemIndex = 6;
        } else if(id== R.id.js){
            setTitle("Javascript");
            fragment = new Javascript_fragment();
            navItemIndex = 16;
        } else if (id == R.id.nav_php) {
            setTitle("PHP");
            fragment = new PHP_fragment();
            navItemIndex = 17;
        } else if (id == R.id.nav_py) {
            setTitle("Python");
            fragment = new Python_fragment();
            navItemIndex = 18;
        } else if (id == R.id.nav_cs) {
            setTitle("C#");
            fragment = new CSharp_fragment();
            navItemIndex = 19;
        } else if (id == R.id.nav_perl) {
            setTitle("Perl");
            fragment = new Perl_fragment();
            navItemIndex = 20;
        }else if (id == R.id.csss) {
            setTitle("CSS");
            fragment = new CSSS_fragment();
            navItemIndex = 21;
        }else if (id == R.id.af) {
            setTitle("Assembly");
            fragment = new Assembly_fragment();
            navItemIndex = 22;
        }else if (id == R.id.asp) {
            setTitle("ASP");
            fragment = new ASP_fragment();
            navItemIndex = 23;
        }else if (id == R.id.nav_html) {
            setTitle("HTML");
            fragment = new HTML_fragment();
            navItemIndex = 24;
        }else if (id == R.id.nav_ruby) {
            setTitle("Ruby");
            fragment = new RUBY_fragment();
            navItemIndex = 25;
        } else if (id == R.id.content_main) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_main, fragment)
                    .addToBackStack(null)
                    .commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 1:
                System.out.println("here");
                SPA_fragment spa = new SPA_fragment();
                return spa;
            case 111:
                BasicC bc = new BasicC();
                return bc;
            case 112:
                ControlStatements spacontrol = new ControlStatements();
                return spacontrol;
            case 113:
                DataIPandOP spadata = new DataIPandOP();
                return spadata;
            case 114:
                Functions spafunctions = new Functions();
                return spafunctions;
            case 115:
                PatternPrograms spapattern = new PatternPrograms();
                return spapattern;
            case 116:
                SeriesPrograms spaseriers = new SeriesPrograms();
                return spaseriers;
            case 117:
                StructuresUnions spastructures = new StructuresUnions();
                return spastructures;
            case 118:
                matrix m = new matrix();
                return m;
            case 119:
                bitwise bw = new bitwise();
                return bw;
            case 120:
                NumericalC nc = new NumericalC();
                return nc;
            case 121:
                RecursionC rc = new RecursionC();
                return rc;
            case 122:
                SearchSortC ss = new SearchSortC();
                return ss;
            case 123:
                ArraysC spaarrays = new ArraysC();
                return spaarrays;
            case 124:
                StringC sc = new StringC();
                return sc;
            case 125:
                Wrecursion wr = new Wrecursion();
                return wr;

            case 2:
                OOPM_fragment oopm = new OOPM_fragment();
                return oopm;
            case 211:
                BasicsJava bjava = new BasicsJava();
                return bjava;
            case 212:
                NumericalJava njava = new NumericalJava();
                return njava;
            case 213:
                SearchingSortingJava ssjava = new SearchingSortingJava();
                return ssjava;
            case 214:
                GraphJava gjava = new GraphJava();
                return gjava;
            case 215:
                HardGraphJava hgjava = new HardGraphJava();
                return hgjava;
            case 216:
                ComputationalJava cjava = new ComputationalJava();
                return cjava;
            case 217:
                DsJava dsjava = new DsJava();
                return dsjava;
            case 218:
                ApiJava apijava = new ApiJava();
                return apijava;
            case 219:
                CgJava cgjava = new CgJava();
                return cgjava;
            case 220:
                CoreJava cjv = new CoreJava();
                return cjv;
            case 221:
                AppletAwtJava aaj = new AppletAwtJava();
                return aaj;
            case 222:
                XmlJava xmlj = new XmlJava();
                return xmlj;
            case 223:
                ServletsSessionSwingUtilJava sssj = new ServletsSessionSwingUtilJava();
                return sssj;

            case 3:
                CPP_fragment cpp = new CPP_fragment();
                return cpp;
            case 311:
                OverviewCPP ocpp = new OverviewCPP();
                return ocpp;
            case 312:
                IntroCPP icpp = new IntroCPP();
                return icpp;
            case 313:
                NumericalCPP ncpp = new NumericalCPP();
                return ncpp;
            case 314:
                CombinationalCPP combcpp = new CombinationalCPP();
                return combcpp;
            case 315:
                ComputationalCPP compcpp = new ComputationalCPP();
                return compcpp;
            case 316:
                HardGraphCPP hgcpp = new HardGraphCPP();
                return hgcpp;
            case 317:
                SetsStringsCPP sscpp = new SetsStringsCPP();
                return sscpp;
            case 318:
                OtherCPP otcpp = new OtherCPP();
                return otcpp;

            case 4:
                DSF_fragment dsf = new DSF_fragment();
                return dsf;
            case 411:
                Basics basic = new Basics();
                return basic;
            case 412:
                Graphs graphs = new Graphs();
                return graphs;
            case 413:
                LinkedLists ll = new LinkedLists();
                return ll;
            case 414:
                StacksQueues sq = new StacksQueues();
                return sq;

            case 5:
                AOA_fragment aoa = new AOA_fragment();
                return aoa;

            case 6:
                CG_fragment cg = new CG_fragment();
                return cg;

            case 16:
                Javascript_fragment js = new Javascript_fragment();
                return js;
            case 1600:
                JsAlgo jsalgo = new JsAlgo();
                return jsalgo;
            case 1601:
                JsArray jsarray = new JsArray();
                return jsarray;
            case 1602:
                JsBasic jbc = new JsBasic();
                return jbc;
            case 1603:
                JsConditional jsc = new JsConditional();
                return jsc;
            case 1604:
                JsDate jds = new JsDate();
                return  jds;
            case 1605:
                JsDrawing jsdr = new JsDrawing();
                return jsdr;
            case 1606:
                JsFunctions jsf = new JsFunctions();
                return jsf;
            case 1607:
                JsHtmldom jsht = new JsHtmldom();
                return jsht;
            case 1608:
                JsMath jsm = new JsMath();
                return jsm;
            case 1609:
                JsObject jso = new JsObject();
                return jso;
            case 1610:
                JsRecursion jsr = new JsRecursion();
                return jsr;
            case 1611:
                JsString jss = new JsString();
                return jss;
            case 1612:
                JsWRE jsv = new JsWRE();
                return  jsv;
            case 1613:
                JsWORE jsvw = new JsWORE();
                return jsvw;
            case 1614:
                JsOthers jsot = new JsOthers();
                return jsot;

            case 17:
                PHP_fragment php = new PHP_fragment();
                return php;
            case 1701:
                BasicPHP bphp = new BasicPHP();
                return bphp;
            case 1702:
                ArraysPHP aphp = new ArraysPHP();
                return aphp;
            case 1703:
                MathPHP mphp = new MathPHP();
                return mphp;
            case 1704:
                SortingPHP sphp = new SortingPHP();
                return sphp;
            case 1705:
                StringPHP stphp = new StringPHP();
                return stphp;
            case 1706:
                AlgoPhp alphp = new AlgoPhp();
                return alphp;


            case 18:
                Python_fragment py = new Python_fragment();
                return py;

            case 1801:
                BasicPY bpy = new BasicPY();
                return bpy;

            case 1802:
                ClassPY cpy = new ClassPY();
                return cpy;

            case 1803:
                DictPY dpy = new DictPY();
                return dpy;

            case 1804:
                FunctPY fpy = new FunctPY();
                return fpy;

            case 1805:
                IOPY iopy = new IOPY();
                return iopy;

            case 1806:
                AlgoPY apy = new AlgoPY();
                return apy;

            case 1807:
                ListPY lpy = new ListPY();
                return lpy;

            case 1808:
                MiscPY mpy = new MiscPY();
                return mpy;

            case 1809:
                SetsPY spy = new SetsPY();
                return spy;

            case 1810:
                StringPY stpy = new StringPY();
                return stpy;

            case 1811:
                TuplePY tpy = new TuplePY();
                return tpy;

            case 1812:
                DatePY dapy = new DatePY();
                return dapy;

            case 1813:
                MathPY mapy = new MathPY();
                return mapy;

            case 1814:
                REPY repy = new REPY();
                return repy;

            case 19:
                CSharp_fragment cs = new CSharp_fragment();
                return cs;
            case 1901:
                BasicCS bsc = new BasicCS();
                return bsc;
            case 1902:
                ArraysCS acs = new ArraysCS();
                return acs;
            case 1903:
                ConversionsCS ccs = new ConversionsCS();
                return ccs;
            case 1904:

                DataStructureCS dscs = new DataStructureCS();
                return dscs;
            case 1905:
                DelegateCS dcs = new DelegateCS();
                return dcs;
            case 1906:
                EventsCS ecs = new EventsCS();
                return ecs;
            case 1907:
                ExceptionCS ecs1 = new ExceptionCS();
                return ecs1;
            case 1908:
                FilesCS fcs = new FilesCS();
                return fcs;
            case 1909:
                FunctionsCS fucs = new FunctionsCS();
                return fucs;
            case 1910:
                GamesThreadsCS gcs = new GamesThreadsCS();
                return gcs;
            case 1911:
                InheritanceCS ics = new InheritanceCS();
                return ics;
            case 1912:
                LinqCS lcs = new LinqCS();
                return lcs;
            case 1913:
                MathCS mcs = new MathCS();
                return mcs;
            case 1914:
                MatrixCS macs = new MatrixCS();
                return macs;
            case 1915:
                SortingCS scs = new SortingCS();
                return scs;
            case 1916:
                StringsCS stcs = new StringsCS();
                return stcs;
            case 1917:
                OthersCS ocs = new OthersCS();
                return ocs;

            case 20:
                Perl_fragment pfg = new Perl_fragment();
                return pfg;
            case 2001:
                NetworkPerl npl = new NetworkPerl();
                return npl;
            case 2002:
                RePerl repl = new RePerl();
                return repl;
            case 2003:
                CgiPerl cpl = new CgiPerl();
                return cpl;
            case 2004:
                Win32Perl wpl = new Win32Perl();
                return wpl;
            case 2005:
                XmlPerl xpl = new XmlPerl();
                return xpl;
            case 2006:
                GuiPerl gpl = new GuiPerl();
                return gpl;
            case 2007:
                SubroutinePerl spl = new SubroutinePerl();
                return spl;
            case 2008:
                SystemfunctionPerl sfpl = new SystemfunctionPerl();
                return sfpl;
            case 2009:
                DatatypePerl dtpl = new DatatypePerl();
                return dtpl;
            case 2010:
                ArrayPerl apl = new ArrayPerl();
                return apl;
            case 2011:
                ClassPerl clpl = new ClassPerl();
                return clpl;
            case 2012:
                FilePerl fpl = new FilePerl();
                return fpl;
            case 2013:
                ReportPerl rpl = new ReportPerl();
                return rpl;
            case 2014:
                DatabasePerl dbpl = new DatabasePerl();
                return dbpl;
            case 2015:
                HashPerl hpl = new HashPerl();
                return hpl;
            case 2016:
                BasicsPerl bpl = new BasicsPerl();
                return bpl;
            case 2017:
                StatementPerl stpl = new StatementPerl();
                return stpl;
            case 2018:
                StringPerl srpl = new StringPerl();
                return srpl;
            case 5555:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            case 21:
                CSSS_fragment csss = new CSSS_fragment();
                return csss;
            case 22:
                Assembly_fragment af = new Assembly_fragment();
                return af;
            case 23:
                ASP_fragment aspf = new ASP_fragment();
                return aspf;
            case 2301:
                ActiveAsp aasp = new ActiveAsp();
                return aasp;
            case 2302:
                ComponentsAsp casp = new ComponentsAsp();
                return casp;
            case 2303:
                DataAsp dasp = new DataAsp();
                return dasp;
            case 2304:
                FilesAsp fasp = new FilesAsp();
                return fasp;
            case 2305:
                MiscAsp masp = new MiscAsp();
                return masp;
            case 2306:
                CodeAsp coasp = new CodeAsp();
                return coasp;
            case 2307:
                OthersAsp ooasp = new OthersAsp();
                return ooasp;
            case 2308:
                SessionsAsp sasp = new SessionsAsp();
                return sasp;
            case 2309:
                StringsAsp stasp = new StringsAsp();
                return stasp;

            case 24:
                HTML_fragment html = new HTML_fragment();
                return html;
            case 2401:
                HtmlBasics htmlba = new HtmlBasics();
                return htmlba;
            case 2402:
                 HTMLForm htmlfo = new HTMLForm();
                 return htmlfo;
            case 2403:
                HtmlRendering htmlr = new HtmlRendering();
                return htmlr;
            case 2404:
                HtmlTable htmlt = new HtmlTable();
                return htmlt;
            case 2405:
                HtmlTags htmlta = new HtmlTags();
                return htmlta;
            case 2406:
                HtmlText htmlte = new HtmlText();
                return htmlte;

            case 25:
                RUBY_fragment ruby = new RUBY_fragment();
                return ruby;
            case 2501:
                RubyBasics ruby1 = new RubyBasics();
                return ruby1;
            case 2502:
                RubyArrays ruby2 = new RubyArrays();
                return ruby2;
            case 2503:
                RubyAlgo ruby3 = new RubyAlgo();
                return ruby3;
            case 2504:
                RubyDs ruby4 = new RubyDs();
                return ruby4;
            case 2505:
                RubyPatterns ruby5 = new RubyPatterns();
                return ruby5;

                default:
                return new SPA_fragment();
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}