package com.example.leesinautenticacion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
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
    Adaptador mAdapter;
    EditText etCielo, etTemperatura,etHumedad, etFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainv2);

        //region Ejercicio 1
        /*
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

        firebaseDatabase.getReference("items").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                tvSalida.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Toast.makeText(getApplicationContext(),dataSnapshot.getValue().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                tvSalida.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                tvSalida.setText(dataSnapshot.getValue().toString()+" ha sido eliminado");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */
        //endregion

        //region Ejercicio 2
/*
        etCielo = findViewById(R.id.tCielo);
        etTemperatura = findViewById(R.id.tTemperatura);
        etHumedad = findViewById(R.id.tHumedad);

        DatabaseReference dbPred = FirebaseDatabase.getInstance().getReference().child("predicciones-hoy");

        dbPred.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Prediccion p = dataSnapshot.getValue(Prediccion.class);
                etFecha.setText(p.getFecha());
                etCielo.setText(p.getCielo());
                etTemperatura.setText(p.getTemperatura()+"ºC");
                etHumedad.setText(p.getHumedad()+"%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/
        //endregion

        //region Ejercicio 3

        final DatabaseReference dbPred = FirebaseDatabase.getInstance().getReference().child("prediccion");
        FirebaseRecyclerOptions<Prediccion> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<Prediccion>().setQuery(dbPred, Prediccion.class).build();

        final RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new Adaptador(firebaseRecyclerOptions);
        recyclerView.setAdapter(mAdapter);

        mAdapter.onClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Elemento eliminado" + recyclerView.getChildAdapterPosition(v), Toast.LENGTH_LONG).show();
                String key = mAdapter.getRef(recyclerView.getChildAdapterPosition(v)).getKey();
                dbPred.child(key).removeValue();
            }
        });


        //endregion
    }

    @Override
    protected void onDestroy()
    {
        if (firebaseDatabase != null && childEventListener != null)
            firebaseDatabase.getReference("prediccion").removeEventListener(childEventListener);
        super.onDestroy();
    }

    @Override
    protected void onStart()
    {
        mAdapter.startListening();
        super.onStart();
    }

    @Override
    protected void onStop()
    {
        mAdapter.stopListening();
        super.onStop();
    }

}
