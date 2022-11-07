package upi.edu.hagaibrayens.homescreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class ProfilCaregiver extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_caregiver);

    }

    public void login(View v){
        Intent switchActivityIntent = new Intent(this, LoginCaregiver.class);
        startActivity(switchActivityIntent);
    }

    public void home(View v){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }

    public void home(MenuItem item){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }

    public void list(MenuItem item){
        Intent switchActivityIntent = new Intent(this, Riwayat.class);
        startActivity(switchActivityIntent);
    }

    public void set(MenuItem item){
        Intent switchActivityIntent = new Intent(this, setting.class);
        startActivity(switchActivityIntent);
    }

    public void kontak(MenuItem item){
        Intent switchActivityIntent = new Intent(this, ProfilCaregiver.class);
        startActivity(switchActivityIntent);
    }

    public void kontak(View v){
        Intent switchActivityIntent = new Intent(this, ProfilCaregiver.class);
        startActivity(switchActivityIntent);
    }



}