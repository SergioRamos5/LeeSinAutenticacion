package com.example.leesinautenticacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText etTexto;
    Button btEnviar;
    TextView tvSalida;
    ChildEventListener childEventListener;
    FirebaseDatabase firebaseDatabase;
    Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTexto = findViewById(R.id.etTexto);
        tvSalida = findViewById(R.id.tvSalida);
        btEnviar = findViewById(R.id.btEnviar);

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dato = FirebaseDatabase.getInstance().getReference().child("items").child("msg");

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etTexto.getText().toString().isEmpty())
                {
                    firebaseDatabase.getReference("items").push().setValue(new Items(etTexto.getText().toString()));
                }
            }
        });

        dato.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(getApplicationContext(),(String)dataSnapshot.getValue(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
