package practica3;
import java.util.Scanner;

import java.util.ArrayList;

public class Mochila {
	
	//Objetos que podemos meter en la mochila
	private Objeto[] objetos;
	
	//Objetos introducidos en la mochila
	private ArrayList<Objeto> seleccionados;
	
	//Numero de objetos de la mochila
	private int numObjetos;
	
	//Peso maximo de la mochila
	private int capacidad;

	//Constructor
	public Mochila(Objeto[] objetos, int capacidad) {
		this.objetos = objetos;
		this.numObjetos = objetos.length;
		this.capacidad = capacidad;
		this.seleccionados = new ArrayList<Objeto>();
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

	
	public ArrayList<Objeto> getSeleccionados() {
		return seleccionados;
	}
	
	public int getNumObjetos() {
		return numObjetos;
	}

	public void setNumObjetos(int numObjetos) {
		this.numObjetos = numObjetos;
	}
	
	public void addSeleccionado(Objeto objeto) {
		objeto.setSeleccionado(1);
		this.seleccionados.add(objeto);
	}
	
}
