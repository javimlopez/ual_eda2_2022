package practica_1;

public class MergeSort {  
	public static void merge(int[]a,int low,int mid,int high){
		// Combina dos matrices ordenadas
		int[]b=new int[high-low+1];   
		int s=low;   
		int t=mid+1;   
		int k=0;   
		while(s<=mid&&t<=high){
		    if(a[s]<=a[t])     
		       b[k++]=a[s++];    
		     else     
			b[k++]=a[t++];   
		}   
		
		while(s<=mid)    
			b[k++]=a[s++];   
			
		while(t<=high)       
			b[k++]=a[t++];   
			
		for(int i=0;i<b.length;i++){
		    a[low+i]=b[i];   
		}  
	}  
	
	public static void mergesort(int a[],int low,int high){
		 // Ordenar recursivamente la matriz
		if(low<high){
			mergesort(a,low,(low+high)/2);                                             
			mergesort(a,(low+high)/2+1,high);    
		    merge(a,low,(high+low)/2,high);   
		}  
	}  
	
	public static void main(String[]args){
	   int[]a={4, 20, 12, 1, 7, 18, 30, 23};   
	    System.out.println ("La matriz antes de ordenar es:");
	   for(int i=0;i<a.length;i++){    
		System.out.print(a[i]+" "); 
	   }   
	   
	   mergesort(a,0,a.length-1);   
	    System.out.println("\nLa matriz después de ordenar es:");
	   for(int i=0;i<a.length;i++){    
		System.out.print(a[i]+" ");
	   }   
	} 
	
}
