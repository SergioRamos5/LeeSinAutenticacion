package com.example.leesinautenticacion;

public class Prediccion {

    private String cielo;
    private int temperatura;
    private int humedad;
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Prediccion() {
    }

    public Prediccion(String cielo, int temperatura, int humedad) {
        this.cielo = cielo;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public String getCielo() {
        return cielo;
    }

    public void setCielo(String cielo) {
        this.cielo = cielo;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }
}
