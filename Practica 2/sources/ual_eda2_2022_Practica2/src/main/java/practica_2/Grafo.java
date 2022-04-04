package practica2;
import java.util.ArrayList;

public class Grafo {

	private ArrayList<Nodo> nodos;
	private int nNodos;
	private int nAristas;
	
	public Grafo(int nNodos, int nAristas) {
		//Constructor para grafo aleatorio
	}

	public void addNodo(Nodo nodo) {
		nodos.add(nodo);
	}
	
	public ArrayList<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(ArrayList<Nodo> nodos) {
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
