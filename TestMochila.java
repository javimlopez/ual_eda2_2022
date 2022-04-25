package practica3;

public class TestMochila {
	
	public static void main(String[] args) {  
        
		int capacidad = 50;
		int nObjetos = 20;
        Objeto[] objetos = new GeneradorObjetos(nObjetos,capacidad).getObjetos();
        
        for(Integer i = 0; i < objetos.length; i++) {
        	objetos[i].setNombre(i);
        }
        
        Mochila mochila = new Mochila(objetos,capacidad);
        ProblemaMochila problema = new ProblemaMochila();   
        problema.resolverProblema(mochila, objetos);  
                       
                 System.out.println ("\nMatriz de valores óptimos:");  
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
	        System.out.println ("\nLista de objetos tras ejecutar el alogritmo:");
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
}