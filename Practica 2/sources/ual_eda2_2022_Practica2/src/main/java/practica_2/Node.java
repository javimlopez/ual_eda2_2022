package practica_2;

import java.util.ArrayList;
import java.util.List;
 
public class Node {
	
    private String ciudad;
    private List<Arista> aristas;
 
    public Node(String city) {
        this.ciudad = city;
    }
 
    public String getCity() {
        return ciudad;
    }
 
    public void setCity(String city) {
        this.ciudad = city;
    }
 
    public List<Arista> getEdges() {
        return aristas;
    }
 
    public void addEdge(Arista edge) {
        if (aristas == null) {
            aristas = new ArrayList<Arista>();
        }
        aristas.add(edge);
    }
 
    @Override
    public String toString() {
        return "\n \tNodo [Ciudad: " + ciudad + ", aristas=" + aristas + "]";
    }
}
