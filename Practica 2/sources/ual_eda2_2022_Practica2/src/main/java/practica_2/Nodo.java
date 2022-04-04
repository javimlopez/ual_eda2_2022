package practica2;

import java.util.ArrayList;

public class Nodo {
    private String nombre;
    private ArrayList<Arista> aristas = new ArrayList<Arista>();
 
    public Nodo(String nombre) {
        this.nombre = nombre;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public ArrayList<Arista> getAristas() {
        return aristas;
    }
 
    public void addArista(Arista arista) {
        aristas.add(arista);
    }
 
    @Override
    public String toString() {
        return "\n Ciudad= " + nombre + "\n Aristas= " + aristas + "\n";
    }
}