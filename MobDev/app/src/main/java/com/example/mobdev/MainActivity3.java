package com.example.mobdev;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mobdev.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void logout(View v){
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }

    public void logout(MenuItem item){
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }

    public void kontakActivity(View v){
        Intent switchActivityIntent = new Intent(this, MainActivity4.class);
        startActivity(switchActivityIntent);
    }

    public void nextActivity(View v){
        Intent switchActivityIntent = new Intent(this, MainActivity2.class);
        startActivity(switchActivityIntent);
    }

    public void nextActivity(MenuItem item) {
        Intent switchActivityIntent = new Intent(this, MainActivity2.class);
        startActivity(switchActivityIntent);
    }
}