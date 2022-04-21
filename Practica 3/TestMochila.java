package practica3;

public class TestMochila {
	
	public static void main(String[] args) {  
        
        Objeto[] objetos = new Objeto[] {  
                new Objeto(1,10), new Objeto(2,13),  
                new Objeto(2,24), new Objeto(3,15),  
                new Objeto(4,28), new Objeto(5,33),  
                new Objeto(6,20), new Objeto(7, 8)  
        };  
        
        for(Integer i = 0; i < objetos.length; i++) {
        	objetos[i].setNombre(i);
        }
        
        Mochila mochila = new Mochila(objetos,10,0);
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
	        System.out.println ("\nSolución óptima (objetos seleccionados):");  
	        
	        for (Objeto objeto : problema.getSolucionOptima()) {
	        	System.out.println(objeto.toString());  
	        }
	        
	        System.out.println ("Valor óptimo:" + problema.getValorOptimo());  
  
    }  
}