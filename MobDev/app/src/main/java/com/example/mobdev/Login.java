package com.example.mobdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText EmailAddress, Password;
    Button btLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmailAddress = findViewById(R.id.EmailAddress);
        Password= findViewById(R.id.Password);
        btLogin= findViewById(R.id.btLogin);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please Wait!");
        progressDialog.setCancelable(false);

        btLogin.setOnClickListener(v -> {
            if(EmailAddress.getText().length()>0 && Password.getText().length()>0){
                login(EmailAddress.getText().toString(), Password.getText().toString());
            }else{
                Toast.makeText(getApplicationContext(), "Data belum lengkap!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void home(View v){
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
    public void regis(View v){
        Intent switchActivityIntent = new Intent(this, Register.class);
        startActivity(switchActivityIntent);
    }

    public void login(String email, String pass){
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult()!=null){
                    if(task.getResult().getUser()!=null){
                        reload();
                    }else{
                        Toast.makeText(getApplicationContext(), "Login gagal!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Login gagal!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}