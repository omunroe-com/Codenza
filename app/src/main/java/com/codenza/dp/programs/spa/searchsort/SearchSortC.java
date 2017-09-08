package com.codenza.dp.programs.spa.searchsort;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.codenza.dp.programs.MainActivity;
import com.codenza.dp.programs.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.pddstudio.highlightjs.HighlightJsView;
import com.pddstudio.highlightjs.models.Language;
import com.pddstudio.highlightjs.models.Theme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SearchSortC extends Fragment implements AdapterView.OnItemClickListener,HighlightJsView.OnThemeChangedListener {
    TextView loc; HighlightJsView prog1;
    FloatingActionButton dwnCode, fab2;
    Snackbar snackbar; String entireFile;
    String dynamite;
    ArrayList<String> items = new ArrayList<String>();
    MainActivity mf;
    ListView listViewMenu;
    ArrayAdapter menuAdapter;
    View view,divider;
    EditText inputSearch;
    AdView mAdView; InterstitialAd mInterstitialAd;
    public SearchSortC(){
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mf.navItemIndex = 1;
        try {
            AssetManager assetManager = getActivity().getAssets();
            for (String file : assetManager.list("programs"+File.separator+"c"+File.separator+"searchsort")) {
                if (file.endsWith(".c"))
                    items.add(file.replaceAll(".c$", ""));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show_ads(){
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void openFolder()
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                + "/Codenza/C Programs/Search Sort/");
        intent.setDataAndType(uri, "text/csv");
        startActivity(Intent.createChooser(intent, "Open Folder Using"));
    }

    public void abcd(String str){
        mf.navItemIndex = 122;
        dynamite = str;
        BufferedReader br = null;
        String line;
        entireFile = "";
        /* String lineCount = ""; */
        int lineNumber = 0;
        try {
            br = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open("programs/c/searchsort/"+dynamite+".c"), "UTF-8"));
            // do reading, usually loop until end of file reading
            while ((line = br.readLine()) != null) {
                //process line
                /* lineNumber++; */
                entireFile += (line + "\n");
                /* lineCount += (lineNumber + "
"); */
            }
        } catch (IOException e) {
            //log the exception
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    //log the exception
                    e.printStackTrace();
                }
            }
        }
        prog1.setSource(entireFile);
        /* loc.setText(lineCount); */
        /* divider.setVisibility(View.VISIBLE); */
    }

    public void rem_list(){
        listViewMenu.setVisibility(View.GONE);
        inputSearch.setVisibility(View.GONE);
    }

    //Implementing Full Screen Ads.
    public void fs_ads(){
        mInterstitialAd = new InterstitialAd(getActivity().getApplicationContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-9035985973097881/2115752059");
        AdRequest adRequestInter = new AdRequest.Builder().build();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
            }
        });
        mInterstitialAd.loadAd(adRequestInter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.program_view, container, false);
        /* loc = (TextView) view.findViewById(R.id.loc); */
        /* divider = view.findViewById(R.id.divider); */
        /* loc.setVisibility(View.GONE); */
        /* divider.setVisibility(View.GONE); */

        prog1 = (HighlightJsView) view.findViewById(R.id.prog1);
        onThemeChanged(Theme.MONOKAI_SUBLIME);
        prog1.setOnThemeChangedListener(this);
        prog1.setHighlightLanguage(Language.C);
        prog1.setZoomSupportEnabled(true);
        prog1.setShowLineNumbers(true);

        mAdView = (AdView) view.findViewById(R.id.adView);
        prog1.setVisibility(View.GONE);
        dwnCode = (FloatingActionButton) view.findViewById(R.id.dwnCode);
        dwnCode.setVisibility(View.GONE);
        listViewMenu = (ListView) view.findViewById(R.id.listView);
        menuAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items);
        listViewMenu.setAdapter(menuAdapter);
        listViewMenu.setOnItemClickListener(this);
        inputSearch = (EditText) view.findViewById(R.id.etSearchBar);
        inputSearch.setHint("Search");
        inputSearch.clearFocus();
        inputSearch.setBackgroundColor(Color.parseColor("#000000"));
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                menuAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dwnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fs_ads();
                File sdCard = Environment.getExternalStorageDirectory();
                String loc = sdCard.getAbsolutePath()+"/Codenza/C Programs/Search Sort";
                File directory = new File(loc);
                directory.mkdirs();
                mf.navItemIndex = 122;
                try {
                    //Now create the file in the above directory and write the contents into it
                    File file = new File(directory, dynamite+".txt");
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    String strFileData = entireFile;
                    osw.write(strFileData);
                    osw.flush();
                    osw.close();
                    snackbar = Snackbar
                            .make(getView(), "Saved to "+loc, Snackbar.LENGTH_INDEFINITE)
                            .setAction("Dismiss", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    snackbar.dismiss();
                                }
                            });

                    // Changing message text color
                    snackbar.setActionTextColor(Color.WHITE);

                    // Changing action button text color
                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.WHITE);
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    Button bDismiss = (Button) sbView.findViewById(android.support.design.R.id.snackbar_action);
                    bDismiss.setBackgroundColor(Color.BLACK);
                    textView.setTextColor(Color.BLACK);
                    snackbar.show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
        fab2 = (FloatingActionButton) view.findViewById(R.id.fab2);
        fab2.setVisibility(View.GONE);
        show_ads();
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selected_item_list = listViewMenu.getItemAtPosition(position).toString();
        String passsingString = selected_item_list;
        if(position != -1){
            rem_list();
            prog1.setVisibility(View.VISIBLE);
            abcd(passsingString);
            prog1.setVisibility(View.VISIBLE);
            /* loc.setVisibility(View.VISIBLE); */
            /* divider.setVisibility(View.VISIBLE); */
            //Disabling Keyboard
            gayab_keyboard();
            dwnCode.setVisibility(View.VISIBLE);
            show_ads();
        }
    }
    public void gayab_keyboard(){
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    @Override
    public void onThemeChanged(@NonNull Theme theme) {
        //change theme and set language to auto detect
        prog1.setTheme(Theme.MONOKAI_SUBLIME);
    }

}
