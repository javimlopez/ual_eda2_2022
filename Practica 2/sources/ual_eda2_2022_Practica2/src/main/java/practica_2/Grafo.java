package practica2;
import java.util.ArrayList;
import java.util.Hashtable;

public class Grafo {

	private ArrayList<Nodo> nodos;
	private ArrayList<Arista> aristas;
	private int[][] matrizAdy;
	
	
	//kruskal
	
	Hashtable <String ,Nodo> nodosk;
	ArrayList <String>nombres;

	public Grafo() {
	
		this.nodos = new ArrayList<Nodo>();
		this.aristas = new ArrayList<Arista>();
	}
	
	public int[][] crearMatrizAdy() {
		
        matrizAdy = new int[nodos.size()][nodos.size()];
    
        for(int i=0; i< this.getnNodos(); i++){
        	for(int j=0; j< this.getnNodos(); j++){
        		//Inicializamos los valores de la matriz a 0
        		matrizAdy[i][j] = 0;
        	}            
        }
        
        for(int i=0; i< this.getnNodos(); i++){
        	for(int j=0; j< this.getnNodos(); j++){
        		
        		Arista aux = new Arista(this.nodos.get(i),this.nodos.get(j),0);
        		
        		//Vamos dando valores a la matriz de adyacencia en funcion
        		//de los nodos conectados mediante aristas
        		if(this.contieneAristaND(aux)){
        			matrizAdy[i][j] ++;
        		}
        	}            
        }
     
        return matrizAdy;
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
	    public String printMatrizAdy(){
	    	String salida = "";
	        for(int i=0; i<nodos.size(); i++){
	            for(int j=0; j< nodos.size(); j++){
	                salida += (matrizAdy[i][j] + " " );        
	            }
	            salida += "\n";
	        }  
	        return salida;
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
	
	  public String toString() {
	        return "\n Nodos= " + nodos + "\n Aristas= " + aristas.toString() + "\n";
	    }
	  
	  //para kruskal
	  
	  public ArrayList<String> getNombres()
	 	{
	 		return nombres;
	 	}
	  
		public Hashtable getNodosK()
	 	{
	 		return nodosk;
	 	}
	 	public void setNodosk(Hashtable<String,Nodo > muchos)
	 	{
	 		nodosk=muchos;
	 	}
		public Nodo getNodoK(String nombre)
	 	{
	 		return (Nodo)nodosk.get(nombre);
	 	}
		
		public void ingresarNodo(String nombre)
	 	{
	 		nombres.add(nombre);
	 		nodosk.put(nombre,new Nodo(nombre));
	 	}
		
		public void adicionarEnlace(String nodoInicial,String nodoTerminal,double dist)
	 	{
	 		Arista nuevo=new Arista(nodoInicial,nodoTerminal,dist);
	 		int i=buscarIndice(nuevo.getDistancia());
	 
	 		if(i==-1)
	 			aristas.add(nuevo);
	 		else
	 			aristas.add(i,nuevo);
	 
	 		nodosk.get(nodoInicial).agregarEnlace(nodoTerminal,dist);
	 		nodosk.get(nodoTerminal).agregarEnlace(nodoInicial,dist);
	 	}
		public int buscarIndice(double dist)
	 	{
	 		for(int i=0;i<aristas.size();i++)
	 		{
	  			if(dist<aristas.get(i).getDistancia())
	 				return i;
	 		}
	 		return -1;
	 		}
		
}