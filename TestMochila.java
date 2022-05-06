package practica3;

public class TestMochila {
	
	public static void main(String[] args) {  
		
//		GeneradorObjetos objetosCreadosEnteros = new GeneradorObjetos();
//		objetosCreadosEnteros.creaObjetosInt();
		GeneradorObjetos objetosCreadosReales = new GeneradorObjetos();
		objetosCreadosReales.creaObjetosReales();
		
//		Objeto[] objetosInt = new Objeto[objetosCreadosEnteros.getObjetos().size()];
//		for(int i = 0; i < objetosInt.length; i++) {
//			objetosInt[i] = objetosCreadosEnteros.getObjetos().get(i);
//		}
		
		Objeto[] objetosReales = new Objeto[objetosCreadosReales.getObjetos().size()];
		for(int i = 0; i < objetosReales.length; i++) {
			objetosReales[i] = objetosCreadosReales.getObjetos().get(i);
		}
		
		Mochila mochila = new Mochila(objetosCreadosReales.getCapacidad());	
		ProblemaMochila problema = new ProblemaMochila();   
		problema.resolverProblema(mochila,objetosReales); 
		
//		System.out.println ("\nMatriz de valores óptimos:");  
//		int[][] matrizOptima = problema.getMatrizOptima();  
//		for (int i = 0; i < matrizOptima.length; i++) {  
//			for (int j = 0; j < matrizOptima[i].length; j++) {
//				
//				if(i == 0) {
//					if(j == 0)
//						System.out.print("\t\t");
//					else 	
//						System.out.print(" P:" + (double)j/1000 + "\t");
//				}
//				else if (j==0) 
//					System.out.print(objetosReales[i-1].getNombre() + "  \t");
//	            	
//				else	
//					System.out.print("  " + matrizOptima[i][j] + "\t");  
//			}  
//			System.out.println();  
//		}
		        
		System.out.println("\nLista de objetos seleccionados: ");
		for (Objeto objeto : mochila.getSeleccionados()) {
			System.out.println(objeto.toString());  
		}
		        
		System.out.println("");
		
		System.out.println ("Valor óptimo:" + problema.getValorOptimo());
	}
}
          
