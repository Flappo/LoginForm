package com.example.flapp.loginform.TestData;
import java.util.ArrayList;

/*
Questa classe contiene il Database e le
varie funzioni per il controllo dei dati
*/

public class UserData {
    private class User{
        private String UserID, UserPassword;

        public User(String UserID, String UserPassword){
            this.UserID = UserID;
            this.UserPassword = UserPassword;
        }
    }


    private static UserData usersRemain; //
    private  ArrayList<User> Users = new ArrayList<>(); //Array degli utenti

    public UserData(){ //Funzione per la creazione del database
        Users.clear();
        Users.add(new User("user", "password"));
        Users.add(new User("user1", "password1"));
    }

    //Funzione di controllo dell'esistenza del database
    public static UserData getRemain(){
        if(usersRemain == null)
            usersRemain = new UserData();
        return usersRemain;
    }

    //Funzione di controllo dei dati per il login
    public boolean Login (String id, String pass){
        /*
        Dati in entrata un username e una password controllo
        se nel database esiste un utente con quelle credenziali.
        */
        for(User array : Users)
            if(array.UserID.equals(id) && array.UserPassword.equals(pass)) {
                return true;
            }

        return false;
    }

}
