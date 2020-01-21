package com.example.leesinautenticacion;

public class Prediccion {

    private String cielo;
    private String fecha;
    private long humedad;
    private long temperatura;

    public Prediccion() {
    }

    public Prediccion(String cielo, String fecha, int humedad, int temperatura) {
        this.cielo = cielo;
        this.fecha = fecha;
        this.humedad = humedad;
        this.temperatura = temperatura;
    }

    public String getCielo() {
        return cielo;
    }

    public void setCielo(String cielo) {
        this.cielo = cielo;
    }

    public long getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(long temperatura) {
        this.temperatura = temperatura;
    }

    public long getHumedad() {
        return humedad;
    }

    public void setHumedad(long humedad) {
        this.humedad = humedad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
