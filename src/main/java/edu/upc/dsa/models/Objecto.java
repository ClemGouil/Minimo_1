package edu.upc.dsa.models;

public class Objecto {

    String id;

    String desc;

    Integer precio;

    public Objecto(String id, String desc, Integer precio) {
        this.id = id;
        this.desc = desc;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Objecto{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
