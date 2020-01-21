package com.example.leesinautenticacion;

import android.view.View;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;



public class PrediccionHolder extends RecyclerView.ViewHolder  {
    EditText tCielo, tTemparatura,tHumedad,tFecha;

    public PrediccionHolder(View v) {
        super(v);
        tCielo=(EditText) v.findViewById(R.id.tCielo);
        tHumedad=(EditText) v.findViewById(R.id.tHumedad);
        tTemparatura=(EditText) v.findViewById(R.id.tTemperatura);
        tFecha=(EditText)v.findViewById(R.id.tFecha);
    }

    public void bind(Prediccion item) {
        tCielo.setText(item.getCielo() );
        tTemparatura.setText(item.getTemperatura()+"ºC");
        tHumedad.setText(item.getHumedad()+"%");
        tFecha.setText(item.getFecha());
    }
}