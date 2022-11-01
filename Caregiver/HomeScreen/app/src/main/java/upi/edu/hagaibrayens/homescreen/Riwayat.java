package upi.edu.hagaibrayens.homescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Riwayat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);
    }

    public void home(View v){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }

}