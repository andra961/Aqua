package com.example.andreacorronca.myapplicationtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {


    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.preferences_array, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AquaData app = (AquaData) getActivity().getApplication();

        Spinner futuristicSpinner = (Spinner) view.findViewById(R.id.futuristica_spinner);

        futuristicSpinner.setAdapter(adapter);

        futuristicSpinner.setSelection(app.getFuturisticPreference());

        futuristicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setFuturisticPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner actualSpinner = (Spinner) view.findViewById(R.id.attuale_spinner);

        actualSpinner.setAdapter(adapter);

        actualSpinner.setSelection(app.getActualPreference());

        actualSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setActualPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner fantasySpinner = (Spinner) view.findViewById(R.id.fantasy_spinner);

        fantasySpinner.setAdapter(adapter);

        fantasySpinner.setSelection(app.getFantasyPreference());

        fantasySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setFantasyPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner horrorSpinner = (Spinner) view.findViewById(R.id.horror_spinner);

        horrorSpinner.setAdapter(adapter);

        horrorSpinner.setSelection(app.getHorrorPreference());

        horrorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setHorrorPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner warSpinner = (Spinner) view.findViewById(R.id.guerra_spinner);

        warSpinner.setAdapter(adapter);

        warSpinner.setSelection(app.getWarPreference());

        warSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setWarPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner pastSpinner = (Spinner) view.findViewById(R.id.passato_spinner);

        pastSpinner.setAdapter(adapter);

        pastSpinner.setSelection(app.getPastPreference());

        pastSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setPastPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }
}
