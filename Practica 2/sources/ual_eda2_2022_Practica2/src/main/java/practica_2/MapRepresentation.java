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
    public static void main(String[] args) {
    	Grafo grafo = new Grafo();
    	lecturaArchivo(grafo, "C:\\Users\\motal\\OneDrive\\Escritorio\\graphEDALand.txt");
    	System.out.println(grafo);
    	Prim algoritmoPrim = new Prim(grafo);
    	System.out.println(algoritmoPrim);
    	
    }
    
}
	 