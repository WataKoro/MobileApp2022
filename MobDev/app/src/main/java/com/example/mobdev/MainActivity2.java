package com.example.mobdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private TextView Name, Email;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        btnLogout = findViewById(R.id.logout);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser!=null){
            Name.setText(firebaseUser.getDisplayName());
            Email.setText(firebaseUser.getEmail());
        }else{
            Name.setText("Login Gagal!");
        }

        btnLogout.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        });
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