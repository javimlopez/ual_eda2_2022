package practica_2;

public class Arista implements Comparable<Arista>{
    private Nodo origen;
    private Nodo destino;
    private int distancia;
    private Nodo aux;
    public Arista(Nodo origen, Nodo destino, int distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }
    public Arista() {
    	
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
 
    public int getDistancia() {
        return distancia;
    }
 
	public Arista inversa() {
		this.aux = this.origen;
		this.origen = this.destino;
		this.destino = this.aux;
    	return new Arista(this.origen, this.destino, this.distancia);
	}
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    @Override
    public String toString() {
        return "\n Arista: ( " + this.getOrigen().getNombre() + ", " + 
        		this.destino.getNombre() + ") / Distancia = " + this.distancia;
    }
	@Override
	public int compareTo(Arista o) {
		// TODO Auto-generated method stub
		if(this.distancia > o.getDistancia())
			return 1;
		else if(this.distancia == o.getDistancia())
			return 0;
		else
			return -1;
	}
 
}