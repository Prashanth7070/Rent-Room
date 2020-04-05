package com.example.rentroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected) {

            //we will check the auth state here



            goToLoginActivity();

        }
        else {

            //internet connection is not there
            Toast.makeText(this, "No internet connection.Please check your network and try again", Toast.LENGTH_SHORT).show();
        }

    }

    public void goToLoginActivity(){

        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);

    }
}

