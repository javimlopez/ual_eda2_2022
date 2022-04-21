package practica3;

public class Mochila {
	
	//Objetos que tiene dentro
	private Objeto[] objetos;
	
	//Numero de objetos de la mochila
	private int numObjetos;
	
	//Peso maximo de la mochila
	private int capacidad;
	
	//Peso actual
	private int pesoActual;

	//Constructor
	public Mochila(Objeto[] objetos, int capacidad, int pesoactual) {
		this.objetos = objetos;
		this.numObjetos = objetos.length;
		this.capacidad = capacidad;
		this.pesoActual = 0;
	}
	
	//Getters y setters
	public Objeto[] getObjetos() {
		return objetos;
	}

	public void setObjetos(Objeto[] objetos) {
		this.objetos = objetos;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getPesoActual() {
		return pesoActual;
	}

	public void setPesoActual(int pesoActual) {
		this.pesoActual = pesoActual;
	}

	public int getNumObjetos() {
		return numObjetos;
	}

	public void setNumObjetos(int numObjetos) {
		this.numObjetos = numObjetos;
	}

}
