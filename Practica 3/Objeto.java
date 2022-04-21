package practica3;

public class Objeto {
	
	//Cada objeto tiene un peso y un valor enteros
	private String nombre;
	private int peso;
	private int valor;
	
	//Constructor por el que se le pasa el peso y el valor
	public Objeto(int peso, int valor) {
		this.nombre = "";
		this.peso = peso;
		this.valor = valor;
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public int getValor() {
		return valor;
	}
	
	//SetNombre
	public void setNombre(Integer i) {
		this.nombre = "objeto" + i.toString();
	}
	
	//toString
	public String toString() {  
		   return nombre + ": [Peso: " + peso + ", value: " + valor + "]";    
		}
}
