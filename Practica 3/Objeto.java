package practica3;

public class Objeto {
	
	//Cada objeto tiene un peso y un valor enteros
	private String nombre;
	private int peso;
	private int valor;
	private int seleccionado;
	
	//Constructor por el que se le pasa el peso y el valor
	public Objeto(int peso, int valor) {
		this.nombre = "";
		this.peso = peso;
		this.valor = valor;
		this.seleccionado = 0;
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
	
	public int getSeleccionado() {
		return seleccionado;
	}
	
	//Setters
	public void setNombre(Integer i) {
		this.nombre = "objeto" + i.toString();
	}
	
	public void setSeleccionado(Integer i) {
		this.seleccionado = i;
	}
	
	//toString
	public String toString() {  
		   return nombre + ": [Peso: " + peso + ", valor: " + valor + "]\t" + seleccionado;    
		}
}
