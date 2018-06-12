package com.example.andreacorronca.myapplicationtest;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class Library extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        AquaData app1 = (AquaData)getApplication();

        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0) ;
        header.findViewById(R.id.nomeUtente);
        TextView nomeUtente = (TextView) header.findViewById(R.id.nomeUtente);
        Menu menu = navigationView.getMenu();

        MenuItem carrello = menu.findItem(R.id.carrello);
        MenuItem listaDeiDesideri = menu.findItem(R.id.listaDesideri);
        carrello.setTitle("Carrello (" + app1.getCart().size() + ")");
        listaDeiDesideri.setTitle("Lista dei desideri (" + app1.getWishList().size() + ")");


        nomeUtente.setText(app1.getUserName());

        Toolbar toolbar = findViewById(R.id.my_toolbar);
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

                            case R.id.catalogo :
                                Intent boh = new Intent(getBaseContext(),Home.class);
                                startActivity(boh);
                                break;

                            case R.id.carrello :
                                Intent boh5 = new Intent(getBaseContext(),Cart.class);
                                startActivity(boh5);
                                break;


                            case R.id.listaDesideri :
                                Intent boh2 = new Intent(getBaseContext(),WishList.class);
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



        TextView libraryCount = findViewById(R.id.library_count);

        libraryCount.setText("Giochi posseduti:" + app1.getLibrary().size());

        GameLibraryAdapter adapter = new GameLibraryAdapter(this, app1.getLibrary(),app1);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }

    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
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

        /*switch (getIntent().getIntExtra("home",0)){
            case 1:
                Intent intent = new Intent(this,Home.class);
                startActivity(intent);
                break;

            default:
                finish();
                break;
        }*/
    }
}
