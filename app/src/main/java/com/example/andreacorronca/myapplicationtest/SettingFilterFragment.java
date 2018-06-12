package com.example.andreacorronca.myapplicationtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFilterFragment extends Fragment {


    public SettingFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting_filter, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        AquaData app1 = (AquaData) getActivity().getApplication();

        Filter currentFilter = app1.getCurrentFilter();

        CheckBox checkBox = view.findViewById(R.id.checkbox_futuristic);

        if(currentFilter.isShowFuturistic()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_actual);

        if(currentFilter.isShowActual()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_fantasy);

        if(currentFilter.isShowFantasy()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_horror);

        if(currentFilter.isShowHorror()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_war);

        if(currentFilter.isShowWar()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_past);

        if(currentFilter.isShowPast()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }
    }


    public void onCheckboxShowFuturistic(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowFuturistic(true);
        } else {
            app1.setShowFuturistic(false);
        }

    }

    public void onCheckboxShowActual(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowActual(true);
        } else {
            app1.setShowActual(false);
        }

    }

    public void onCheckboxShowFantasy(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowFantasy(true);
        } else {
            app1.setShowFantasy(false);
        }

    }

    public void onCheckboxShowHorror(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowHorror(true);
        } else {
            app1.setShowHorror(false);
        }

    }

    public void onCheckboxShowWar(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowWar(true);
        } else {
            app1.setShowWar(false);
        }

    }

    public void onCheckboxShowPast(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowPast(true);
        } else {
            app1.setShowPast(false);
        }

    }
}
