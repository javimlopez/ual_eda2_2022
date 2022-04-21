package practica3;

import java.util.ArrayList;

public class ProblemaMochila {
	
	//Matriz de decision optima
	private int[][] matrizOptima;
	
	//Valor optimo para cada caso de la matriz
	private int valorOptimo;
	
	//Lista de objetos para la solucion optima
	private ArrayList<Objeto> solucionOptima = new ArrayList<Objeto>();
	
	public ProblemaMochila() {
		
	}
	
	public void resolverProblema(Mochila mochila, Objeto[] objetos) {
		//Inicializamos la matriz optima
		if(matrizOptima == null) 
			matrizOptima = new int [mochila.getNumObjetos()+1][mochila.getCapacidad()+1];
		
		//Comenzamos dando formato a la salida final mostrando
		//la lista de objetos para llenar la mochila
		System.out.println("Lista de objetos");
		for(int i = 0; i < objetos.length; i++) {
			
			//Les damos nombres a los objetos para diferenciarlos
			objetos[i].setNombre(i);
			
			System.out.println(objetos[i].toString());
		}
		
		//Mostramos la capacidad maxima de la mochila (peso maximo)
		System.out.println("Capacidad de la mochila (peso maximo): " + mochila.getCapacidad());
		
		// encuentra el valor optimo  
        for (int i = 0; i <= mochila.getCapacidad(); i++) {  
            for (int j = 0; j <= mochila.getNumObjetos(); j++) {  
              
                if (j == 0 || i == 0) {  
                    matrizOptima[j][i] = 0;  
                }     
                else   
                {  
                	// Si el peso de la mochila con el elemento j es mayor que la capacidad,   
                	// la solucion optima existe en las primeras mochilas j-1  
                    if (i < objetos[j-1].getPeso()) {  
                        matrizOptima[j][i] = matrizOptima[j-1][i];  
                    }     
                    else   
                    {  
                       
                        int jpeso = objetos[j-1].getPeso();  
                        int jvalor = objetos[j-1].getValor();
                        
                        // Si no se supera la capacidad, comparamos el valor de 
                    	// introducir o no el elemento
                        // Si el valor de no introducirlo es mayor o igual al de introducirlo
                        // el valor optimo en ese caso sera no hacerlo
                        if(matrizOptima[j-1][i] >= jvalor + matrizOptima[j-1][i-jpeso])
                        	matrizOptima[j][i] = matrizOptima[j-1][i];  
                        else
                        	//en caso contrario lo introduciremos
                        	matrizOptima[j][i] = jvalor + matrizOptima[j-1][i-jpeso];  
                    } // else  
                } //else           
           } //for  
        } //for 
        
     // Creamos la solucion optima a partir de la matriz  
        if (solucionOptima == null) {  
            solucionOptima = new ArrayList<Objeto>();  
        }  
        
        int pesoAct = mochila.getCapacidad();  
        
        for (int i=mochila.getNumObjetos(); i >= 1; i--) {  
        	//Si el valor de una posicion en la matriz es mayor que el 
        	//que tiene encima anadimos a la solucion el objeto que
        	//se anadio en esa fila de la matriz
           if (matrizOptima[i][pesoAct] > matrizOptima[i-1][pesoAct]) {
        	   solucionOptima.add(objetos[i-1]);
        	   
        	   //Le quitamos el peso del objeto que acabamos de anadir
               pesoAct -= objetos[i-1].getPeso();  
           }  
           
           //Cuando el peso restante sea 0 salimos del bucle
           if (pesoAct == 0)  
        	   break;  
        }  
        valorOptimo = matrizOptima[mochila.getNumObjetos()][mochila.getCapacidad()];  
    } 
	
	public int getValorOptimo() {
		return valorOptimo;
	}
	
	public int[][] getMatrizOptima() {
		return matrizOptima;
	}
	
	public ArrayList<Objeto> getSolucionOptima() {  
        return solucionOptima;  
    } 
}
