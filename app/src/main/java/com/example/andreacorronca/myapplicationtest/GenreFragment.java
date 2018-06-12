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
public class GenreFragment extends Fragment {


    public GenreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_genre, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.preferences_array, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AquaData app = (AquaData) getActivity().getApplication();

        Spinner gdrSpinner = (Spinner) view.findViewById(R.id.gdr_spinner);

// Apply the adapter to the spinner
        gdrSpinner.setAdapter(adapter);

        gdrSpinner.setSelection(app.getGdrPreference());

        gdrSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setGdrPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });



        Spinner actionSpinner = (Spinner) view.findViewById(R.id.action_spinner);

        actionSpinner.setAdapter(adapter);

        actionSpinner.setSelection(app.getActionPreference());

        actionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setActionPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner survivalSpinner = (Spinner) view.findViewById(R.id.survival_spinner);

        survivalSpinner.setAdapter(adapter);

        survivalSpinner.setSelection(app.getSurvivalPreference());

        survivalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setSurvivalPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner avventuraSpinner = (Spinner) view.findViewById(R.id.avventura_spinner);

        avventuraSpinner.setAdapter(adapter);

        avventuraSpinner.setSelection(app.getAdventurePreference());

        avventuraSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setAdventurePreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner picchiaduroSpinner = (Spinner) view.findViewById(R.id.picchiaduro_spinner);

        picchiaduroSpinner.setAdapter(adapter);

        picchiaduroSpinner.setSelection(app.getFightingPreference());

        picchiaduroSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setFightingPreference(pos);

            }
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner drivingSpinner = (Spinner) view.findViewById(R.id.driving_spinner);

        drivingSpinner.setAdapter(adapter);

        drivingSpinner.setSelection(app.getRacingPreference());

        drivingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setRacingPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner sparatuttoSpinner = (Spinner) view.findViewById(R.id.sparatutto_spinner);

        sparatuttoSpinner.setAdapter(adapter);

        sparatuttoSpinner.setSelection(app.getShooterPreference());

        sparatuttoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setShooterPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner strategiaSpinner = (Spinner) view.findViewById(R.id.strategia_spinner);

        strategiaSpinner.setAdapter(adapter);

        strategiaSpinner.setSelection(app.getStrategyPreference());

        strategiaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setStrategyPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });


        Spinner platformSpinner = (Spinner) view.findViewById(R.id.platform_spinner);

        platformSpinner.setAdapter(adapter);

        platformSpinner.setSelection(app.getPlatformPreference());

        platformSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setPlatformPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner stealthSpinner = (Spinner) view.findViewById(R.id.stealth_spinner);

        stealthSpinner.setAdapter(adapter);

        stealthSpinner.setSelection(app.getStealthPreference());

        stealthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setStealthPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner carteSpinner = (Spinner) view.findViewById(R.id.carte_spinner);

        carteSpinner.setAdapter(adapter);

        carteSpinner.setSelection(app.getCartePreference());

        carteSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setCartePreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner gestionaleSpinner = (Spinner) view.findViewById(R.id.gestionale_spinner);

        gestionaleSpinner.setAdapter(adapter);

        gestionaleSpinner.setSelection(app.getGestionalePreference());

        gestionaleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setGestionalePreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

}
