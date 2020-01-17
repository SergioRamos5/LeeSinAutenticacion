package com.example.leesinautenticacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    }
}
