package upi.edu.hagaibrayens.homescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginCaregiver extends AppCompatActivity {

    EditText EmailAddress, Password;
    Button btLogin;
    DBHelper sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_caregiver);

        EmailAddress = findViewById(R.id.EmailAddress);
        Password= findViewById(R.id.Password);
        btLogin= findViewById(R.id.btLogin);
        sqLiteDatabase= new DBHelper(this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=EmailAddress.getText().toString();
                String pass=Password.getText().toString();

                if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pass))
                    Toast.makeText(LoginCaregiver.this, "Pastikan tidak kosong", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass= sqLiteDatabase.checkmailpass(email,pass);
                    if (checkuserpass==true){
                        Toast.makeText(LoginCaregiver.this, "Login sukses", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginCaregiver.this, "login gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
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