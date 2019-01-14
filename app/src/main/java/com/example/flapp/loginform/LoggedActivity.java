package com.example.flapp.loginform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import com.example.flapp.loginform.TestData.UserData;

public class LoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_logged);
        UserData users = UserData.getRemain();
        super.onCreate(savedInstanceState); //Persistenza dello stato

        //Click listener per tornare all'activity precedente
        Button backButton = findViewById(R.id.BackButton);
        backButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    finish();
                }
            }
        );

        TextView loginResult = findViewById(R.id.LoginResult);

        //Recupero dei dati inseriti in precedenza nell'intent
        Intent intent = getIntent();
        String userId = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

        //Mostro un messaggio differente a seconda che le credenziali d'accesso siano corrette o meno
        if(users.Login(userId, password)){
            loginResult.setText(getString(R.string.Benvenuto)+userId+getString(R.string.Esclamazione));
        }
        else {
            loginResult.setText(getString(R.string.AccessoNonConsentito));
        }
    }
}
