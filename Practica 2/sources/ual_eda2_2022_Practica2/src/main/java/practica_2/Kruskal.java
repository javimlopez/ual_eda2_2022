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

		ArrayList<Arista> L = (ArrayList<Arista>) grafo.getAristas().clone();

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