package practica3;

public class Objeto{
	
	//Cada objeto tiene un peso y un valor enteros
	private String nombre;
	private double peso;

	private int valor;
	
	//Constructor por el que se le pasa el peso y el valor
	public Objeto(double peso, int valor) {
		this.nombre = "";
		this.peso = peso;
		this.valor = valor;
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}
	
	public double getPeso() {
		return peso;
	}

	
	public int getValor() {
		return valor;
	}
	
	//Setters
	public void setNombre(Integer i) {
		this.nombre = "objeto" + i.toString();
	}
	
	public void setValor(Integer i) {
		this.valor = i;
	}

	//toString
	public String toString() {  
		   return nombre + ": [Peso: " + peso + ", valor: " + valor + "]   ";    
		}

}
