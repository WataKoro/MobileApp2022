package upi.edu.hagaibrayens.homescreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register_caregiver extends AppCompatActivity {

    EditText Nama,Mail,Pass,Telp,Alamat,Tgl;
    Button submit;
    DBHelper sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cargiver);

        Nama=findViewById(R.id.Nama);
        Mail=findViewById(R.id.Mail);
        Pass=findViewById(R.id.Pass);
        Alamat=findViewById(R.id.Alamat);
        Telp =findViewById(R.id.Telp);
        Tgl=findViewById(R.id.Tgl);

        submit=findViewById(R.id.submit);
        sqLiteDatabase= new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= Nama.getText().toString();
                String username= Mail.getText().toString();
                String password= Pass.getText().toString();
                String hp= Telp.getText().toString();
                String alamat= Alamat.getText().toString();
                String tanggal= Tgl.getText().toString();

                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(username)||TextUtils.isEmpty(password)
                        ||TextUtils.isEmpty(hp)||TextUtils.isEmpty(alamat)||TextUtils.isEmpty(tanggal))
                    Toast.makeText(register_caregiver.this, "Cek Kembali",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser= sqLiteDatabase.checkmail(user);
                    if(checkuser==false){
                        Boolean insert = sqLiteDatabase.insertData(user,password,username,hp,alamat,tanggal);
                        if (insert==true) {
                            Toast.makeText(register_caregiver.this, "register Berhasil", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginCaregiver.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(register_caregiver.this, "register gagal", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(register_caregiver.this, "akun sudah ada", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }

    public void login(View v){
        Intent switchActivityIntent = new Intent(this, LoginCaregiver.class);
        startActivity(switchActivityIntent);
    }

}