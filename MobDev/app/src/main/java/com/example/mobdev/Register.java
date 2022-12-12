package com.example.mobdev;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText Nama,Mail,Pass,Telp,Alamat,Tgl;
    Button submit;
    FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = FirebaseFirestore.getInstance();
        Nama=findViewById(R.id.Nama);
        Mail=findViewById(R.id.Mail);
        Pass=findViewById(R.id.Pass);
        Alamat=findViewById(R.id.Alamat);
        Telp =findViewById(R.id.Telp);
        Tgl=findViewById(R.id.Tgl);
        submit=findViewById(R.id.submit);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(Register.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please Wait!");
        progressDialog.setCancelable(false);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = Nama.getText().toString();
                String mail = Mail.getText().toString();
                String pass = Pass.getText().toString();
                String alamat = Alamat.getText().toString();
                String telp = Telp.getText().toString();
                String tgl = Tgl.getText().toString();

                if (Nama.getText().length()>0 && Mail.getText().length()>0 && Pass.getText().length()>0 && Alamat.getText().length()>0 && Telp.getText().length()>0 && Tgl.getText().length()>0){
                    register(nama, mail, pass, alamat, telp, tgl);
                }else{
                    Toast.makeText(Register.this, "Data belum lengkap!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
//    public void login(View v){
//        Intent switchActivityIntent = new Intent(this, Login.class);
//        startActivity(switchActivityIntent);
//    }
    public void register(String Nama, String Mail, String Pass, String Alamat, String Telp, String Tgl){
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(Mail, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult()!=null){
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser!=null) {
                        Map<String,Object> user = new HashMap<>();
                        user.put("Nama", Nama);
                        user.put("Mail", Mail);
                        user.put("Alamat", Alamat);
                        user.put("Telepon", Telp);
                        user.put("Tanggal", Tgl);

                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(Nama)
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                reload();
                            }
                        });
                        db.collection("user").document(firebaseUser.getUid()).set(user);
                    }else{
                        Toast.makeText(getApplicationContext(), "Register Gagal!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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