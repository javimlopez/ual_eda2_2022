package org.eda2.practica3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.lang.*;
class TestMochila {
	/*
	 *  Recomendable comentar cada test y lanzarlo por separado
	 */
	@Test
	void testMochilaEnteros() {
		
		GeneradorObjetos objetosCreadosEnteros = new GeneradorObjetos();
		objetosCreadosEnteros.creaObjetosInt();
		Objeto[] objetosInt = new Objeto[objetosCreadosEnteros.getObjetos().size()];
		for (int i = 0; i < objetosInt.length; i++) {
			objetosInt[i] = objetosCreadosEnteros.getObjetos().get(i);
		}
		Mochila mochilaEnteros = new Mochila(objetosCreadosEnteros.getCapacidad());
		ProblemaMochila problemaEnteros = new ProblemaMochila();
		double tiempoInicio = System.nanoTime();
		problemaEnteros.resolverProblema(mochilaEnteros, objetosInt);
		double tiempoFinal =System.nanoTime();
		
		System.out.println("\nMatriz de valores optimos:");
		int[][] matrizOptima = problemaEnteros.getMatrizOptima();
		for (int i = 0; i < matrizOptima.length; i++) {
			for (int j = 0; j < matrizOptima[i].length; j++) {

				if (i == 0) {
					if (j == 0)
						System.out.print("\t\t");
					else
						System.out.print("P" + (double)j/1000+ "\t");
				} else if (j == 0)
					System.out.print(objetosInt[i - 1].getNombre() + "  \t");

				else
					System.out.print("  " + matrizOptima[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("\nLista de objetos seleccionados: ");
		for (Objeto objeto : mochilaEnteros.getSeleccionados()) {
			System.out.println(objeto.toString());
		}

		System.out.println("");

		System.out.println("Valor optimo:" + problemaEnteros.getValorOptimo());
		
		System.out.println("Tiempo que ha tardado el algoritmo con 20 objetos y capacidad de la mochila de 5 "+ (tiempoFinal-tiempoInicio)*0.000000001);
	}
//	@Test
//	void testMochilaReales() {
//		GeneradorObjetos objetosCreadosReales = new GeneradorObjetos();
//		objetosCreadosReales.creaObjetosReales();
//		Objeto[] objetosReales = new Objeto[objetosCreadosReales.getObjetos().size()];
//		for(int i = 0; i < objetosReales.length; i++) {
//			objetosReales[i] = objetosCreadosReales.getObjetos().get(i);
//		}
//		Mochila mochilaReales = new Mochila(objetosCreadosReales.getCapacidad());
//		double tiempoInicio = System.nanoTime();
//		ProblemaMochila problemaReales = new ProblemaMochila();
//		double tiempoFinal = System.nanoTime();
//		problemaReales.resolverProblema(mochilaReales, objetosReales);
//		
//		
//		
//		System.out.println("\nMatriz de valores optimos:");
//		int[][] matrizOptima = problemaReales.getMatrizOptima();
//		for (int i = 0; i < matrizOptima.length; i++) {
//			for (int j = 0; j < matrizOptima[i].length; j++) {
//
//				if (i == 0) {
//					if (j == 0)
//						System.out.print("\t\t");
//					else
//						System.out.print("P" + (double)j/1000+ "\t");
//				} else if (j == 0)
//					System.out.print(objetosReales[i - 1].getNombre() + "  \t");
//
//				else
//					System.out.print("  " + matrizOptima[i][j] + "\t");
//			}
//			System.out.println();
//		}
//
//		System.out.println("\nLista de objetos seleccionados: ");
//		for (Objeto objeto : mochilaReales.getSeleccionados()) {
//			System.out.println(objeto.toString());
//		}
//
//		System.out.println("");
//
//		System.out.println("Valor optimo:" + problemaReales.getValorOptimo());
//		
//		System.out.println("Tiempo que ha tardado el algoritmo con 20 objetos y capacidad de la mochila de 5: "+ (tiempoFinal-tiempoInicio)*0.000000001);
//	
//	}
//	void testMochilaGreedyReales() {
//		GeneradorObjetos objetosCreadosReales = new GeneradorObjetos();
//		objetosCreadosReales.creaObjetosReales();
//		Objeto[] objetosReales = new Objeto[objetosCreadosReales.getObjetos().size()];
//		for(int i = 0; i < objetosReales.length; i++) {
//			objetosReales[i] = objetosCreadosReales.getObjetos().get(i);
//		}
//		Mochila mochilaReales = new Mochila(objetosCreadosReales.getCapacidad());
//		ProblemaMochila problemaReales = new ProblemaMochila();
//		double tiempoInicio = System.nanoTime();
//		System.out.println(problemaReales.greedy(mochilaReales, objetosReales));
//		double tiempoFinal = System.nanoTime();
//		System.out.println("Tiempo que ha tardado el algoritmo con 20 objetos y capacidad de la mochila de 5: "+ (tiempoFinal-tiempoInicio)*0.000000001);
//	}
//	void testMochilaGreedyEnteros() {
//		
//		GeneradorObjetos objetosCreadosEnteros = new GeneradorObjetos();
//		objetosCreadosEnteros.creaObjetosInt();
//		Objeto[] objetosInt = new Objeto[objetosCreadosEnteros.getObjetos().size()];
//		for (int i = 0; i < objetosInt.length; i++) {
//			objetosInt[i] = objetosCreadosEnteros.getObjetos().get(i);
//		}
//		Mochila mochilaEnteros = new Mochila(objetosCreadosEnteros.getCapacidad());
//		ProblemaMochila problemaEnteros = new ProblemaMochila();
//		double tiempoInicio = System.nanoTime();
//		System.out.println(problemaEnteros.greedy(mochilaEnteros, objetosInt));
//		double tiempoFinal = System.nanoTime();
//		System.out.println("Tiempo que ha tardado el algoritmo con 20 objetos y capacidad de la mochila de 5: "+ (tiempoFinal-tiempoInicio)*0.000000001);
//	}

}
