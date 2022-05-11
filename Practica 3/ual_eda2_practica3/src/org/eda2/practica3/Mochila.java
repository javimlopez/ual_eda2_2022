package org.eda2.practica3;

import java.util.ArrayList;

public class Mochila {

	// Objetos introducidos en la mochila
		private ArrayList<Objeto> seleccionados;

		// Peso maximo de la mochila
		private int capacidad;

		// Constructor
		public Mochila(int capacidad) {
			this.capacidad = capacidad;
			this.seleccionados = new ArrayList<Objeto>();
		}

		// Getters y setters
		public int getCapacidad() {
			return capacidad;
		}

		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}

		public ArrayList<Objeto> getSeleccionados() {
			return seleccionados;
		}

		public void addSeleccionado(Objeto objeto) {
			this.seleccionados.add(objeto);
		}
}
