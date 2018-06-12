package com.example.andreacorronca.myapplicationtest;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Subscribe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    public void subscribe(View view) {
        boolean shallPass = true;

        TextInputLayout name = (TextInputLayout) findViewById(R.id.text_Name);
        TextInputLayout surname = (TextInputLayout) findViewById(R.id.text_SurName);
        TextInputLayout userName = (TextInputLayout) findViewById(R.id.text_UserName);
        TextInputLayout password = (TextInputLayout) findViewById(R.id.text_input_password);
        TextInputLayout confirm = (TextInputLayout) findViewById(R.id.text_confirm_pass);


        if (name.getEditText().getText().toString().length()>0){

        }
        else {
            name.getEditText().setError("il nome deve essere inserito");
            shallPass = false;
        }

        if (surname.getEditText().getText().toString().length()>0){

        }
        else {
            surname.getEditText().setError("il cognome deve essere inserito");
            shallPass = false;
        }

        if (userName.getEditText().getText().toString().length()>0){

        }
        else {
            userName.getEditText().setError("il nome utente deve essere inserito");
            shallPass = false;
        }


        if (password.getEditText().getText().toString().length()>0){

        }
        else {
            password.getEditText().setError("la password deve essere inserita");
            shallPass = false;
        }

        if (confirm.getEditText().getText().toString().length()>0){

        }
        else {
            confirm.getEditText().setError("la password deve essere reinserita");
            shallPass = false;
        }

        if(shallPass){
            Intent intent = new Intent(this, Home.class);
            String message = userName.getEditText().getText().toString();
            AquaData app1 = (AquaData)getApplication();
            app1.setUserName(message);
            CharSequence msg = "Registrazione completata,benvenuto";
            Toast.makeText(this,msg,msg.length()).show();
            startActivity(intent);
        }


    }
}
