package practica_1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import practica_1.*;
public class NbaTest {
	@Test
	public void testNombre() {
		
		Nba solucion = new Nba();
		ArrayList<Jugador> nba = new ArrayList<Jugador>();
		
		solucion.lecturaJugadores(nba, "C:\\Users\\motal\\OneDrive\\Escritorio\\Universidad\\Segundo\\EDA II\\Prácticas\\Practica_01\\NbaStats.csv");
		double tiempoInicio = System.nanoTime();
		//Ordenamos el array utilizando como nuestro algoritmo divide y venceras el algoritmo de ordenacion quicksort.
		//Medimos los tiempos de ejecucion del algoritmo.
		solucion.quicksort(nba, 0, nba.size() - 1);
		double tiempoFinal = System.nanoTime();
		//Imprimimos los 10 mejores ordenados por media
		for(int i = 0; i< 10; i++) {
			System.out.print(nba.get(nba.size()-1-i));
		}
		
		System.out.println("Tiempo ejecución divide y vencerás: "+(tiempoFinal-tiempoInicio)/1000000000+" segundos");
		
		assertEquals(nba.get(nba.size()-1).getNombre(), "Wilt Chamberlain*");
		
	}
	@Test
	public void testMedia() {
		Nba solucion = new Nba();
		ArrayList<Jugador> nba = new ArrayList<Jugador>();
		solucion.lecturaJugadores(nba, "C:\\Users\\motal\\OneDrive\\Escritorio\\Universidad\\Segundo\\EDA II\\Prácticas\\Practica_01\\NbaStats.csv");
		solucion.quicksort(nba, 0, nba.size()-1);
		assertEquals(1153.9761875, nba.get(nba.size()-1).getMedia(), 0.0001);
	}
	@Test
	public void testPosiciones() {
		Nba solucion = new Nba();
		ArrayList<Jugador> nba = new ArrayList<Jugador>();
		solucion.lecturaJugadores(nba, "C:\\Users\\motal\\OneDrive\\Escritorio\\Universidad\\Segundo\\EDA II\\Prácticas\\Practica_01\\NbaStats.csv");
		solucion.quicksort(nba, 0, nba.size()-1);
		assertEquals("[SG, SF, PF]", nba.get(nba.size()-5).getPosiciones().toString());
	}
	@Test
	public void testEquipos() {
		Nba solucion = new Nba();
		ArrayList<Jugador> nba = new ArrayList<Jugador>();
		solucion.lecturaJugadores(nba, "C:\\Users\\motal\\OneDrive\\Escritorio\\Universidad\\Segundo\\EDA II\\Prácticas\\Practica_01\\NbaStats.csv");
		solucion.quicksort(nba, 0, nba.size()-1);
		assertEquals("[PHW, SFW, TOT, PHI, LAL]", nba.get(nba.size()-1).getEquipos().toString());
	}
	
}
