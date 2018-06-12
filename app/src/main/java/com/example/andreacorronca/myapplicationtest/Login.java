package com.example.andreacorronca.myapplicationtest;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myapplicationtest.MESSAGE" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextInputLayout user = (TextInputLayout) findViewById(R.id.text_UserName);
        user.requestFocus();


    }

    public void login(View view) {
        boolean shallPass = true;

        TextInputLayout user = (TextInputLayout) findViewById(R.id.text_UserName);
        TextInputLayout password = (TextInputLayout) findViewById(R.id.text_input_layout);
        if (user.getEditText().getText().toString().length()>0){

        }
        else {
            user.getEditText().setError("il nome utente deve essere inserito");
            shallPass = false;
        }
        if (password.getEditText().getText().toString().length()>0){

        }
        else {
            password.getEditText().setError("la password deve essere inserita");
            shallPass = false;
        }

        if(shallPass){
            Intent intent = new Intent(this, Home.class);
            String message = user.getEditText().getText().toString();
            AquaData app1 = (AquaData)getApplication();
            app1.setUserName(message);
            startActivity(intent);
        }


    }

    public void subscribe(View view) {

        Intent intent = new Intent(this,Subscribe.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Clicca INDIETRO un altra volta per uscire", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}

