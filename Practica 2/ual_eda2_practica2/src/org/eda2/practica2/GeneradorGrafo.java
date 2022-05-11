package org.eda2.practica2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GeneradorGrafo {

public Grafo crearGrafo (int nNodos) {
		
		//Grafo vacio
		Grafo grafo = new Grafo();
		if (nNodos < 1) return grafo;
		Integer i = 0;
		
		//Llenado del grafo con tantos nodos como se hayan introducido en el metodo crearGrafo
		while(grafo.getnNodos() < nNodos) {
			Nodo nodo = new Nodo("nombre" + i.toString());
			grafo.addNodo(nodo);
			i++;
		}
		
		if (nNodos == 1) return grafo;
		//ArrayList de nodos conectados vacio ya que de momento no hay ninguna arista
		ArrayList<Nodo> conectados = new ArrayList<Nodo>(); 
		
		//bucle para ir introduciendo aristas al grafo hasta que todos sus nodos esten conectados
		while(conectados.size() != grafo.getnNodos()) {
			
			//Se generan dos numeros aleatorios entre el 0 y el numero de nodos de grafo-1
			int NumAleatorio1 = (int) Math.floor((Math.random() * (grafo.getnNodos())));
			int NumAleatorio2 = (int) Math.ceil((Math.random() * (grafo.getnNodos())))-1;
			
			//Si los dos numeros son iguales no hacemos nada ya que queremos aristas entre diferentes nodos 
			 if (NumAleatorio1 != NumAleatorio2) {
				int peso = (int)(Math.random() * 1000);
				//Si son iguales creamnos una arista entre los dos nodos
				Arista arista = new Arista(grafo.getNodo(NumAleatorio1),grafo.getNodo(NumAleatorio2), peso);
				
				//Si el grafo no contiene esa arista (al ser no dirigido usamos las 
				//condiciones del metodo contieneAristaND) anadimos la arista a grafo
				if (grafo.contieneAristaND(arista) == false) {
					Nodo aux1 = grafo.getNodo(NumAleatorio1);
					Nodo aux2 = grafo.getNodo(NumAleatorio2);
					int pos1 = grafo.getNodos().indexOf(aux1);
					int pos2 = grafo.getNodos().indexOf(aux2);
					Arista aristaInversa = new Arista(aux2, aux1, peso);
					aux1.addArista(arista);
					aux2.addArista(aristaInversa);
					grafo.getNodos().set(pos1, aux1);
					grafo.getNodos().set(pos2, aux2);
				}
				
				//Si conectados esta vacio, le anadimos los dos nodos de la primera arista
				if (conectados.isEmpty()) {
					conectados.add(arista.getOrigen());
					conectados.add(arista.getDestino());
				}
				
				//Si contiene solo uno de los nodos de la arista, le anadimos el nodo que no tiene
				
				if(!conectados.contains(arista.getOrigen()) && conectados.contains(arista.getDestino())) {
					conectados.add(arista.getOrigen());
				}
				
				if(conectados.contains(arista.getOrigen()) && !conectados.contains(arista.getDestino())) {
					conectados.add(arista.getDestino());
				}
			 }	 
		}
		
		//Creamos la matriz de adyacencia del grafo
		grafo.crearMatrizAdy();
		
		return grafo;
	}
	
	public static void main(String[] args) {
		GeneradorGrafo generador = new GeneradorGrafo();
		Grafo prueba = generador.crearGrafo(50);
		System.out.println(prueba.printMatrizAdy());
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\motal\\OneDrive\\Escritorio\\GeneradorGrafo.txt");
            pw = new PrintWriter(fichero);
            pw.println(prueba.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
}
