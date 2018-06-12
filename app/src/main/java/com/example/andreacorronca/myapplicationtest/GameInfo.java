package com.example.andreacorronca.myapplicationtest;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        TextView title = (TextView) findViewById(R.id.gameTitle);
        TextView insertVote = (TextView) findViewById(R.id.insertVote);
        ImageView img = (ImageView) findViewById(R.id.gameImg);
        TextView price = (TextView) findViewById(R.id.price);
        TextView metacritic = (TextView) findViewById(R.id.metacritic);
        TextView vote = (TextView) findViewById(R.id.vote);
        TextView genre1 = findViewById(R.id.genere1);
        TextView genre2 = findViewById(R.id.genere2);
        TextView ambientazione = findViewById(R.id.ambientazione);
        TextView modalita = findViewById(R.id.modalita_di_gioco);
        TextView info = findViewById(R.id.info);
        TextView free_to_play = findViewById(R.id.free);
        TextView early_access = findViewById(R.id.early_access);
        TextView addWishList = findViewById(R.id.wishList);
        TextView saldInfo = findViewById(R.id.saldInfo);

        Game currentGame = GamesCathalogDbHelper.getGameById(intent.getIntExtra("_id",0),getApplicationContext());

        AquaData app1 = (AquaData)getApplication();

        app1.setCurrentGame(currentGame);


        int metacriticVote = currentGame.getMetacritic();
        int usersVote =  currentGame.getUsersVote();

        if(app1.getLibrary().contains(currentGame)){
            insertVote.setEnabled(true);
            int gameVote = app1.getVotes().get(currentGame.getId());
            if (gameVote != 101){
                insertVote.setText("Modifica il tuo voto: " + gameVote +"%");
        }
        }

        title.setText(currentGame.getName());
        img.setImageResource(currentGame.getImgId());
        price.setText(new StringBuilder("Aggiungi al carrello : ").append(currentGame.getPrice()).append("€").toString());
        if (currentGame.getDiscount() > 0){
            saldInfo.setVisibility(View.VISIBLE);
            saldInfo.setText("-" + new Integer (currentGame.getDiscount()).toString()+ "%");
        }
        metacritic.setText(new StringBuilder("").append(metacriticVote).toString());
        vote.setText(new StringBuilder("").append(usersVote).append("%").toString());

        genre1.setText(Game.getGenre(currentGame.getFirstGenre()));
        if (currentGame.getSecondGenre() != 12){
            genre2.setText(Game.getGenre(currentGame.getSecondGenre()));
        }
        else {
            genre2.setVisibility(View.INVISIBLE);
        }


        ambientazione.setText(Game.getSetting(currentGame.getSetting()));
        modalita.setText(Game.getMode(currentGame.getGameMode()));

        if (currentGame.isEarlyAccess()){
            info.setVisibility(View.VISIBLE);
            early_access.setVisibility(View.VISIBLE);
        }

        if (currentGame.isFreeToPlay()){
            info.setVisibility(View.VISIBLE);
            free_to_play.setVisibility(View.VISIBLE);
        }

        if (metacriticVote >= 80)
            metacritic.setBackgroundResource(R.color.green);
        else if (metacriticVote > 50 && metacriticVote < 80)
            metacritic.setBackgroundResource(R.color.yellow);
        else
            metacritic.setBackgroundResource(R.color.red);

        if (usersVote >= 80)
            vote.setBackgroundResource(R.color.green);
        else if (usersVote > 50 && usersVote < 80)
            vote.setBackgroundResource(R.color.yellow);
        else
            vote.setBackgroundResource(R.color.red);

        if (app1.getLibrary().contains(currentGame)){
            price.setText("Posseduto");
            price.setClickable(false);
            addWishList.setText("Ore giocate: 0");
            addWishList.setClickable(false);
        }

        else{

            if (app1.getCart().contains(currentGame)){
                price.setText("Rimuovi dal carrello");
            }

            if (app1.getWishList().contains(currentGame)){
                addWishList.setText("Rimuovi da lista dei desideri");
            }
        }

        int tmpVote = 101;

        if(app1.getVotes().containsKey(currentGame.getId())){
            tmpVote = app1.getVotes().get(currentGame.getId());
        }

        if(tmpVote != 101){
            int totalUsersVotes = (currentGame.getUsersVote() * 100) + tmpVote;

            int newUsersVote = Math.round((float)totalUsersVotes / 101);

            vote.setText(newUsersVote + "%");
        }




    }

    public void addToWishList(View v)
    {
        TextView addWishList = findViewById(R.id.wishList);

        AquaData app1 = (AquaData)getApplication();

        CharSequence message = "";

        Toast toast;

        if (app1.getWishList().contains(app1.getCurrentGame())){
            app1.getWishList().remove(app1.getCurrentGame());

            message = "gioco rimosso da lista dei desideri";
            toast = Toast.makeText(this,message,message.length());
            toast.show();
            addWishList.setText("Aggiungi a lista dei desideri");
        }
        else{
            app1.getWishList().add(app1.getCurrentGame());
            message = "gioco aggiunto a lista dei desideri";
            toast = Toast.makeText(this,message,message.length());
            toast.show();
            addWishList.setText("Rimuovi da lista dei desideri");
        }
    }

    public void addToCart(View v)
    {
        TextView price = (TextView) findViewById(R.id.price);

        AquaData app1 = (AquaData)getApplication();

        CharSequence message = "";

        Toast toast;

        if (app1.getCart().contains(app1.getCurrentGame())){
            app1.getCart().remove(app1.getCurrentGame());

            message = "gioco rimosso dal carrello";
            toast = Toast.makeText(this,message,message.length());
            toast.show();
            price.setText((new StringBuilder("Aggiungi al carrello : ").append(app1.getCurrentGame().getPrice()).append("€").toString()));
        }
        else{
            app1.getCart().add(app1.getCurrentGame());

            message = "gioco aggiunto al carrello";
            toast = Toast.makeText(this,message,message.length());
            toast.show();
            price.setText("Rimuovi dal carrello");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:

                finish();

                /*switch (getIntent().getIntExtra("activity",0)){
                    case 0:
                        finish();
                        break;
                    case 1:
                        Intent intent = new Intent(this,Home.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent1 = new Intent(this,Library.class);
                        startActivity(intent1);
                        break;
                }*/
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onBackPressed() {
        finish();
                /*switch (getIntent().getIntExtra("activity",0)){
                    case 0:
                        finish();
                        break;
                    case 1:
                        Intent intent = new Intent(this,Home.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent1 = new Intent(this,Library.class);
                        startActivity(intent1);
                        break;
                }*/
    }

    public void valutaGioco(View view){
        FragmentManager fm = getFragmentManager();
        VoteFragment dialogFragment = new VoteFragment ();
        dialogFragment.show(fm, "Sample Fragment");
    }
}
