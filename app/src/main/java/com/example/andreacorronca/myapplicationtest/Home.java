package com.example.andreacorronca.myapplicationtest;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SQLiteDatabase db = new GamesCathalogDbHelper(this).getReadableDatabase();

        AquaData app1 = (AquaData)getApplication();

        //algoritmo suggerimenti

        ArrayList<Game> adviceData = new ArrayList<>();

        ArrayList<Game> allGames = GamesCathalogDbHelper.getAllGames(this);

        ArrayList<Game> popular = new ArrayList<>();

        popular.add(GamesCathalogDbHelper.getGameById(8,this));
        popular.add(GamesCathalogDbHelper.getGameById(12,this));
        popular.add(GamesCathalogDbHelper.getGameById(3,this));

        //allGames.removeAll(popular);

        adviceData.addAll(app1.getLibrary());
        adviceData.addAll(app1.getWishList());
        allGames.removeAll(adviceData);

        HighestScores adviceGames = new HighestScores();

        for(Game game: adviceData){
            int score = 0;
            if (game.getSecondGenre() == 12){
                score += app1.getGenrePreferenceById(game.getFirstGenre()) * 2;
            }
            else {
                score += app1.getGenrePreferenceById(game.getFirstGenre());
                score += app1.getGenrePreferenceById(game.getSecondGenre());
            }
            score += app1.getSettingPreferenceById(game.getSetting());
            score += app1.getGameModePreferenceById(game.getGameMode());
            score += app1.getInfoPreferenceById(game.isFreeToPlay(),game.isEarlyAccess());

            adviceGames.add(new PreferenceScore(game.getId(),score));
        }

        ArrayList<Game> gamesOfInterest = adviceGames.toGames(this);


        LinearLayout elenco = findViewById(R.id.elenco);

        for (Game game : gamesOfInterest ){
            HighestScores similarScores = new HighestScores();

            for (Game other : allGames){

                int score = 0;
                if(game.getSecondGenre() == 12){
                    if(other.getSecondGenre() == 12){
                        if(game.getFirstGenre() == other.getFirstGenre()){
                            score += 2;
                        }
                    }
                    else{
                        if(game.getFirstGenre() == other.getFirstGenre() || game.getFirstGenre() == other.getSecondGenre()) score++;
                    }
                }
                else{
                    if(game.getFirstGenre() == other.getFirstGenre() || game.getFirstGenre() == other.getSecondGenre()) score++;
                    if(game.getSecondGenre() == other.getFirstGenre() || game.getSecondGenre() == other.getSecondGenre()) score++;
                    if(game.getSetting() == other.getSetting()) score++;
                    if(game.getGameMode() == other.getGameMode()) score++;
                    if(game.isFreeToPlay() == game.isFreeToPlay()) score++;
                    if(game.isEarlyAccess() == game.isEarlyAccess()) score++;
                }
                similarScores.add(new PreferenceScore(other.getId(),score));
            }

            ArrayList<Game> similarGames = similarScores.toGames(this);
            if (similarGames.size() >3){
                similarGames.subList(3, similarGames.size()).clear();
            }
            allGames.removeAll(similarGames);

            TextView consigliatoPer = new TextView(this);
            LinearLayout.LayoutParams paramsExample = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics()));
            consigliatoPer.setGravity(Gravity.CENTER);
            if(app1.getLibrary().contains(game)) consigliatoPer.setText("Consigliati perchè hai " + game.getName() + ":");
            if(app1.getWishList().contains(game)) consigliatoPer.setText("Consigliati perchè desideri " + game.getName() +":");
            consigliatoPer.setLayoutParams(paramsExample);

            RecyclerView consigliati = new RecyclerView(this);

            LinearLayout.LayoutParams paramsExample2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            consigliati.addItemDecoration(new DividerItemDecoration(Home.this, LinearLayoutManager.HORIZONTAL));
            RecyclerViewHorizontalViewListAdapter gameAdapter = new RecyclerViewHorizontalViewListAdapter(similarGames, this);
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
            consigliati.setLayoutManager(horizontalLayoutManager);
            consigliati.setAdapter(gameAdapter);


            elenco.addView(consigliatoPer);
            elenco.addView(consigliati);

            //fare ricycle view e aggiungere a linear layput usando come lista similarGames
        }

        Cursor cursor = db.rawQuery(" SELECT * FROM " + GameContract.GameEntry.TABLE_NAME + " ORDER BY " + GameContract.GameEntry.COLUMN_NAME_METACRITIC + " DESC",null);

        ArrayList<Game> highestMetascore = GamesCathalogDbHelper.getGamesByCursor(cursor);
        highestMetascore.subList(3, highestMetascore.size()).clear();

        TextView consigliatoPer = new TextView(this);
        LinearLayout.LayoutParams paramsExample = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics()));
        consigliatoPer.setGravity(Gravity.CENTER);
        consigliatoPer.setLayoutParams(paramsExample);

        consigliatoPer.setText("Giochi con Metascore più alto");

        RecyclerView consigliati = new RecyclerView(this);


        consigliati.addItemDecoration(new DividerItemDecoration(Home.this, LinearLayoutManager.HORIZONTAL));
        RecyclerViewHorizontalViewListAdapter gameAdapter = new RecyclerViewHorizontalViewListAdapter(highestMetascore, this);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        consigliati.setLayoutManager(horizontalLayoutManager);
        consigliati.setAdapter(gameAdapter);


        elenco.addView(consigliatoPer);
        elenco.addView(consigliati);

        cursor = db.rawQuery(" SELECT * FROM " + GameContract.GameEntry.TABLE_NAME + " ORDER BY " + GameContract.GameEntry.COLUMN_NAME_USERS_VOTE + " DESC",null);

        ArrayList<Game> highestUsersVote = GamesCathalogDbHelper.getGamesByCursor(cursor);
        highestUsersVote.subList(3, highestUsersVote.size()).clear();

        consigliatoPer = new TextView(this);
        paramsExample = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics()));
        consigliatoPer.setGravity(Gravity.CENTER);
        consigliatoPer.setLayoutParams(paramsExample);

        consigliatoPer.setText("Giochi con voto Utenti più alto");

        consigliati = new RecyclerView(this);

        consigliati.addItemDecoration(new DividerItemDecoration(Home.this, LinearLayoutManager.HORIZONTAL));
        gameAdapter = new RecyclerViewHorizontalViewListAdapter(highestUsersVote, this);
        horizontalLayoutManager = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        consigliati.setLayoutManager(horizontalLayoutManager);
        consigliati.setAdapter(gameAdapter);


        elenco.addView(consigliatoPer);
        elenco.addView(consigliati);

        cursor = db.rawQuery(" SELECT * FROM " + GameContract.GameEntry.TABLE_NAME + " ORDER BY " + GameContract.GameEntry.COLUMN_NAME_DISCOUNT + " DESC",null);

        ArrayList<Game> highestDiscount = GamesCathalogDbHelper.getGamesByCursor(cursor);
        highestDiscount.subList(3, highestDiscount.size()).clear();

        consigliatoPer = new TextView(this);
        paramsExample = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics()));
        consigliatoPer.setGravity(Gravity.CENTER);
        consigliatoPer.setLayoutParams(paramsExample);

        consigliatoPer.setText("Giochi maggiormente scontati");

        consigliati = new RecyclerView(this);

        consigliati.addItemDecoration(new DividerItemDecoration(Home.this, LinearLayoutManager.HORIZONTAL));
        gameAdapter = new RecyclerViewHorizontalViewListAdapter(highestDiscount, this);
        horizontalLayoutManager = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        consigliati.setLayoutManager(horizontalLayoutManager);
        consigliati.setAdapter(gameAdapter);


        elenco.addView(consigliatoPer);
        elenco.addView(consigliati);


        final Intent intent = getIntent();
        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0) ;
        header.findViewById(R.id.nomeUtente);
        TextView nomeUtente = (TextView) header.findViewById(R.id.nomeUtente);
        Menu menu = navigationView.getMenu();

        MenuItem libreria = menu.findItem(R.id.libreria);
        MenuItem carrello = menu.findItem(R.id.carrello);
        MenuItem listaDeiDesideri = menu.findItem(R.id.listaDesideri);
        libreria.setTitle("Libreria (" + app1.getLibrary().size() + ")");
        carrello.setTitle("Carrello (" + app1.getCart().size() + ")");
        listaDeiDesideri.setTitle("Lista dei desideri (" + app1.getWishList().size() + ")");


        nomeUtente.setText(app1.getUserName());


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        //menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        switch (menuItem.getItemId()){
                            case R.id.libreria :
                                Intent boh = new Intent(getBaseContext(),Library.class);
                                boh.putExtra("home",1);
                                startActivity(boh);
                                break;

                            case R.id.carrello :
                                Intent boh1 = new Intent(getBaseContext(),Cart.class);
                                boh1.putExtra("home",1);
                                startActivity(boh1);
                                break;

                            case R.id.listaDesideri :
                                Intent boh2 = new Intent(getBaseContext(),WishList.class);
                                boh2.putExtra("home",1);
                                startActivity(boh2);
                                break;

                            case R.id.impostazioni :
                                Intent boh3 = new Intent(getBaseContext(),AdviceSettings.class);
                                boh3.putExtra("home",1);
                                startActivity(boh3);
                                break;
                            case R.id.esci :
                                Intent boh4 = new Intent(getBaseContext(),Login.class);
                                startActivity(boh4);
                                break;
                        }

                        return true;
                    }
                });

        //TextView popolari = findViewById(R.id.popolari);
        //AquaData app1 = (AquaData) getApplication();
        //popolari.setText(app1.getUserName());


        RecyclerView gameRecyclerView2 = findViewById(R.id.idRecyclerViewHorizontalList2);
        gameRecyclerView2.addItemDecoration(new DividerItemDecoration(Home.this, LinearLayoutManager.HORIZONTAL));
        RecyclerViewHorizontalViewListAdapter gameAdapter2 = new RecyclerViewHorizontalViewListAdapter(popular, this);
        LinearLayoutManager horizontalLayoutManager2 = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        gameRecyclerView2.setLayoutManager(horizontalLayoutManager2);
        gameRecyclerView2.setAdapter(gameAdapter2);

    }

    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        AquaData app1 = (AquaData) getApplication();

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);


        int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText searchText = (EditText) searchView.findViewById(id);

        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int keyAction, KeyEvent keyEvent) {
                if (
                    //Soft keyboard search
                        keyAction == EditorInfo.IME_ACTION_SEARCH ||
                                //Physical keyboard enter key
                                (keyEvent != null && KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode()
                                        && keyEvent.getAction() == KeyEvent.ACTION_DOWN)) {
                    /*CharSequence message = "i giochi sono stati aggiunti alla libreria";
                    Toast toast = Toast.makeText(getBaseContext(),message,message.length());
                    toast.show();*/

                    AquaData app1 = (AquaData)getApplication();
                    app1.setLastQuery("");
                    Intent intent = new Intent(getBaseContext(), ShowResults.class);
                    startActivity(intent);

                    return true;
                }
                return false;
            }
        });


        MenuItem searchMenuItem = menu.findItem(R.id.search);
        MenuItemCompat.setOnActionExpandListener(searchMenuItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {

                return true;
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                searchView.setIconified(false);

                return true;
            }
        });


        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

            case R.id.filters:
                Intent boh = new Intent(this,FilterActivity.class);
                boh.putExtra("activity",0);
                startActivity(boh);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {

        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            finish();
        }
    }

}
