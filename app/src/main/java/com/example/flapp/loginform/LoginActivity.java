package com.example.flapp.loginform;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Utility import
import com.example.flapp.loginform.TestData.UserData;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Inizializzazione del database
        UserData users = new UserData();

        //On Click Listener del LoginButton che richiama la funznione Login()
        Button loginButton = findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }

    private void Login() {

        //Controllo dei campi...
        EditText id = findViewById(R.id.Username);
        EditText pass = findViewById(R.id.Password);

        if(isEmpty(id) || isEmpty(pass)){ //...se vuoti appare un messaggio d'errore...
            ErrorMessage(getString(R.string.UserPassVuoti));
        }
        else{ //...se non vuoti salvo nell'intent i parametri e richiamo LoggedActivity
            Intent intent = new Intent(this, LoggedActivity.class);
            intent.putExtra("username", id.getText().toString());
            intent.putExtra("password", pass.getText().toString());
            startActivity(intent);
        }

    }

    //Funzione di controllo per i campi di testo
    private boolean isEmpty(EditText text) {
        if (text.getText().toString().trim().length() > 0) {
            return false;
        }
        return true;
    }

    //Funzione per il messaggio d'errore
    private void ErrorMessage(String message){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        dlgAlert.setMessage(message);
        dlgAlert.setTitle(R.string.Errore);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();

        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
    }
}
