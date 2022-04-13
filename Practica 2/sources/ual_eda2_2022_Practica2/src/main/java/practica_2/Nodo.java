package practica2;

import java.util.ArrayList;

public class Nodo {
    private String nombre;
 
    public Nodo(String nombre) {
        this.nombre = nombre;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    @Override
    public String toString() {
        return "Ciudad= " + nombre;
    }
}