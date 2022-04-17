package practica2;

import java.util.ArrayList;

public class Kruskal {
	@SuppressWarnings("unchecked")

	public  Grafo aplicarKruskal(Grafo grafo) {
		Grafo arbol = new Grafo();
		ArrayList<String> nodos = grafo.getNombres();

		for (int j = 0; j < nodos.size(); j++) {
			arbol.ingresarNodo(nodos.get(j));
		}

		//creamos una lista de aristas y la ordenamos en funcion de la distancia de manera ascendente
		ArrayList<Arista> L = (ArrayList<Arista>) grafo.getAristas().clone();

		//seleccionamos la primera arista de L y comprobamos que no haya ciclo en el arbols si lo hay esta se elimina de la lista y no entra en el arbol
		//y si no hay ciclo si se queda en el arbol de recubrimiento
		
		Arista pro = L.get(0);
		arbol.adicionarEnlace(pro.getInicial(), pro.getTerminal(), pro.getDistancia());
		L.remove(pro);

		while (L.size() != 0) {
			pro = L.get(0);

			if (HayCiclo(arbol, pro, arbol.getNodoK(pro.getTerminal()), pro.getTerminal()) == false)
				arbol.adicionarEnlace(pro.getInicial(), pro.getTerminal(), pro.getDistancia());

			L.remove(pro);
		}

		return arbol;
	}
	
	//metodo para la comprobacion de que no se forman ciclos en el arbol al añadir alguna arista
	public  boolean HayCiclo(Grafo g, Arista aVerificar, Nodo terminal, String N) {
		ArrayList<Enlace> aux = terminal.getEnlaces();

		if (aux.size() == 0)
			return false;

		if (terminal.existeEnlace(aVerificar.getInicial()) != -1)
			return true;

		for (int i = 0; i < aux.size(); i++) {
			Enlace nodo = aux.get(i);

			if (nodo.getDestino().equals(N) == false)
				if (HayCiclo(g, aVerificar, g.getNodoK(nodo.getDestino()), terminal.getNombre()))
					return true;
		}

		return false;
	}

}