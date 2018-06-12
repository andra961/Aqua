package com.example.andreacorronca.myapplicationtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameResultsAdapter extends ArrayAdapter<Game> {

    AquaData app1;

    public GameResultsAdapter(Context context, ArrayList<Game> users,AquaData app1) {
        super(context, 0, users);
        this.app1 = app1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Game preview = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.game_preview, parent, false);
        }
        // Lookup view for data population
        TextView price = (TextView) convertView.findViewById(R.id.price);
        TextView saldPreview = convertView.findViewById(R.id.saldPreview);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView metacritic = (TextView) convertView.findViewById(R.id.metacritic);
        final TextView usersVote = (TextView) convertView.findViewById(R.id.usersVote);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        // Populate the data into the template view using the data object




        if (preview.isFreeToPlay()){
            price.setText("Free to Play");
        }
        else{
            price.setText("Prezzo : " + new Float(preview.getPrice()).toString() +"€");
        }
        name.setText(preview.getName());
        if (preview.getMetacritic() >= 80)
            metacritic.setBackgroundResource(R.color.green);
        else if (preview.getMetacritic() > 50 && preview.getMetacritic() < 80)
            metacritic.setBackgroundResource(R.color.yellow);
        else
            metacritic.setBackgroundResource(R.color.red);
        metacritic.setText(new Integer(preview.getMetacritic()).toString());
        image.setImageResource(preview.getImgId());
        if (preview.getUsersVote() >= 80)
            usersVote.setBackgroundResource(R.color.green);
        else if (preview.getUsersVote() > 50 && preview.getUsersVote() < 80)
            usersVote.setBackgroundResource(R.color.yellow);
        else
            usersVote.setBackgroundResource(R.color.red);
        usersVote.setText(new Integer(preview.getUsersVote()).toString()  + "%");
        // Return the completed view to render on screen


        saldPreview.setText("-" + new Integer(preview.getDiscount()).toString() + "%");
        if(preview.getDiscount() == 0){
            saldPreview.setVisibility(View.INVISIBLE);
        }
        else{
            saldPreview.setVisibility(View.VISIBLE);
        }



        convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {

                final Intent intent = new Intent(getContext(), GameInfo.class);
                intent.putExtra("_id", preview.getId());
                getContext().startActivity(intent);
            }
        });

        int tmpVote = 101;

        if(app1.getVotes().containsKey(preview.getId())){
            tmpVote = app1.getVotes().get(preview.getId());
        }

        if(tmpVote != 101){
            int totalUsersVotes = (preview.getUsersVote() * 100) + tmpVote;

            int newUsersVote = Math.round((float)totalUsersVotes / 101);

            usersVote.setText(newUsersVote + "%");
        }

        return convertView;
    }
}
