package practica2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Nodo {
    private String nombre;
    private ArrayList<Arista> aristas;
    public Nodo(String nombre) {
        this.nombre = nombre;
        this.aristas = new ArrayList<Arista>();
    }
 
    public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}

	public void addArista(Arista arista) {
		aristas.add(arista);
	}

	public int getnAristas() {
		return aristas.size();
	}
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    @Override
    public String toString() {
        return "Ciudad= " + nombre + aristas.toString() + "\n";
    }
    
    //para kruskal
    
    private ArrayList<Enlace> enlaces;
    private int enlacesExistentes;
    
    public ArrayList<Enlace> getEnlaces()
 	{
 		return enlaces;
 	}
    
    public int getEnlacesExistentes()
 	{
 		return enlacesExistentes;
 	}
    public void agregarEnlace(String enlazar,double peso)
 	{
 		if (enlacesExistentes == -1)
 		{
 			enlaces.add(new Enlace(enlazar,peso));
 			enlacesExistentes++;
 		}
 		else
 		{
 			int posicion;
 			posicion = existeEnlace(enlazar);
 			if (posicion == -1)
 			{
 				enlaces.add(new Enlace(enlazar,peso));
 				enlacesExistentes++;
 			}
 		}
 	}
 
 	public int existeEnlace(String enlazar)
 	{
 		for (int i = 0; i < enlaces.size(); i++)
 		{
 			Enlace miEnlace;
 			miEnlace = enlaces.get(i);
 			if (miEnlace.getDestino().equals(enlazar))
 				return i;
 		}
 		return -1;
 	}
 
 	public double enlacePosicion(int posi)
 	{
 		Enlace miEnlace;
 		miEnlace = enlaces.get(posi);
 		return miEnlace.getPeso();
 	}
 
 	public String NodoPosicion(int posi)
 	{
 		Enlace miEnlace;
 		miEnlace = enlaces.get(posi);
 		return miEnlace.getDestino();
 	}
 
 	boolean eliminarEnlace(int posicion)
 	{
 		if (posicion >= 0 && posicion <= enlaces.size())
 		{
 			enlaces.remove(posicion);
 			enlacesExistentes--;
 			return true;
 		}
 		else
 			JOptionPane.showMessageDialog(null, "No hay enlace en la posicion " + posicion); 
 	 	return false;
 	}
    
}