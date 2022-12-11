package upi.edu.hagaibrayens.homescreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class ProfilCaregiver extends AppCompatActivity {

    private TextView etnama, etNomor;
    private TextInputEditText inputnama, inputemail, inputdate;
    private String nama, Nomor, inputNama, inputEmail, inputDate;
    private Button btnlogout;
    private Map<String,Object> data;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_caregiver);
        btnlogout = findViewById(R.id.btnlogout);
        etnama = findViewById(R.id.etnama);
        etNomor = findViewById(R.id.etNomor);
        inputnama = findViewById(R.id.inputnama);
        inputemail = findViewById(R.id.inputemail);
        inputdate = findViewById(R.id.inputdate);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        db.collection("user").whereEqualTo("username", currentUser.getEmail())
                        .get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if(task.isSuccessful()){
                                            for (QueryDocumentSnapshot document : task.getResult()){
                                                data = document.getData();
                                                nama = data.get("nama").toString();
                                                etnama.setText(nama);
                                                Nomor = data.get("hp").toString();
                                                etNomor.setText(Nomor);
                                                inputNama = data.get("nama").toString();
                                                inputnama.setText(inputNama);
                                                inputEmail = data.get("username").toString();
                                                inputemail.setText(inputEmail);
                                                inputDate = data.get("tanggal").toString();
                                                inputdate.setText(inputDate);
                                            }
                                        } else {
                                            Log.w("debugkecil", "error document", task.getException());
                                        }
                                    }
                                });

        btnlogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginCaregiver.class));
            finish();
        });



    }

    public void login(View v){
        FirebaseAuth.getInstance().getCurrentUser();
        startActivity(new Intent(getApplicationContext(), LoginCaregiver.class));
        finish();
    }

    public void home(View v){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }

    public void home(MenuItem item){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }

    public void list(MenuItem item){
        Intent switchActivityIntent = new Intent(this, Riwayat.class);
        startActivity(switchActivityIntent);
    }

    public void set(MenuItem item){
        Intent switchActivityIntent = new Intent(this, setting.class);
        startActivity(switchActivityIntent);
    }

    public void kontak(MenuItem item){
        Intent switchActivityIntent = new Intent(this, ProfilCaregiver.class);
        startActivity(switchActivityIntent);
    }

    public void kontak(View v){
        Intent switchActivityIntent = new Intent(this, ProfilCaregiver.class);
        startActivity(switchActivityIntent);
    }

    public void locRumahsakit(View v){
        Intent switchActivityIntent = new Intent(this, RumahSakitMap.class);
        startActivity(switchActivityIntent);
    }





}