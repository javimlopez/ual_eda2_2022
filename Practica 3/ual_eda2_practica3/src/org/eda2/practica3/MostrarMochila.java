package org.eda2.practica3;

public class MostrarMochila {

	public static void main(String[] args) {

		GeneradorObjetos objetosCreadosEnteros = new GeneradorObjetos();
		objetosCreadosEnteros.creaObjetosInt();
		GeneradorObjetos objetosCreadosReales = new GeneradorObjetos();
		objetosCreadosReales.creaObjetosReales();

		Objeto[] objetosInt = new Objeto[objetosCreadosEnteros.getObjetos().size()];
		for (int i = 0; i < objetosInt.length; i++) {
			objetosInt[i] = objetosCreadosEnteros.getObjetos().get(i);
		}

		Objeto[] objetosReales = new Objeto[objetosCreadosReales.getObjetos().size()];
		for(int i = 0; i < objetosReales.length; i++) {
			objetosReales[i] = objetosCreadosReales.getObjetos().get(i);
		}

		Mochila mochilaReales = new Mochila(objetosCreadosReales.getCapacidad());
		ProblemaMochila problemaReales = new ProblemaMochila();
		problemaReales.resolverProblema(mochilaReales, objetosReales);
		
		Mochila mochilaEnteros = new Mochila(objetosCreadosEnteros.getCapacidad());
		ProblemaMochila problemaEnteros = new ProblemaMochila();
		problemaEnteros.resolverProblema(mochilaEnteros, objetosInt);
		
		System.out.println("\nMatriz de valores optimos:");
		int[][] matrizOptima = problemaReales.getMatrizOptima();
		for (int i = 0; i < matrizOptima.length; i++) {
			for (int j = 0; j < matrizOptima[i].length; j++) {

				if (i == 0) {
					if (j == 0)
						System.out.print("\t\t");
					else
						System.out.print("P" + (double)j/1000+ "\t");
				} else if (j == 0)
					System.out.print(objetosReales[i - 1].getNombre() + "  \t");

				else
					System.out.print("  " + matrizOptima[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("\nLista de objetos seleccionados: ");
		for (Objeto objeto : mochilaReales.getSeleccionados()) {
			System.out.println(objeto.toString());
		}

		System.out.println("");

		System.out.println("Valor optimo:" + problemaReales.getValorOptimo());
		
//		System.out.println(problema.greedy(mochila, objetosReales));
	}
}
