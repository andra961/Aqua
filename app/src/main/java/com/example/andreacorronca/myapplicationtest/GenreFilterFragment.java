package com.example.andreacorronca.myapplicationtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 */
public class GenreFilterFragment extends Fragment {


    public GenreFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre_filter, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        AquaData app1 = (AquaData) getActivity().getApplication();

        Filter currentFilter = app1.getCurrentFilter();

        CheckBox checkBox = view.findViewById(R.id.checkbox_gdr);

        if(currentFilter.isShowGdr()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_action);

        if(currentFilter.isShowAction()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_survival);

        if(currentFilter.isShowSurvival()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_adventure);

        if(currentFilter.isShowAdventure()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_picchiaduro);

        if(currentFilter.isShowFighting()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_racing);

        if(currentFilter.isShowRacing()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_shooter);

        if(currentFilter.isShowShooter()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_strategy);

        if(currentFilter.isShowStrategy()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_platform);

        if(currentFilter.isShowPlatform()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_stealth);

        if(currentFilter.isShowStealth()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_carte);

        if(currentFilter.isShowCards()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_gestionale);

        if(currentFilter.isShowManagerial()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }
    }

    public void onCheckboxShowGdr(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowGdr(true);
        } else {
            app1.setShowGdr(false);
        }

    }

    public void onCheckboxShowAction(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowAction(true);
        } else {
            app1.setShowAction(false);
        }

    }

    public void onCheckboxShowSurvival(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowSurvival(true);
        } else {
            app1.setShowSurvival(false);
        }

    }

    public void onCheckboxShowAdventure(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowAdventure(true);
        } else {
            app1.setShowAdventure(false);
        }

    }

    public void onCheckboxShowFighting(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowFighting(true);
        } else {
            app1.setShowFighting(false);
        }

    }

    public void onCheckboxShowRacing(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowRacing(true);
        } else {
            app1.setShowRacing(false);
        }

    }

    public void onCheckboxShowShooter(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowShooter(true);
        } else {
            app1.setShowShooter(false);
        }

    }

    public void onCheckboxShowStrategy(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowStrategy(true);
        } else {
            app1.setShowStrategy(false);
        }

    }

    public void onCheckboxShowPlatform(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowPlatform(true);
        } else {
            app1.setShowPlatform(false);
        }

    }

    public void onCheckboxShowStealth(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowStealth(true);
        } else {
            app1.setShowStealth(false);
        }

    }

    public void onCheckboxShowCards(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowCards(true);
        } else {
            app1.setShowCards(false);
        }

    }

    public void onCheckboxShowManagerial(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowManagerial(true);
        } else {
            app1.setShowManagerial(false);
        }

    }


}
