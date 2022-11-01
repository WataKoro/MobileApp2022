package upi.edu.hagaibrayens.homescreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class register_start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_start);
    }

    public void registerLansia(View v){
        Intent switchActivityIntent = new Intent(this, register_lansia.class);
        startActivity(switchActivityIntent);
    }

    public void registerLansia(MenuItem item){
        Intent switchActivityIntent = new Intent(this, register_lansia.class);
        startActivity(switchActivityIntent);
    }

    public void registerCaregiver(View v){
        Intent switchActivityIntent = new Intent(this, register_caregiver.class);
        startActivity(switchActivityIntent);
    }

    public void registerCaregiver(MenuItem item){
        Intent switchActivityIntent = new Intent(this, register_caregiver.class);
        startActivity(switchActivityIntent);
    }
}