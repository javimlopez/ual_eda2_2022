package practica2;

public class Arista {
    private String origen;
    private String destino;
    private double distancia;
 
    public Arista(String origen, String destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }
 
    public String getOrigen() {
        return origen;
    }
 
    public void setOrigen(String origen) {
        this.origen = origen;
    }
 
    public String getDestino() {
        return destino;
    }
 
    public void setDestino(String destino) {
        this.destino = destino;
    }
 
    public double getDistancia() {
        return distancia;
    }
 
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
 
    @Override
    public String toString() {
        return "\n Origen= " + this.origen + "\n Destino= " + 
        		this.destino + "\n Distancia= " + this.distancia;
    }
 
}