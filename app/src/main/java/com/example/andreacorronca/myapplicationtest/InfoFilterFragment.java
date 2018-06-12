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
public class InfoFilterFragment extends Fragment {


    public InfoFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_filter, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        AquaData app1 = (AquaData) getActivity().getApplication();

        Filter currentFilter = app1.getCurrentFilter();

        CheckBox checkBox = view.findViewById(R.id.checkbox_single);

        if(currentFilter.isShowSingle()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_local);

        if(currentFilter.isShowLocal()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_online);

        if(currentFilter.isShowOnline()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_early_access);

        if(currentFilter.isShowEarly()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_free_to_play);

        if(currentFilter.isShowFree()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }

        checkBox = view.findViewById(R.id.checkbox_standard);

        if(currentFilter.isShowStandard()){
            checkBox.setChecked(true);
            checkBox.jumpDrawablesToCurrentState();
        }
        else{
            checkBox.setChecked(false);
            checkBox.jumpDrawablesToCurrentState();
        }
    }


    public void onCheckboxShowSingle(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowSingle(true);
        } else {
            app1.setShowSingle(false);
        }

    }

    public void onCheckboxShowLocal(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowLocal(true);
        } else {
            app1.setShowLocal(false);
        }

    }

    public void onCheckboxShowOnline(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowOnline(true);
        } else {
            app1.setShowOnline(false);
        }

    }

    public void onCheckboxShowFree(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowFree(true);
        } else {
            app1.setShowFree(false);
        }

    }

    public void onCheckboxShowEarly(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowEarly(true);
        } else {
            app1.setShowEarly(false);
        }

    }

    public void onCheckboxShowStandard(View view) {
        // Is the view now checked?

        AquaData app1 = (AquaData) getActivity().getApplication();

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            app1.setShowStandard(true);
        } else {
            app1.setShowStandard(false);
        }

    }
}
