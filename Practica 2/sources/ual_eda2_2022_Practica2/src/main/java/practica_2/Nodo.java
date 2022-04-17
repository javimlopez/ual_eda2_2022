package practica_2;

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
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    @Override
    public String toString() {
        return nombre + aristas.toString() + "\n";
    }
}