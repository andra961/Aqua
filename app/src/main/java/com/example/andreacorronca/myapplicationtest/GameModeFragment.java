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
public class GameModeFragment extends Fragment {


    public GameModeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_mode, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.preferences_array, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AquaData app = (AquaData) getActivity().getApplication();

        Spinner singleSpinner = (Spinner) view.findViewById(R.id.single_spinner);

        singleSpinner.setAdapter(adapter);

        singleSpinner.setSelection(app.getSinglePreference());

        singleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setSinglePreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner localSpinner = (Spinner) view.findViewById(R.id.multyLoc_spinner);

        localSpinner.setAdapter(adapter);

        localSpinner.setSelection(app.getLocalPreference());

        localSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setLocalPreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Spinner onlineSpinner = (Spinner) view.findViewById(R.id.multyOn_spinner);

        onlineSpinner.setAdapter(adapter);

        onlineSpinner.setSelection(app.getOnlinePreference());

        onlineSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {

                //whatever your logic is put it here

                AquaData app1 = (AquaData) getActivity().getApplication();
                app1.setOnlinePreference(pos);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

}
