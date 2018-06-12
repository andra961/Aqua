package com.example.andreacorronca.myapplicationtest;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);



        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sort_order_array, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        RadioButton name = findViewById(R.id.checkbox_sort_name);
        RadioButton price = findViewById(R.id.checkbox_sort_price);
        RadioButton usersVote = findViewById(R.id.checkbox_sort_usersVote);
        RadioButton metacritic = findViewById(R.id.checkbox_sort_metacritic);
        RadioButton discount = findViewById(R.id.checkbox_sort_discount);
        RadioButton nothing = findViewById(R.id.checkbox_sort_nothing);

        EditText minimumPrice = findViewById(R.id.minimum_price);
        EditText maximumPrice = findViewById(R.id.maximum_price);
        minimumPrice.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        maximumPrice.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        final AquaData app1 = (AquaData) getApplication();

        if (getIntent().getIntExtra("activity",0) == 1){
            app1.setMustRefreshSearch(true);
        }

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        FilterFragmentPagerAdapter adapter1 = new FilterFragmentPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter1);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


        Spinner spinnerFilter = (Spinner) findViewById(R.id.spinner_choose_filter);

        //(GenreFilterFragment) adapter1.getItem(0), (SettingFilterFragment) adapter1.getItem(1), (InfoFilterFragment) adapter1.getItem(2)


        ArrayAdapter<String> adp = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_dropdown_item,app1.getFilterSelection());
        // APP CURRENTLY CRASHING HERE
        spinnerFilter.setAdapter(adp);
        //Set listener Called when the item is selected in spinner
        spinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long arg3)
            {


                /*chargeFilter(app1.getCurrentFilter());
                FilterFragmentPagerAdapter adapter1 = new FilterFragmentPagerAdapter(getBaseContext(), getSupportFragmentManager());
                viewPager.setAdapter(adapter1);*/
                    /*if (app1.isPermitRefresh()){
                        finish();
                        startActivity(getIntent());
                    }*/


            }

            public void onNothingSelected(AdapterView<?> arg0)
            {
                // TODO Auto-generated method stub
            }
        });

        spinnerFilter.setSelection(app1.getFilters().indexOf(app1.getCurrentFilter()),false);




        /*minimumPrice.setText(""+ app1.getMinimumPrice());
        maximumPrice.setText(""+ app1.getMaximumPrice());*/

        minimumPrice.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                EditText minimumPrice = findViewById(R.id.minimum_price);

                AquaData app1 = (AquaData) getApplication();

                if ( minimumPrice.getText().length()>0){
                    app1.setMinimumPrice(Float.parseFloat(s.toString()));
                }

            }
        });

        maximumPrice.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                EditText maximumPrice = findViewById(R.id.maximum_price);

                AquaData app1 = (AquaData) getApplication();

                if ( maximumPrice.getText().length()>0){
                    app1.setMaximumPrice(Float.parseFloat(s.toString()));
                }
            }
        });

        minimumPrice.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // code to execute when EditText loses focus
                    EditText minimumPrice = findViewById(R.id.minimum_price);

                    AquaData app1 = (AquaData) getApplication();

                    if ( minimumPrice.getText().length()>0){
                    }
                    else {
                        minimumPrice.setText(""+0.0);
                        app1.setMinimumPrice(0.0F);
                    }
                }
            }
        });

        maximumPrice.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // code to execute when EditText loses focus
                    EditText maximumPrice = findViewById(R.id.maximum_price);

                    AquaData app1 = (AquaData) getApplication();

                    if (maximumPrice.getText().length()>0){

                    }
                    else {
                        maximumPrice.setText(""+0.0);
                        app1.setMaximumPrice(0.0F);
                    }
                }
            }
        });

        /*switch (app1.getSortOrder()){
            case 1:
                name.setChecked(true);
                break;
            case 2:
                price.setChecked(true);
                break;
            case 3:
                usersVote.setChecked(true);
                break;
            case 4:
                metacritic.setChecked(true);
                break;
            case 5:
                discount.setChecked(true);
                break;
            case 6:
                nothing.setChecked(true);
                break;
            default:
                break;
        }*/


        CheckBox checkBox = findViewById(R.id.checkbox_between_price);

       /* if(app1.isPriceRange()) checkBox.setChecked(true);
        else {
            minimumPrice.setEnabled(false);
            maximumPrice.setEnabled(false);
        }*/

        Spinner spinner = (Spinner) findViewById(R.id.spinner_sort_order);

        spinner.setAdapter(adapter);

        /*if(app1.isDescending()) spinner.setSelection(1);
        else spinner.setSelection(0);*/

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getApplication();
                app1.setDescending((pos == 1));

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Filter currentFilter = app1.getCurrentFilter();

        chargeFilter(currentFilter);
    }

    public void chargeFilter(Filter currentFilter){


        RadioButton name = findViewById(R.id.checkbox_sort_name);
        RadioButton price = findViewById(R.id.checkbox_sort_price);
        RadioButton usersVote = findViewById(R.id.checkbox_sort_usersVote);
        RadioButton metacritic = findViewById(R.id.checkbox_sort_metacritic);
        RadioButton discount = findViewById(R.id.checkbox_sort_discount);
        RadioButton nothing = findViewById(R.id.checkbox_sort_nothing);

        switch (currentFilter.getSortOrder()){
            case 1:
                name.setChecked(true);
                break;
            case 2:
                price.setChecked(true);
                break;
            case 3:
                usersVote.setChecked(true);
                break;
            case 4:
                metacritic.setChecked(true);
                break;
            case 5:
                discount.setChecked(true);
                break;
            case 6:
                nothing.setChecked(true);
                break;
            default:
                break;
        }

        EditText minimumPrice = findViewById(R.id.minimum_price);
        EditText maximumPrice = findViewById(R.id.maximum_price);

        minimumPrice.setText(""+ currentFilter.getMinimumPrice());
        maximumPrice.setText(""+ currentFilter.getMaximumPrice());

        CheckBox checkBox = findViewById(R.id.checkbox_between_price);

        if(currentFilter.isPriceRange()) checkBox.setChecked(true);
        else {
            minimumPrice.setEnabled(false);
            maximumPrice.setEnabled(false);
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinner_sort_order);

        if(currentFilter.isDescending()) spinner.setSelection(1);
        else spinner.setSelection(0,false);


        //View view = setting.getView();

        /*checkBox = view.findViewById(R.id.checkbox_futuristic);

        if(currentFilter.isShowFuturistic()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_actual);

        if(currentFilter.isShowActual()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_fantasy);

        if(currentFilter.isShowFantasy()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_horror);

        if(currentFilter.isShowHorror()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_war);

        if(currentFilter.isShowWar()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_past);

        if(currentFilter.isShowPast()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }*/



        /*view = genre.getView();

        checkBox = view.findViewById(R.id.checkbox_gdr);

        if(currentFilter.isShowGdr()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_action);

        if(currentFilter.isShowAction()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_survival);

        if(currentFilter.isShowSurvival()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_adventure);

        if(currentFilter.isShowAdventure()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_picchiaduro);

        if(currentFilter.isShowFighting()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_racing);

        if(currentFilter.isShowRacing()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_shooter);

        if(currentFilter.isShowShooter()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_strategy);

        if(currentFilter.isShowStrategy()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_platform);

        if(currentFilter.isShowPlatform()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_stealth);

        if(currentFilter.isShowStealth()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_carte);

        if(currentFilter.isShowCards()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_gestionale);

        if(currentFilter.isShowManagerial()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        view = info.getView();

        checkBox = view.findViewById(R.id.checkbox_single);

        if(currentFilter.isShowSingle()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_local);

        if(currentFilter.isShowLocal()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_online);

        if(currentFilter.isShowOnline()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_early_access);

        if(currentFilter.isShowEarly()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_free_to_play);

        if(currentFilter.isShowFree()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_standard);

        if(currentFilter.isShowStandard()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }*/
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        AquaData app1 = (AquaData) getApplication();
        switch (item.getItemId()) {
            case android.R.id.home:

                switch (getIntent().getIntExtra("activity",0)){
                    case 0:
                        CharSequence message = "filtro impostato";
                        Toast toast = Toast.makeText(this,message,message.length());
                        app1.setCurrentFilter(new Filter(app1.isDescending(),app1.getSortOrder(), app1.isShowGdr(),app1.isShowAction(),app1.isShowSurvival(),app1.isShowAdventure(),app1.isShowFighting(),app1.isShowRacing(),app1.isShowShooter(),app1.isShowStrategy(),app1.isShowPlatform(),app1.isShowStealth(),app1.isShowCards(),app1.isShowManagerial(),app1.isShowFuturistic(),app1.isShowActual(),app1.isShowFantasy(),app1.isShowHorror(),app1.isShowWar(),app1.isShowPast(),app1.isShowSingle(),app1.isShowLocal(),app1.isShowOnline(),app1.isShowFree(),app1.isShowEarly(),app1.isShowStandard(),app1.isPriceRange(),app1.getMinimumPrice(),app1.getMaximumPrice()));
                        toast.show();
                        finish();
                        break;

                    case 1:
                        app1.setCurrentFilter(new Filter(app1.isDescending(),app1.getSortOrder(), app1.isShowGdr(),app1.isShowAction(),app1.isShowSurvival(),app1.isShowAdventure(),app1.isShowFighting(),app1.isShowRacing(),app1.isShowShooter(),app1.isShowStrategy(),app1.isShowPlatform(),app1.isShowStealth(),app1.isShowCards(),app1.isShowManagerial(),app1.isShowFuturistic(),app1.isShowActual(),app1.isShowFantasy(),app1.isShowHorror(),app1.isShowWar(),app1.isShowPast(),app1.isShowSingle(),app1.isShowLocal(),app1.isShowOnline(),app1.isShowFree(),app1.isShowEarly(),app1.isShowStandard(),app1.isPriceRange(),app1.getMinimumPrice(),app1.getMaximumPrice()));
                        //Intent intent = new Intent(this, ShowResults.class);
                        //startActivity(intent);
                        finish();
                        break;
                }

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {

        AquaData app1 = (AquaData) getApplication();

        switch (getIntent().getIntExtra("activity",0)){



            case 0:
                CharSequence message = "filtro impostato";
                Toast toast = Toast.makeText(this,message,message.length());
                app1.setCurrentFilter(new Filter(app1.isDescending(),app1.getSortOrder(), app1.isShowGdr(),app1.isShowAction(),app1.isShowSurvival(),app1.isShowAdventure(),app1.isShowFighting(),app1.isShowRacing(),app1.isShowShooter(),app1.isShowStrategy(),app1.isShowPlatform(),app1.isShowStealth(),app1.isShowCards(),app1.isShowManagerial(),app1.isShowFuturistic(),app1.isShowActual(),app1.isShowFantasy(),app1.isShowHorror(),app1.isShowWar(),app1.isShowPast(),app1.isShowSingle(),app1.isShowLocal(),app1.isShowOnline(),app1.isShowFree(),app1.isShowEarly(),app1.isShowStandard(),app1.isPriceRange(),app1.getMinimumPrice(),app1.getMaximumPrice()));
                toast.show();
                finish();
                break;

            case 1:
                app1.setCurrentFilter(new Filter(app1.isDescending(),app1.getSortOrder(), app1.isShowGdr(),app1.isShowAction(),app1.isShowSurvival(),app1.isShowAdventure(),app1.isShowFighting(),app1.isShowRacing(),app1.isShowShooter(),app1.isShowStrategy(),app1.isShowPlatform(),app1.isShowStealth(),app1.isShowCards(),app1.isShowManagerial(),app1.isShowFuturistic(),app1.isShowActual(),app1.isShowFantasy(),app1.isShowHorror(),app1.isShowWar(),app1.isShowPast(),app1.isShowSingle(),app1.isShowLocal(),app1.isShowOnline(),app1.isShowFree(),app1.isShowEarly(),app1.isShowStandard(),app1.isPriceRange(),app1.getMinimumPrice(),app1.getMaximumPrice()));
                //Intent intent = new Intent(this, ShowResults.class);
                //startActivity(intent);
                finish();
                break;
        }
    }

    public void onCheckboxSortNameClicked(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData)getApplication();

        RadioButton price = findViewById(R.id.checkbox_sort_price);
        RadioButton usersVote = findViewById(R.id.checkbox_sort_usersVote);
        RadioButton metacritic = findViewById(R.id.checkbox_sort_metacritic);
        RadioButton discount = findViewById(R.id.checkbox_sort_discount);
        RadioButton nothing = findViewById(R.id.checkbox_sort_nothing);
        boolean checked = ((RadioButton) view).isChecked();
        if(checked){
            if (!nothing.isChecked() && !price.isChecked() && !usersVote.isChecked() && !discount.isChecked() && !metacritic.isChecked())
                ((RadioButton) view).setChecked(true);

            price.setChecked(false);
            usersVote.setChecked(false);
            metacritic.setChecked(false);
            discount.setChecked(false);
            nothing.setChecked(false);
            app1.setSortOrder(1);
        }
        else{
            app1.setSortOrder(0);
        }
    }

    public void onCheckboxSortPriceClicked(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData)getApplication();

        RadioButton name = findViewById(R.id.checkbox_sort_name);
        RadioButton usersVote = findViewById(R.id.checkbox_sort_usersVote);
        RadioButton metacritic = findViewById(R.id.checkbox_sort_metacritic);
        RadioButton discount = findViewById(R.id.checkbox_sort_discount);
        RadioButton nothing = findViewById(R.id.checkbox_sort_nothing);
        boolean checked = ((RadioButton) view).isChecked();
        if(checked){
            if (!name.isChecked() && !nothing.isChecked() && !usersVote.isChecked() && !discount.isChecked() && !metacritic.isChecked())
                ((RadioButton) view).setChecked(true);

            name.setChecked(false);
            usersVote.setChecked(false);
            metacritic.setChecked(false);
            discount.setChecked(false);
            nothing.setChecked(false);
            app1.setSortOrder(2);
        }
        else{
            app1.setSortOrder(0);
        }
    }

    public void onCheckboxSortUsersVoteClicked(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData)getApplication();

        RadioButton name = findViewById(R.id.checkbox_sort_name);
        RadioButton price = findViewById(R.id.checkbox_sort_price);
        RadioButton metacritic = findViewById(R.id.checkbox_sort_metacritic);
        RadioButton discount = findViewById(R.id.checkbox_sort_discount);
        RadioButton nothing = findViewById(R.id.checkbox_sort_nothing);
        boolean checked = ((RadioButton) view).isChecked();
        if(checked){
            if (!name.isChecked() && !price.isChecked() && !nothing.isChecked() && !discount.isChecked() && !metacritic.isChecked())
                ((RadioButton) view).setChecked(true);

            name.setChecked(false);
            price.setChecked(false);
            metacritic.setChecked(false);
            discount.setChecked(false);
            nothing.setChecked(false);
            app1.setSortOrder(3);
        }
        else{
            app1.setSortOrder(0);
        }
    }

    public void onCheckboxSortMetacriticClicked(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData)getApplication();

        RadioButton name = findViewById(R.id.checkbox_sort_name);
        RadioButton price = findViewById(R.id.checkbox_sort_price);
        RadioButton usersVote = findViewById(R.id.checkbox_sort_usersVote);
        RadioButton discount = findViewById(R.id.checkbox_sort_discount);
        RadioButton nothing = findViewById(R.id.checkbox_sort_nothing);
        boolean checked = ((RadioButton) view).isChecked();
        if(checked){
            if (!name.isChecked() && !price.isChecked() && !usersVote.isChecked() && !discount.isChecked() && !nothing.isChecked())
                ((RadioButton) view).setChecked(true);

            name.setChecked(false);
            price.setChecked(false);
            usersVote.setChecked(false);
            discount.setChecked(false);
            nothing.setChecked(false);
            app1.setSortOrder(4);
        }
        else{
            app1.setSortOrder(0);
        }
    }

    public void onCheckboxSortDiscountClicked(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData)getApplication();

        RadioButton name = findViewById(R.id.checkbox_sort_name);
        RadioButton price = findViewById(R.id.checkbox_sort_price);
        RadioButton usersVote = findViewById(R.id.checkbox_sort_usersVote);
        RadioButton metacritic = findViewById(R.id.checkbox_sort_metacritic);
        RadioButton nothing = findViewById(R.id.checkbox_sort_nothing);
        boolean checked = ((RadioButton) view).isChecked();
        if(checked){
            if (!name.isChecked() && !price.isChecked() && !usersVote.isChecked() && !nothing.isChecked() && !metacritic.isChecked())
                ((RadioButton) view).setChecked(true);

            name.setChecked(false);
            price.setChecked(false);
            usersVote.setChecked(false);
            metacritic.setChecked(false);
            nothing.setChecked(false);
            app1.setSortOrder(5);
        }
        else{
            app1.setSortOrder(0);
        }
    }

    public void onCheckboxSortNothingClicked(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData)getApplication();

        RadioButton name = findViewById(R.id.checkbox_sort_name);
        RadioButton price = findViewById(R.id.checkbox_sort_price);
        RadioButton usersVote = findViewById(R.id.checkbox_sort_usersVote);
        RadioButton discount = findViewById(R.id.checkbox_sort_discount);
        RadioButton metacritic = findViewById(R.id.checkbox_sort_metacritic);
        boolean checked = ((RadioButton) view).isChecked();
        if(checked){
            if (!name.isChecked() && !price.isChecked() && !usersVote.isChecked() && !discount.isChecked() && !metacritic.isChecked())
                ((RadioButton) view).setChecked(true);

            name.setChecked(false);
            price.setChecked(false);
            usersVote.setChecked(false);
            discount.setChecked(false);
            metacritic.setChecked(false);
            app1.setSortOrder(6);
        }
        else{
            app1.setSortOrder(0);
        }
    }


    public void onCheckboxActivatePriceRange(View view) {
        // Is the view now checked?

        EditText minimumPrice = findViewById(R.id.minimum_price);
        EditText maximumPrice = findViewById(R.id.maximum_price);
        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setPriceRange(true);
            minimumPrice.setEnabled(true);
            maximumPrice.setEnabled(true);
        } else {
            app1.setPriceRange(false);
            minimumPrice.setEnabled(false);
            maximumPrice.setEnabled(false);
        }

    }

    public void onCheckboxShowGdr(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowGdr(true);
        } else {
            app1.setShowGdr(false);
        }

    }

    public void onCheckboxShowAction(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowAction(true);
        } else {
            app1.setShowAction(false);
        }

    }

    public void onCheckboxShowSurvival(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowSurvival(true);
        } else {
            app1.setShowSurvival(false);
        }

    }

    public void onCheckboxShowAdventure(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowAdventure(true);
        } else {
            app1.setShowAdventure(false);
        }

    }

    public void onCheckboxShowFighting(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowFighting(true);
        } else {
            app1.setShowFighting(false);
        }

    }

    public void onCheckboxShowRacing(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowRacing(true);
        } else {
            app1.setShowRacing(false);
        }

    }

    public void onCheckboxShowShooter(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowShooter(true);
        } else {
            app1.setShowShooter(false);
        }

    }

    public void onCheckboxShowStrategy(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowStrategy(true);
        } else {
            app1.setShowStrategy(false);
        }

    }

    public void onCheckboxShowPlatform(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowPlatform(true);
        } else {
            app1.setShowPlatform(false);
        }

    }

    public void onCheckboxShowStealth(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowStealth(true);
        } else {
            app1.setShowStealth(false);
        }

    }

    public void onCheckboxShowCards(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowCards(true);
        } else {
            app1.setShowCards(false);
        }

    }

    public void onCheckboxShowManagerial(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowManagerial(true);
        } else {
            app1.setShowManagerial(false);
        }

    }

    public void onCheckboxShowFuturistic(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowFuturistic(true);
        } else {
            app1.setShowFuturistic(false);
        }

    }

    public void onCheckboxShowActual(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowActual(true);
        } else {
            app1.setShowActual(false);
        }

    }

    public void onCheckboxShowFantasy(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowFantasy(true);
        } else {
            app1.setShowFantasy(false);
        }

    }

    public void onCheckboxShowHorror(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowHorror(true);
        } else {
            app1.setShowHorror(false);
        }

    }

    public void onCheckboxShowWar(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowWar(true);
        } else {
            app1.setShowWar(false);
        }

    }

    public void onCheckboxShowPast(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowPast(true);
        } else {
            app1.setShowPast(false);
        }

    }

    public void onCheckboxShowSingle(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowSingle(true);
        } else {
            app1.setShowSingle(false);
        }

    }

    public void onCheckboxShowLocal(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowLocal(true);
        } else {
            app1.setShowLocal(false);
        }

    }

    public void onCheckboxShowOnline(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowOnline(true);
        } else {
            app1.setShowOnline(false);
        }

    }

    public void onCheckboxShowFree(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowFree(true);
        } else {
            app1.setShowFree(false);
        }

    }

    public void onCheckboxShowEarly(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowEarly(true);
        } else {
            app1.setShowEarly(false);
        }

    }

    public void onCheckboxShowStandard(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowStandard(true);
        } else {
            app1.setShowStandard(false);
        }

    }

    public void saveFilter(View view){
        FragmentManager fm = getFragmentManager();
        SaveFilterFragment dialogFragment = new SaveFilterFragment ();
        dialogFragment.show(fm, "Sample Fragment");
    }
}
