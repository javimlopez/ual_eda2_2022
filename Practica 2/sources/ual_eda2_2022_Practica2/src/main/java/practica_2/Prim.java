package practica2;

import java.util.ArrayList;

public class Prim {

	
	Grafo prim; //Declaramos el grafo	
	ArrayList<Arista> paths = new ArrayList<Arista>();
	ArrayList<Arista> tmp = new ArrayList<Arista>();
	ArrayList<Nodo> nodos = new ArrayList<Nodo>();
	ArrayList<Nodo> cola = new ArrayList<Nodo>();
	ArrayList<ArrayList<Nodo>> contenedor =new ArrayList<ArrayList<Nodo>>();
	
	public Prim(Grafo grafo) {
		//Inicializamos grafo
		prim = new Grafo();
		//Clonamos los nodos del grafo mandado.
		nodos = (ArrayList<Nodo>) grafo.getNodos().clone();
		//Creamos una variable temporal de nodos
		Nodo tempo= grafo.getNodo(0);
		//Tempo es igual al primer nodo de la lista
		//Utilizamos método encontrarArista que nos devuelve el arco de menor coste del vertice tempo
		Arista ar = encontrarArista(tempo);
		//Añadimos la primera arista al conjunto de la solucion
		prim.getAristas().add(ar);
		ArrayList<Nodo> copi = new ArrayList<Nodo>();
		copi.add(ar.getOrigen());
		copi.add(ar.getDestino());
		contenedor.add(copi);
		do {
			Arista br = encontrarArista2(contenedor.get(0));
			if(ciclo(br)==false)
				prim.getAristas().add(br);
		}while(contenedor.get(0).size()<grafo.getNodos().size());
		prim.toString();
	}
	public Arista encontrarArista(Nodo n) {
		Integer menor = 0;
		int i = 0;
		Arista tempo = new Arista();
		//Cogemos todas las aristas del nodo
		for(Arista ap: n.getAristas()) {
			if(i++==0) {
				//De primeras el primer elemento va a ser el menor
				menor=(int) ap.getDistancia();
				tempo= ap;
			}
			else {
				//Si la distancia del menor es mayor que el de la nueva arista, el menor es la nueva arista
				if(menor>ap.getDistancia()) {
					menor= (int)ap.getDistancia();
					tempo=ap;
				}
			}
		}
		//Metodo que recibe una arista y, para ambos nodos destino y origen, elimina el camino de los candidatos
		findPath(tempo);
		return tempo;
	}
	public Arista encontrarArista2(ArrayList<Nodo> n) {
		Integer menor = 0;
		int i = 0;
		Arista tempo = new Arista();
		for(Nodo op: n) {
			for(Arista ap: op.getAristas()) {
				if(i++==0) {
					menor= (int)ap.getDistancia();
					tempo=ap;
				}
				else {
					if(menor>ap.getDistancia()) {
						menor= (int)ap.getDistancia();
						tempo=ap;
					}
				}
			}
		}
		findPath(tempo);
		return(tempo);
	}
	public boolean ciclo(Arista comprobar) {
		boolean s=true;
		if(contenedor.get(0).contains(comprobar.getOrigen()) && contenedor.get(0).contains(comprobar.getDestino())) {
			return true;
		}
		else {
			if(contenedor.get(0).contains(comprobar.getOrigen()) == false && contenedor.get(0).contains(comprobar.getDestino())==false) {
				ArrayList<Nodo> tm = new ArrayList<Nodo>();
				tm.add(comprobar.getOrigen());
				tm.add(comprobar.getDestino());
				contenedor.add(tm);
				return false;
			}
			else
			{
				if(contenedor.get(0).contains(comprobar.getOrigen())==true && contenedor.get(0).contains(comprobar.getDestino())==false) {
					if(contenedor.size()==1) {
						contenedor.get(0).add(comprobar.getDestino());
						return false;
					}
					else
					{
						int ban = 0;
						for(ArrayList<Nodo> m : contenedor) {
							for(Nodo n: m) {
								if(n.equals(comprobar.getDestino())) {
									for(Nodo o: m) {
										ban=1;
										contenedor.get(0).add(o);
									}
								}
							}
						}
					}
				}
			}
		}
		return s;
	}
	
	public void findPath(Arista fin) {
		
		if(fin.getDestino().getAristas().isEmpty() != true && fin.getOrigen().getAristas().isEmpty() != true) {
			if(fin.getDestino().getAristas().contains(fin)) {
				fin.getDestino().getAristas().remove(fin);
			}
			if(fin.getOrigen().getAristas().contains(fin)) {
				fin.getOrigen().getAristas().remove(fin);
			}
		}
	}
	
}