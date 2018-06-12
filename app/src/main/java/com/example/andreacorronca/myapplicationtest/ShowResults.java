package com.example.andreacorronca.myapplicationtest;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_results);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        TextView nResults = findViewById(R.id.n_results);

        Intent intent = getIntent();

        String name ="";

        AquaData app1 = (AquaData) getApplication();



        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            name = intent.getStringExtra(SearchManager.QUERY);

            app1.setLastQuery(name);
            //use the query to search your data somehow



        }
        else{
            name = app1.getLastQuery();
        }



        SQLiteDatabase db = new GamesCathalogDbHelper(getApplicationContext()).getReadableDatabase();

        StringBuilder query = new StringBuilder("SELECT *  FROM " + GameContract.GameEntry.TABLE_NAME + " WHERE " + GameContract.GameEntry.COLUMN_NAME_NAME + " LIKE " + "'%" + name + "%'");

        if (app1.isPriceRange()) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_PRICE + " BETWEEN " + app1.getMinimumPrice() + " AND " + app1.getMaximumPrice());

        if(!(app1.isShowGdr())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 0 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 0");
        if(!(app1.isShowAction())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 1 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 1");
        if(!(app1.isShowSurvival())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 2 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 2");
        if(!(app1.isShowAdventure())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 3 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 3");
        if(!(app1.isShowFighting())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 4 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 4");
        if(!(app1.isShowRacing())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 5 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 5");
        if(!(app1.isShowShooter())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 6 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 6");
        if(!(app1.isShowStrategy())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 7 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 7");
        if(!(app1.isShowPlatform())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 8 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 8");
        if(!(app1.isShowStealth())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 9 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 9");
        if(!(app1.isShowCards())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 10 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 10");
        if(!(app1.isShowManagerial())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE +  " <> 11 AND " + GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " <> 11");

        if(!(app1.isShowFuturistic())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_SETTING +  " <> 0");
        if(!(app1.isShowActual())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_SETTING +  " <> 1");
        if(!(app1.isShowFantasy())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_SETTING +  " <> 2");
        if(!(app1.isShowHorror())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_SETTING +  " <> 3");
        if(!(app1.isShowWar())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_SETTING +  " <> 4");
        if(!(app1.isShowPast())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_SETTING +  " <> 5");

        if(!(app1.isShowSingle())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_GAME_MODE +  " <> 0");
        if(!(app1.isShowLocal())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_GAME_MODE +  " <> 1");
        if(!(app1.isShowOnline())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_GAME_MODE +  " <> 2");

        if(!(app1.isShowFree())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY  +  " = 0");
        if(!(app1.isShowEarly())) query.append(" AND " + GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS +  " = 0");
        if(!(app1.isShowStandard())) query.append(" AND NOT(" + GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY +  " = 0 AND " + GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS + " = 0)");




        Cursor cursor;

        switch (app1.getSortOrder()){
            case 1:
                query.append(" ORDER BY " + GameContract.GameEntry.COLUMN_NAME_NAME);
                if(app1.isDescending()) query.append(" DESC");
                else query.append(" ASC");

                cursor = db.rawQuery(query.toString(),null);
                break;
            case 2:
                query.append(" ORDER BY " + GameContract.GameEntry.COLUMN_NAME_PRICE);
                if(app1.isDescending()) query.append(" DESC");
                else query.append(" ASC");

                cursor = db.rawQuery(query.toString(),null);
                break;
            case 3:
                query.append(" ORDER BY " + GameContract.GameEntry.COLUMN_NAME_USERS_VOTE);
                if(app1.isDescending()) query.append(" DESC");
                else query.append(" ASC");

                cursor = db.rawQuery(query.toString(),null);
                break;
            case 4:
                query.append(" ORDER BY " + GameContract.GameEntry.COLUMN_NAME_METACRITIC);
                if(app1.isDescending()) query.append(" DESC");
                else query.append(" ASC");

                cursor = db.rawQuery(query.toString(),null);
                break;

            case 5:
                query.append(" ORDER BY " + GameContract.GameEntry.COLUMN_NAME_DISCOUNT);
                if(app1.isDescending()) query.append(" DESC");
                else query.append(" ASC");

                cursor = db.rawQuery(query.toString(),null);
                break;
            default:
                cursor = db.rawQuery(query.toString(),null);
                break;
        }

        //cursor = db.rawQuery("SELECT *  FROM " + GameContract.GameEntry.TABLE_NAME + " WHERE " + GameContract.GameEntry.COLUMN_NAME_NAME + " LIKE " + "'%" + name + "%'",null);

        ArrayList<Game> results = GamesCathalogDbHelper.getGamesByCursor(cursor);

        GameResultsAdapter adapter = new GameResultsAdapter(this, results,app1);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        nResults.setText("risultati ricerca:" + results.size());

    }

    public void onRestart()
    {
        super.onRestart();
        AquaData app1 = (AquaData) getApplication();
        if(app1.getMustRefreshSearch()){
            app1.setMustRefreshSearch(false);
        finish();
        startActivity(getIntent());

        }
        else {

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search);

        MenuItemCompat.OnActionExpandListener expandListener = new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item)
            {
                NavUtils.navigateUpFromSameTask(ShowResults.this);
                /*Intent intent = new Intent(getBaseContext(),Home.class);
                startActivity(intent);*/
                //finish();
//                Intent intent = new Intent(getBaseContext(),Home.class);
//                startActivity(intent);

                // Do something when action item collapses
                return false;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item)
            {

                // Do something when expanded
                return true;  // Return true to expand action view
            }
        };

        MenuItemCompat.setOnActionExpandListener(searchItem, expandListener);


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

        AquaData app1 = (AquaData) getApplication();

        String name;

        if (Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
            name = getIntent().getStringExtra(SearchManager.QUERY);

            app1.setLastQuery(name);
            //use the query to search your data somehow



        }
        else{
            name = app1.getLastQuery();
        }

        searchView.setQuery(name,false);

        searchView.setOnCloseListener(new SearchView.OnCloseListener (){
            @Override
            public boolean onClose() {
                return true; //returning true will stop search view from collapsing
            }
        });

        searchItem.expandActionView();


        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.filters:
                Intent boh = new Intent(this,FilterActivity.class);
                boh.putExtra("activity",1);
                startActivity(boh);
                return true;

            case R.id.home:
                Intent intent = new Intent(this,Home.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {

        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }
}
