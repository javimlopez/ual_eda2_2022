package practica_2;
import java.util.ArrayList;

public class Grafo {

	private ArrayList<String> nodos;
	private ArrayList<Arista> aristas;
	private int nNodos;
	private int nAristas;
	
	public Grafo(int nNodos, int nAristas) {
		//Constructor para grafo aleatorio
	}

	public void addNodo(String nodo) {
		nodos.add(nodo);
	}
	
	public ArrayList<String> getNodos() {
		return nodos;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}

	public void setNodos(ArrayList<String> nodos) {
		this.nodos = nodos;
	}

	public int getnNodos() {
		return nNodos;
	}

	public void setnNodos(int nNodos) {
		this.nNodos = nNodos;
	}

	public int getnAristas() {
		return nAristas;
	}

	public void setnAristas(int nAristas) {
		this.nAristas = nAristas;
	}
}
