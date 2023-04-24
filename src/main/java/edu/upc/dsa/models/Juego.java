package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Juego {
    Integer numeroEquipos;
    Integer numeroPersonas;
    String Estado;
    List<Equipo> equipos;

    Integer index;

    public Juego(){
        this.Estado = "NO_INICIADO";
    };
    public Juego(Integer numeroEquipos, Integer numeroPersonas) {
        this.numeroEquipos = numeroEquipos;
        this.numeroPersonas = numeroPersonas;
        this.equipos = new LinkedList<>();
        this.Estado = "NO_INICIADO";
        for (int i = 0;i < numeroEquipos;i++){
            this.equipos.add(new Equipo(i,numeroPersonas));
        }
        index =0;
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

    public void addUsuarioPartida(Usuario u) {
        if (getEquipo(index).equipoCompleta == false ){
         getEquipo(index).addPersonasEnEquipo(u);
         index= (index + 1)%this.numeroEquipos;
        } else {
            index= (index + 1)%this.numeroEquipos;
            addUsuarioPartida(u);
        }
    }

    public Equipo getEquipo(Integer numeroEquipos) {
        for (Equipo e: this.equipos) {
            if (e.getNumeroDelEquipo().equals(numeroEquipos)) {
                return e;
            }
        }
        return null;
    }

    public boolean EquipasCompletas(){
        for (Equipo e: this.equipos) {
            if (e.sizeEquipo() < numeroPersonas) {
                return false;
            }
        }
        return true;
    }

}
