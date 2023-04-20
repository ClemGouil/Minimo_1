package edu.upc.dsa.models;

import java.util.List;

public class Juego {
    Integer numeroEquipos;
    Integer numeroPersonas;
    String Estado;

    public Juego(){};
    public Juego(Integer numeroEquipos, Integer numeroPersonas) {
        this.numeroEquipos = numeroEquipos;
        this.numeroPersonas = numeroPersonas;
        Estado = "NO_INICIADO";
    }

    public Integer getNumeroEquipos() {
        return numeroEquipos;
    }

    public void setNumeroEquipos(Integer numeroEquipos) {
        this.numeroEquipos = numeroEquipos;
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }


}
