package com.example.mobdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    FirebaseFirestore db;
    private TextView Name, Email, Tanggal, Phone, Alamat;
    private Button btnLogout;
    String Tanggaltmp, Phonetmp, Alamattmp;

    private Map<String,Object> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        Tanggal = findViewById(R.id.tanggal);
        Phone = findViewById(R.id.etphone);
        Alamat = findViewById(R.id.alamat);
        btnLogout = findViewById(R.id.logout);
        String TAG = "debug_kel6";
        Log.d(TAG,"Load semua data");

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        db = FirebaseFirestore.getInstance();

        btnLogout.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        });

        db.collection("user")
                .whereEqualTo("Mail", firebaseUser.getEmail())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                data = document.getData();
                                Tanggaltmp = String.valueOf(data.get("Tanggal"));
                                Tanggal.setText(Tanggaltmp);

                                Alamattmp = String.valueOf(data.get("Alamat"));
                                Alamat.setText(Alamattmp);

                                Phonetmp = String.valueOf(data.get("Telepon"));
                                Phone.setText(Phonetmp);
                                Log.d(TAG, document.getId() + " => " + data);
                                Log.d(TAG, data.get("Mail") + " => " + Tanggaltmp);
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

        if (firebaseUser!=null){
            Name.setText(firebaseUser.getDisplayName());
            Email.setText(firebaseUser.getEmail());
        }else{
            Name.setText("Login Gagal!");
        }

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