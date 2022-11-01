package upi.edu.hagaibrayens.homescreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class register_caregiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cargiver);
    }

    public void login(View v){
        Intent switchActivityIntent = new Intent(this, LoginCaregiver.class);
        startActivity(switchActivityIntent);
    }

}