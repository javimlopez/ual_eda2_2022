package practica2;
import java.util.ArrayList;

public class Grafo {

	private ArrayList<Nodo> nodos;
	private ArrayList<Arista> aristas;

	public Grafo() {
	
		this.nodos = new ArrayList<Nodo>();
		this.aristas = new ArrayList<Arista>();
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}

	public void addNodo(Nodo nodo) {
		nodos.add(nodo);
	}

	public ArrayList<Nodo> getNodos() {
		return nodos;
	}
	
	public Nodo getNodo(int indice) {
		return this.getNodos().get(indice);
	}

	public void setNodos(ArrayList<Nodo> nodos) {
		this.nodos = nodos;
	}

	public int getnNodos() {
		return nodos.size();
	}

	public void addArista(Arista arista) {
		aristas.add(arista);
	}

	public int getnAristas() {
		return aristas.size();
	}
	
	public boolean contieneAristaND(Arista arista) {
		
		boolean contiene = false;
		for (Arista ar : this.getAristas()) {
			if ((ar.getDestino() == arista.getDestino() && ar.getOrigen() == arista.getOrigen()) ||
				(ar.getDestino() == arista.getOrigen() && ar.getOrigen() == arista.getDestino())) {
				contiene = true;
			}
		}
		return contiene;
	}
	
	  public String toString() {
	        return "\n Nodos= " + nodos + "\n Aristas= " + aristas.toString() + "\n";
	    }
}
