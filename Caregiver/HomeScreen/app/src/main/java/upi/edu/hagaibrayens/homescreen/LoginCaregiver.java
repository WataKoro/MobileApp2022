package upi.edu.hagaibrayens.homescreen;

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

public class LoginCaregiver extends AppCompatActivity {

    EditText EmailAddress, Password;
    Button btLogin;
    DBHelper sqLiteDatabase;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_caregiver);

        EmailAddress = findViewById(R.id.EmailAddress);
        Password= findViewById(R.id.Password);
        btLogin= findViewById(R.id.btLogin);
        sqLiteDatabase= new DBHelper(this);
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(LoginCaregiver.this);
        progressDialog.setTitle("loading");
        progressDialog.setMessage("progres sedang berjalan");
        progressDialog.setCancelable(false);

        btLogin.setOnClickListener( v ->  {
//            public void onClick(View view) {
//
                String email=EmailAddress.getText().toString();
                String pass=Password.getText().toString();
//
//                if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pass))
//                    Toast.makeText(LoginCaregiver.this, "Pastikan tidak kosong", Toast.LENGTH_SHORT).show();
//                else {
//                    Boolean checkuserpass= sqLiteDatabase.checkmailpass(email,pass);
//                    if (checkuserpass==true){
//                        Toast.makeText(LoginCaregiver.this, "Login sukses", Toast.LENGTH_SHORT).show();
//                        Intent intent= new Intent(getApplicationContext(),Home.class);
//                        intent.putExtra("Email", email);
//                        startActivity(intent);
//                    }else {
//                        Toast.makeText(LoginCaregiver.this, "login gagal", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }

            if(email.length()>0&&pass.length()>0){
                login(email, pass);
            }
            else{
                Toast.makeText(LoginCaregiver.this, "Pastikan tidak kosong", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void login(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult()!=null){
                    if(task.getResult().getUser()!=null){
                        reload();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_SHORT).show();
                    }
            }
            else{
                    Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void reload(){
        startActivity(new Intent(getApplicationContext(), Home.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    public void home(View v){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }
    public void regis(View v){
        Intent switchActivityIntent = new Intent(this, register_caregiver.class);
        startActivity(switchActivityIntent);
    }

    private void emptyInputEditText() {
        EmailAddress.setText(null);
        Password.setText(null);
    }
}