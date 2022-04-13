package practica2;

import java.util.ArrayList;
import java.io.*;

public class GeneradorGrafo {

	public static Grafo crearGrafo (int nNodos) {
		
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
				
				//Si son iguales creamnos una arista entre los dos nodos
				Arista arista = new Arista(grafo.getNodo(NumAleatorio1),grafo.getNodo(NumAleatorio2),(int)(Math.random() * 1000));
				
				//Si el grafo no contiene esa arista (al ser no dirigido usamos las 
				//condiciones del metodo contieneAristaND) anadimos la arista a grafo
				if (grafo.contieneAristaND(arista) == false) {
					grafo.addArista(arista);
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
		
		return grafo;
	}
	
	public static void main(String[] args) {
		
		Grafo prueba = crearGrafo(10000);
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\titoj\\Desktop\\prueba.txt");
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
