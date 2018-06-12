package com.example.andreacorronca.myapplicationtest;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */




public class SaveFilterFragment extends DialogFragment {



    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final EditText input = new EditText(getActivity());

        /*TableLayout.LayoutParams params = new TableLayout.LayoutParams();
        params.setMargins(0, 30, 0, 30);*/

        //input.setLayoutParams(params);

        input.setId(0);
        input.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setHint("Nome filtro...");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        lp.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics()));

        input.setLayoutParams(lp);

        input.setText("filtro1");

        input.selectAll();



        LinearLayout parentLayout = new LinearLayout(getActivity());
        parentLayout.addView(input);

        input.requestFocus();

        return new android.support.v7.app.AlertDialog.Builder(getActivity())
                .setView(parentLayout)
                .setTitle("title")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // do something...
                                if (input.getText().toString().length()>0){
                                    input.setError("Nome non valido");
                                    //dialog.dismiss();
                                }
                                else {
                                    input.setError("Nome non valido");
                                }
                            }
                        }
                )
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        }
                )
                .create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_save_filter, container, false);
        getDialog().setTitle("Salva filtro");
        return rootView;
    }

    public void onResume()
    {
        super.onResume();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        Button okButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                performOkButtonAction();
            }
        });
    }

    private void performOkButtonAction() {
        // Do your stuff here

        AquaData app1 = (AquaData) getActivity().getApplication();

        EditText input = getDialog().findViewById(0);

        Filter filter = new Filter(app1.isDescending(),app1.getSortOrder(), app1.isShowGdr(),app1.isShowAction(),app1.isShowSurvival(),app1.isShowAdventure(),app1.isShowFighting(),app1.isShowRacing(),app1.isShowShooter(),app1.isShowStrategy(),app1.isShowPlatform(),app1.isShowStealth(),app1.isShowCards(),app1.isShowManagerial(),app1.isShowFuturistic(),app1.isShowActual(),app1.isShowFantasy(),app1.isShowHorror(),app1.isShowWar(),app1.isShowPast(),app1.isShowSingle(),app1.isShowLocal(),app1.isShowOnline(),app1.isShowFree(),app1.isShowEarly(),app1.isShowStandard(),app1.isPriceRange(),app1.getMinimumPrice(),app1.getMaximumPrice());

        if (input.getText().toString().length()>0){
            if(app1.getFilters().contains(filter)){
                CharSequence  msg = "filtro già salvato in precedenza";
                Toast.makeText(getActivity(),msg,msg.length()).show();
                getDialog().dismiss();
            }
            else {
                if(app1.getFilterSelection().contains(input.getText().toString())) {
                    input.setError("Un filtro ha già questo nome");
                }
                else {
                    app1.getFilterSelection().add(input.getText().toString());
                    CharSequence  msg = "filtro aggiunto ai preferiti";
                    app1.getFilters().add(filter);
                    Toast.makeText(getActivity(),msg,msg.length()).show();
                    getDialog().dismiss();
                }
            }

        }
        else {
            input.setError("Inserisci il nome del filtro");
        }
    }

}
