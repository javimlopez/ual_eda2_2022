package practica3;

import java.util.ArrayList;
import java.util.Arrays;

public class ProblemaMochila {
	
	//Matriz de decision optima
	private int[][] matrizOptima;
	
	//Valor optimo para cada caso de la matriz
	private double valorOptimo;
	
	//Lista de objetos para la solucion optima
	private ArrayList<Objeto> solucionOptima = new ArrayList<Objeto>();
	
	public ProblemaMochila() {
	}
	
	public void resolverProblema(Mochila mochila, Objeto[] objetos) {
		//Inicializamos la matriz optima
		
		if(matrizOptima == null) 
			matrizOptima = new int [objetos.length+1][mochila.getCapacidad()*100+1];
	
		//Comenzamos dando formato a la salida final mostrando
		//la lista de objetos para llenar la mochila
		System.out.println("Lista de objetos para introducir:");
		for(int i = 0; i < objetos.length; i++) {
			
			//Les damos nombres a los objetos para diferenciarlos
			objetos[i].setNombre(i);
			
			
			System.out.println(objetos[i].toString());
		}
		
		//Mostramos la capacidad maxima de la mochila (peso maximo)
		System.out.println("Capacidad de la mochila (peso maximo): " + mochila.getCapacidad());
		
		// encuentra el valor optimo  
        for (int i = 0; i <= mochila.getCapacidad()*100; i++) {  
            for (int j = 0; j <= objetos.length; j++) {  
              
                if (j == 0 || i == 0) {  
                    matrizOptima[j][i] = 0;  
                }     
                else   
                {  
                	// Si se supera la capacidad con el elemento que queremos introducir,   
                	// el valor optimo en ese caso es no meterlo, por lo que cogemos el anterior
                    if (i < objetos[j-1].getPeso()*100) {  
                        matrizOptima[j][i] = matrizOptima[j-1][i];  
                    }     
                    else   
                    {  
                    	int jpeso = (int) objetos[j-1].getPeso()*100;  
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
        
        //Inicializamos el peso restante como la capacidad de la mochila
        int pesoAct = mochila.getCapacidad()*100;  
        
        //Recorremos valores en la matriz desde la ultima fila
        for (int i=objetos.length; i >= 1; i--) {  
        	
        	//Si el valor de una posicion en la matriz es mayor que el 
        	//que tiene encima anadimos a la solucion el objeto que
        	//se anadio en esa fila de la matriz
           if (matrizOptima[i][pesoAct] > matrizOptima[i-1][pesoAct]) {
        	   mochila.addSeleccionado(objetos[i-1]);
        	   
        	   //Le quitamos el peso del objeto que acabamos de anadir
               pesoAct -= objetos[i-1].getPeso()*100;  
           }  
           
           //Cuando el peso restante sea 0 salimos del bucle
           if (pesoAct == 0)  
        	   break;  
        }  
        valorOptimo = matrizOptima[objetos.length][mochila.getCapacidad()*100];  
        solucionOptima = mochila.getSeleccionados();
    } 
	
	public double getValorOptimo() {
		return valorOptimo;
	}
	
	public int[][] getMatrizOptima() {
		return matrizOptima;
	}
	
	public ArrayList<Objeto> getSolucionOptima() {  
        return solucionOptima;  
    } 
}