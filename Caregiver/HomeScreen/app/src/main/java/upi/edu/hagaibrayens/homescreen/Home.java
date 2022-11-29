package upi.edu.hagaibrayens.homescreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView = findViewById(R.id.nama_akun);
//        String emailfromIntent = getIntent().getStringExtra("Email");
//        textView.setText(emailfromIntent);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseUser!=null){
            textView.setText(firebaseUser.getDisplayName());
        }
        else {
            textView.setText("Login gagal");
        }
    }

    public void scan(View v){
        Intent switchActivityIntent = new Intent(this, ScanQR.class);
        startActivity(switchActivityIntent);
    }

    public void home(View v){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }

    public void home(MenuItem item){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }


    public void list(View v){
        Intent switchActivityIntent = new Intent(this, Riwayat.class);
        startActivity(switchActivityIntent);
    }

    public void list(MenuItem item){
        Intent switchActivityIntent = new Intent(this, Riwayat.class);
        startActivity(switchActivityIntent);
    }

    public void set(View v){
        Intent switchActivityIntent = new Intent(this, setting.class);
        startActivity(switchActivityIntent);
    }

    public void set(MenuItem item){
        Intent switchActivityIntent = new Intent(this, setting.class);
        startActivity(switchActivityIntent);
    }

    public void kontak(View v){
        Intent switchActivityIntent = new Intent(this, ProfilCaregiver.class);
        startActivity(switchActivityIntent);
    }

    public void kontak(MenuItem item){
        Intent switchActivityIntent = new Intent(this, ProfilCaregiver.class);
        startActivity(switchActivityIntent);
    }

    public void loc(View v){
        Intent switchActivityIntent = new Intent(this, LansiaMap.class);
        startActivity(switchActivityIntent);
    }

    public void locRumahsakit(View v){
        Intent switchActivityIntent = new Intent(this, RumahSakitMap.class);
        startActivity(switchActivityIntent);
    }

    public void bantuan(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Pergi Menolong ?")
                .setTitle("")
                .setPositiveButton("Pergi", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // mulai
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // batal
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}