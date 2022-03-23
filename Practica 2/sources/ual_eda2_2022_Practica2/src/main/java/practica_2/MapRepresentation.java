package practica_2;
import java.io.*;

public class MapRepresentation {
 
	public static void lecturaArchivo(Graph grafo, String dir) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int numVertices, numAristas;
		int tipo;
		try {
		// Apertura del fichero y creacion de BufferedReader para poder
		// leer una linea completa utilizando el método readLine().
		archivo = new File(dir);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);
		// Lectura del fichero
		String linea;
		linea = br.readLine();
		tipo = Integer.valueOf(linea);
		linea = br.readLine();
		numVertices = Integer.valueOf(linea);
		Node aux = new Node("");
		for(int i=0; i<numVertices; i++) {
			linea = br.readLine();
			aux.setCity(linea);
			grafo.addNode(aux);
		}
		numAristas = Integer.valueOf(linea = br.readLine());
		
		//Vamos leyendo las lineas del archivo
		for(int i= 0; i<numAristas; i++){
			
			//Separamos con un split cada linea, para posteriormente hacer un switch que
			// introduzca al jugador auxiliar los valores relevantes:
			String[] separado = linea.split(" ");
				for (int j = 0; j <= separado.length; j++) {
					switch (i) {
					case 0:
						
						break;
					case 1:
						break;
					case 2: break;
					default:
						break;
			
					}
				}
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
    public static Graph getCities() {
    	
        Node df = new Node("DF");
        Node toluca = new Node("Toluca");
        Node cuernavaca = new Node("Cuernavaca");
        Node puebla = new Node("Puebla");
        Node tlaxcala = new Node("Tlaxcala");
 
        df.addEdge(new Edge(df, toluca, 100));
        df.addEdge(new Edge(df, cuernavaca, 90));
 
        toluca.addEdge(new Edge(toluca, cuernavaca, 150));
        toluca.addEdge(new Edge(toluca, puebla, 350));
        toluca.addEdge(new Edge(toluca, tlaxcala, 340));
 
        cuernavaca.addEdge(new Edge(cuernavaca, puebla, 100));
 
        puebla.addEdge(new Edge(puebla, tlaxcala, 20));
 
        Graph graph = new Graph();
        graph.addNode(df);
        graph.addNode(toluca);
        graph.addNode(cuernavaca);
        graph.addNode(puebla);
        return graph;
    }
 
    public static void main(String[] args) {
    	Graph grafo = new Graph();
    	lecturaArchivo(grafo, "C:\\Users\\motal\\git\\practica2\\dataset\\graphEDALand");
        System.out.println(grafo);
    }
}