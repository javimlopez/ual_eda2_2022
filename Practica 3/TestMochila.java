package practica3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestMochila {
	
	public static void main(String[] args) {  
        
        Objeto[] objetos = new Objeto[10];  
        File archivo1 = null;
		FileReader fr1 = null;
		BufferedReader br1 = null;
		File archivo2 = null;
		FileReader fr2 = null;
		BufferedReader br2 = null;
		File archivo3 = null;
		FileReader fr3 = null;
		BufferedReader br3 = null;
		File archivo4 = null;
		FileReader fr4 = null;
		BufferedReader br4 = null;
		int contador = 0;
		try {
			//Abrimos el archivo y hacemos lectura de los pesos
			archivo1 = new File("C:\\Users\\motal\\git\\ual_eda2_2022\\Practica 3\\docs\\P01\\p01_w.txt");
			fr1 = new FileReader(archivo1);
			br1 = new BufferedReader(fr1);
			archivo2 = new File("C:\\Users\\motal\\git\\ual_eda2_2022\\Practica 3\\docs\\P01\\p01_p.txt");
			fr2 = new FileReader(archivo2);
			br2 = new BufferedReader(fr2);
			archivo3 = new File("C:\\Users\\motal\\git\\ual_eda2_2022\\Practica 3\\docs\\P01\\p01_c.txt");
			fr3 = new FileReader(archivo3);
			br3 = new BufferedReader(fr3);
			String capacidadMochila = br3.readLine();
			String pesoObjeto;
			String valorObjeto;
			//Vamos leyendo las lineas del archivo
			while (((pesoObjeto = br1.readLine()) != null) && (valorObjeto = br2.readLine()) != null) {
				
				Objeto aux = new Objeto(Integer.valueOf(pesoObjeto), Integer.valueOf(valorObjeto));
				objetos[contador] = aux;
				objetos[contador].setNombre(contador);
				contador++;
			}
			
			 Mochila mochila = new Mochila(objetos, Integer.valueOf(capacidadMochila), 0);
		      ProblemaMochila problema = new ProblemaMochila();   
		      problema.resolverProblema(mochila, objetos); 
		      
		       System.out.println ("\nMatriz de valores �ptimos:");  
		        int[][] bestValues = problema.getMatrizOptima();  
		        for (int i=0; i < bestValues.length; i++) {  
		            for (int j=0; j < bestValues[i].length; j++) {
		            	
		            	if(i == 0)
		            		System.out.print("Peso:" + j + "\t");
		            	
		            	else if (j==0) 
		            		System.out.print(objetos[i-1].getNombre() + "\t");
		            	
		            	else	
		                System.out.print("  " + bestValues[i][j] + "\t");  
		            }  
		            System.out.println();  
		        }
		        System.out.println ("\nLista de objetos tras ejecutar el algoritmo:");
		        for (Objeto objeto : mochila.getObjetos()) {
		        	System.out.println(objeto.toString());  
		        }
		        
		        System.out.println("\nLista de objetos seleccionados: ");
		        for (Objeto objeto : mochila.getSeleccionados()) {
		        	System.out.println(objeto.toString());  
		        }
		        
		        System.out.println("");
		        
		        System.out.println ("Valor óptimo:" + problema.getValorOptimo());
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != fr1 && null != fr2 && null != fr3 && null != fr4) {
					fr1.close();
					fr2.close();
					fr3.close();
					fr4.close();
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}	          
	}
}
          
