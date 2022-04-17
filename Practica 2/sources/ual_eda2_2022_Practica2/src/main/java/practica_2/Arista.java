package practica2;

public class Arista {
    private Nodo origen;
    private Nodo destino;
    private double distancia;
 
    public Arista(Nodo origen, Nodo destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }
 
    public Nodo getOrigen() {
        return origen;
    }
 
    public void setOrigen(Nodo origen) {
        this.origen = origen;
    }
 
    public Nodo getDestino() {
        return destino;
    }
 
    public void setDestino(Nodo destino) {
        this.destino = destino;
    }
 
    public double getDistancia() {
        return distancia;
    }
 
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    public Arista inversa() {
    	Nodo destinoInv = this.origen;
    	Nodo origenInv = this.destino;
    	
    	Arista inversa = this;
    	
    	inversa.setDestino(destinoInv);
    	inversa.setOrigen(origenInv);
    	
    	return inversa;
    }
 
    @Override
    public String toString() {
        return "\n Arista: " + "Ciudades (" + this.origen.getNombre() + ", " + 
        		this.destino.getNombre() + ") / Distancia = " + this.distancia;
    }
    
    //para kruskal
    
    private String inicial;
 	private String terminal;
 	
 	public Arista(String ini, String ter, double pes)
 	{
 		inicial = ini;
 		terminal = ter;
 		distancia = pes;
 	}
    public Arista() {
		// TODO Auto-generated constructor stub
	}

	public String getInicial()
 	{
 		return inicial;
 	}
 
 	public void setInicial(String inicial)
 	{
 		this.inicial = inicial;
 	}
 
 	public String getTerminal()
 	{
 		return terminal;
 	}
 
 	public void setTerminal(String terminal)
 	{
 		this.terminal = terminal;
 	}
}

