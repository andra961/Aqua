package com.example.andreacorronca.myapplicationtest;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VoteFragment extends DialogFragment {



    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final SeekBar vote = new SeekBar(getActivity());
        vote.setId(0);
        final TextView progress = new TextView(getActivity());
        progress.setGravity(Gravity.CENTER);
        progress.setTextSize(20);
        /*progress.setHeight(20);
        progress.setWidth(20);*/

        AquaData app1 = (AquaData) getActivity().getApplication();

        int actualVote = app1.getVotes().get(getActivity().getIntent().getIntExtra("_id",0));

        if (actualVote != 101){
            progress.setText(actualVote + "%");

            vote.setProgress(actualVote);
        }
        else{
            progress.setText(0 + "%");
        }


        vote.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress.setText(i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        vote.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()),(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()),(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()),0);
        vote.setMax(100);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        lp.setMargins(0, 0, 0, 0);
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);
        vote.setLayoutParams(lp);
        layout.addView(vote);
        layout.addView(progress);

        /*final EditText input = new EditText(getActivity());
        input.setId(0);
        input.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setHint("Nome filtro...");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);*/

        return new AlertDialog.Builder(getActivity())
                .setView(layout)
                .setTitle("title")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // do something...
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
        getDialog().setTitle("Inserisci valutazione");
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

        TextView voteButton = (TextView) getActivity().findViewById(R.id.insertVote);

        SeekBar progress = (SeekBar) getDialog().findViewById(0);

        app1.getVotes().put(getActivity().getIntent().getIntExtra("_id",0),progress.getProgress());

        voteButton.setText("Modifica il tuo voto: " + progress.getProgress() + "%");

        int totalUsersVotes = (GamesCathalogDbHelper.getGameById(getActivity().getIntent().getIntExtra("_id",0),getActivity()).getUsersVote() * 100) + progress.getProgress();

        int usersVote = Math.round((float)totalUsersVotes / 101);

        TextView vote = (TextView) getActivity().findViewById(R.id.vote);

        vote.setText(usersVote + "%");

        if (usersVote >= 80)
            vote.setBackgroundResource(R.color.green);
        else if (usersVote > 50 && usersVote < 80)
            vote.setBackgroundResource(R.color.yellow);
        else
            vote.setBackgroundResource(R.color.red);


        dismiss();

        /*EditText input = getDialog().findViewById(0);

        if (input.getText().toString().length()>0){
            app1.getFilterSelection().add(input.getText().toString());
            getDialog().dismiss();
        }
        else {
            input.setError("Nome non valido");
        }*/
    }

    private void onProgressChange(View view){

    }

}
