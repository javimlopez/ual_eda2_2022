package org.eda2.practica2;

import java.util.ArrayList;

public class Nodo {

	private String nombre;
    private ArrayList<Arista> aristas;
    public Nodo(String nombre) {
        this.nombre = nombre;
        this.aristas = new ArrayList<Arista>();
    }
 
    public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}

	public void addArista(Arista arista) {
		aristas.add(arista);
	}

	public int getnAristas() {
		return aristas.size();
	}
    public String getNombre() {
        return this.nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    @Override
    public String toString() {
        return nombre + aristas.toString() + "\n";
    }
    
}
