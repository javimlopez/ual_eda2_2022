package practica_2;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
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
		// leer una linea completa utilizando el mï¿½todo readLine().
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
		//AÃ±adimos los nodos al grafo
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
			Arista aristaInversa = new Arista(destinyNode, originNode, peso);
			destinyNode.addArista(aristaInversa);
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

	 
	public static ArrayList<Arista> prim(Grafo grafo, Nodo v){
		//Si los nodos del grafo no contiene el nodo v retorna una lista vacía con los nodos 
		if(!grafo.getNodos().contains(v)) {
			return new ArrayList<Arista>();
		}
		//Creamos una lista con los nodos del grafo a visitar
		ArrayList<Nodo> nodos = grafo.getNodos();
		
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		//ArrayList donde se va a guardar la solución
		ArrayList<Arista> solucion = new ArrayList<Arista>();
		
		int peso = 0;
		//Mientras que la lista de nodos no esté vacía haz:
		while(!nodos.isEmpty()) {
			
			
			//Inicializamos el peso al valor máximo (como si fuera infinito)
			nodos.remove(v);
			peso = Integer.MAX_VALUE;
			Arista aristaElegida = new Arista(v, new Nodo(""), peso);
			//Recorremos las aristas del grafo
			for(Arista arista : v.getAristas()) {
				//Si el ArrayList aristas no contiene a la arista y el nodo de esa arista está en el origen o en el destino añade la arista al Arraylist
				if(!aristas.contains(arista)) {
					aristas.add(arista);
				}
			}	
			//Recorremos las aristas que acabamos de introducir en el ArrayList de aristas
			for(Arista arista: aristas) {
				//Si el peso actual es mayor que el de la arista evaluada y en la lista de nodos está el nodo en el origen
				if(peso>arista.getDistancia() && nodos.contains(arista.getDestino())) {
					//Decimos que el peso menor es el de la arista
					peso = arista.getDistancia();
					aristaElegida.setOrigen(arista.getOrigen());
					aristaElegida.setDestino(arista.getDestino());
					aristaElegida.setDistancia(peso);
				}
				
			}
			solucion.add(aristaElegida);
			v = aristaElegida.getDestino();
		}
		solucion.remove(solucion.size()-1);
		return solucion;
	}
	public static ArrayList<Arista> primColaPrioridad(Grafo grafo, Nodo v){
		
		ArrayList<Arista> solucion = new ArrayList<Arista>();
		ArrayList<Nodo> nodos = grafo.getNodos();
		PriorityQueue<Arista> aristas = new PriorityQueue<Arista>();
		while(!nodos.isEmpty()) {
			nodos.remove(v);
			for(Arista arista : v.getAristas()) {
				if(nodos.contains(arista.getDestino())) {
					aristas.offer(arista);
				}
				
			}
			for(int i= 0; i<aristas.size(); i++) {
				if(!nodos.contains(aristas.peek().getDestino())) {
					aristas.poll();
				}
			}
			v= aristas.peek().getDestino();
			solucion.add(aristas.poll());		
		}
		solucion.remove(solucion.size()-1);
		return solucion;
	}
    public static void main(String[] args) {
//    	Grafo grafo = new Grafo();
//    	lecturaArchivo(grafo, "C:\\Users\\motal\\OneDrive\\Escritorio\\GeneradorGrafo.txt");
    	
    	GeneradorGrafo generador = new GeneradorGrafo();
    	Grafo grafo = generador.crearGrafo(10000);
    	//Grafo grafo1 = generador.crearGrafo(5000);
    	//System.out.println("Grafo \n\n"+ grafo);
    	ArrayList<Arista> solucion = prim(grafo, grafo.getNodo(0));
    	System.out.println("Solucion Prim \n\n" +solucion);
    	//lecturaArchivo(grafo, "C:\\Users\\motal\\OneDrive\\Escritorio\\GeneradorGrafo.txt");
    	//ArrayList<Arista> solucionCola = primColaPrioridad(grafo1, grafo1.getNodo(0));
    	//System.out.println("Solucion Prim con cola de prioridad\n\n" +solucionCola);
    }
    
}
	 