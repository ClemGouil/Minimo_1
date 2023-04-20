package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Usuario {

    String id;
    String nombre;
    String apellido;
    Integer cantidadDeVida;
    Integer solda;
    List<Objecto> inventoria;

    Boolean enUnaPartida;


    public Usuario(String id, String nombre, String apellido) {
        this.id =id;
        this.nombre= nombre;
        this.apellido = apellido;
        this.solda = 25;
        this.cantidadDeVida=100;
        this.inventoria = new LinkedList<>();
        this.enUnaPartida = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCantidadDeVida() {
        return cantidadDeVida;
    }

    public void setCantidadDeVida(Integer cantidadDeVida) {
        this.cantidadDeVida = cantidadDeVida;
    }

    public Integer getSolda() {
        return solda;
    }

    public void setSolda(Integer solda) {
        this.solda = solda;
    }

    public void addObjecto(Objecto obj){
        inventoria.add(obj);
    }

    public Boolean IsEnUnaPartida(){
        return this.enUnaPartida;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

}
