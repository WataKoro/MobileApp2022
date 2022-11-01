package upi.edu.hagaibrayens.homescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginCaregiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_caregiver);
    }
    public void home(View v){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }
    public void regis(View v){
        Intent switchActivityIntent = new Intent(this, register_caregiver.class);
        startActivity(switchActivityIntent);
    }
}