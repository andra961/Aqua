package com.example.andreacorronca.myapplicationtest;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdviceSettings extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_settings);

        AquaData app1 = (AquaData) getApplication();

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
                            case R.id.libreria :
                                CharSequence message = "impostazioni salvate";
                                Toast toast = Toast.makeText(getBaseContext(),message,message.length());
                                toast.show();
                                Intent boh = new Intent(getBaseContext(),Library.class);
                                startActivity(boh);
                                break;

                            case R.id.carrello :
                                CharSequence message1 = "impostazioni salvate";
                                Toast toast1 = Toast.makeText(getBaseContext(),message1,message1.length());
                                toast1.show();
                                Intent boh1 = new Intent(getBaseContext(),Cart.class);
                                startActivity(boh1);
                                break;

                            case R.id.listaDesideri :
                                CharSequence message2 = "impostazioni salvate";
                                Toast toast2 = Toast.makeText(getBaseContext(),message2,message2.length());
                                toast2.show();
                                Intent boh2 = new Intent(getBaseContext(),WishList.class);
                                startActivity(boh2);
                                break;

                            case R.id.catalogo :
                                CharSequence message3 = "impostazioni salvate";
                                Toast toast3 = Toast.makeText(getBaseContext(),message3,message3.length());
                                toast3.show();
                                Intent boh3 = new Intent(getBaseContext(),Home.class);
                                startActivity(boh3);
                                break;

                            case R.id.esci :
                                CharSequence message4 = "impostazioni salvate";
                                Toast toast4 = Toast.makeText(getBaseContext(),message4,message4.length());
                                toast4.show();
                                Intent boh4 = new Intent(getBaseContext(),Login.class);
                                startActivity(boh4);
                                break;
                        }

                        return true;
                    }
                });



        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(app1.getAdviceTabSelected());

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //do stuff here
                AquaData app1 = (AquaData) getApplication();
                app1.setAdviceTabSelected(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /*public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                CharSequence message = "le impostazioni sono state salvate";
                Toast toast = Toast.makeText(this,message,message.length());
                toast.show();
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

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
            CharSequence message = "impostazioni salvate";
            Toast toast = Toast.makeText(this,message,message.length());
            toast.show();



            finish();
        }




//        switch (getIntent().getIntExtra("home",0)){
//            case 1:
//                Intent intent = new Intent(this,Home.class);
//                startActivity(intent);
//                break;
//
//            default:
//                finish();
//                break;
//        }


    }
}
