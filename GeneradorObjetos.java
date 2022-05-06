package practica3;

import java.util.ArrayList;
import java.util.Scanner;
public class GeneradorObjetos {
	
	public GeneradorObjetos() {
		
	}
	
	private int capacidad;
	private ArrayList<Objeto> objetos;
	
	public void creaObjetosInt() {
		this.objetos = new ArrayList<Objeto>();
		System.out.println("Introduzca el numero de objetos: ");
		Scanner sc1 = new Scanner(System.in);
		int numObjetos = sc1.nextInt();
		System.out.println("Introduzca la capacidad de la mochila: ");
		Scanner sc2 = new Scanner(System.in);
		int capacidad = sc2.nextInt();
		this.capacidad = capacidad;
		sc1.close();
		sc2.close();
		for (int i = 0; i < numObjetos; i++) {
			Objeto aux = new Objeto((int)Math.ceil(Math.random()*(capacidad-0.1)),0);
			aux.setValor((int) Math.ceil( Math.random()*(aux.getPeso()*50 + Math.random()*50)));
			aux.setNombre(i);
			objetos.add(aux);
		}
	}
	
	public void creaObjetosReales() {
		this.objetos = new ArrayList<Objeto>();
		System.out.println("Introduzca el numero de objetos: ");
		Scanner sc1 = new Scanner(System.in);
		int numObjetos = sc1.nextInt();
		System.out.println("Introduzca la capacidad de la mochila: ");
		Scanner sc2 = new Scanner(System.in);
		int capacidad = sc2.nextInt();
		this.capacidad = capacidad;
		sc1.close();
		sc2.close();
		for (int i = 0; i < numObjetos; i++) {
			Objeto aux = new Objeto((Math.random()*(capacidad)),0);
			aux.setValor((int) Math.ceil( Math.random()*(aux.getPeso()*50 + Math.random()*50)));
			aux.setNombre(i);
			objetos.add(aux);
		}
	
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(ArrayList<Objeto> objetos) {
		this.objetos = objetos;
	}
	
	
}
