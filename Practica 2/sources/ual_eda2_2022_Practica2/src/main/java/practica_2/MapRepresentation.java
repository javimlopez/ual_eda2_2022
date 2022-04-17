package practica_2;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapRepresentation {
 
	public static void lecturaArchivo(Grafo grafo, String dir) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int numVertices, numAristas;
		int tipoGrafo;
		try {
		// Apertura del fichero y creacion de BufferedReader para poder
		// leer una linea completa utilizando el m�todo readLine().
		archivo = new File(dir);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);
		// Lectura del fichero
		String linea;
		linea = br.readLine();
		//Lee el tipo del grafo, si es 0 es un grafo no dirigido
		tipoGrafo = Integer.valueOf(linea);
		linea = br.readLine();
		//Lee el numero de nodos que tiene el grafo
		numVertices = Integer.valueOf(linea);
		//Añadimos los nodos al grafo
		for(int i=0; i<numVertices; i++) {
			linea = br.readLine();
			Nodo aux = new Nodo(linea);
			grafo.addNodo(aux);
		}
		//Leemos el numero de aristas del archivo
		numAristas = Integer.valueOf(br.readLine());
		
		//Vamos leyendo las lineas del archivo
		for(int i= 0; i<numAristas; i++) {
			
			//Separamos con un split cada linea, para posteriormente hacer un switch que
			// introduzca al jugador auxiliar los valores relevantes:
			linea = br.readLine();
			String[] separado = linea.split(" ");
			String originName = separado[0];
					//Nodo origen = new Nodo(separado[0]);
			String destinyName = separado[1];
					//Nodo destino = new Nodo(separado[1]);
			int peso = Integer.valueOf(separado[2]);
			
			int originPos = -1;
			int destinyPos = -1; 
			
			for(int j=0; j<grafo.getnNodos(); j++) {
				if(grafo.getNodo(j).getNombre().equals(originName) ) {
					originPos = j;
				} else if(grafo.getNodo(j).getNombre().equals(destinyName)) {
					destinyPos = j;
				}
			}
			
			if (originPos == -1 ) throw new Exception("Node not found:"+ originName +" !!!");
			if (destinyPos == -1 ) throw new Exception("Node not found:"+ destinyName +" !!!");

			Nodo originNode = grafo.getNodo(originPos);
			Nodo destinyNode = grafo.getNodo(destinyPos);
			
			Arista arista = new Arista(originNode, destinyNode, peso);
			originNode.addArista(arista);
			destinyNode.addArista(arista);
			
			grafo.getNodos().set(originPos, originNode);
			grafo.getNodos().set(destinyPos, destinyNode);
		}

		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != fr) {
					fr.close();
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static ArrayList<Nodo> grafoPrim(Grafo grafo, Nodo v){
		if(!grafo.getNodos().contains(v)) {
			return new ArrayList<Nodo>();
		}
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		ArrayList<Nodo> solucion = new ArrayList<Nodo>();
		
		nodos.addAll(grafo.getNodos());
		nodos.remove(v);
		solucion.add(v);
		Nodo aux = new Nodo("");
		int peso = 0;
		while(!nodos.isEmpty()) {
			peso = Integer.MAX_VALUE;
			aux.setNombre("");
		
			for(Arista arista : grafo.getAristas()) {
				if(!aristas.contains(arista) && (arista.getOrigen().equals(v) || arista.getDestino().equals(v))) {
					aristas.add(arista);
				}
			}
			for(Arista arista: aristas) {
				if(peso>arista.getDistancia() && nodos.contains(arista.getOrigen())) {
					peso = arista.getDistancia();
					aux = arista.getOrigen();
				}else if (peso > arista.getDistancia() && nodos.contains(arista.getDestino())) {
					peso = arista.getDistancia();
					aux = arista.getDestino();
				}
			}
			if (aux == null) {
				return new ArrayList<Nodo>();
			}
			nodos.remove(aux);
			solucion.add(aux);
			v = aux;
		}
		return solucion;
	}
    public static void main(String[] args) {
    	Grafo grafo = new Grafo();
    	lecturaArchivo(grafo, "C:\\Users\\motal\\OneDrive\\Escritorio\\graphEDALand.txt");
    	System.out.println(grafo);
    	ArrayList<Nodo> solucion = grafoPrim(grafo, grafo.getNodo(0));
    	System.out.println(solucion);
    	
    }
    
}
	 