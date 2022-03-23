package practica_1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
public class NbaTest {
	
	private Nba solucion;
	private ArrayList<Jugador> nba;
	@Before
	//hacemos un metodo para las variables iniciales que vamos a utilizar en los tests
	public void initialize() {
		solucion = new Nba();
		nba = new ArrayList<Jugador>();
		
		//ordenamos el array para hacer más accesible los datos
		solucion.lecturaJugadores(nba, "C:\\Users\\motal\\OneDrive\\Escritorio\\"
				+ "Universidad\\Segundo\\EDA II\\Prácticas\\Practica_01\\NbaStats.csv");
		//medimos el tiempo de ejecucion de nuestro quicksort varias veces para tener una idea sobre el tiempo medio que tarda en realizarse
		double tiempoInicio = System.nanoTime();
		solucion.quicksort(nba, 0, nba.size() - 1);
		double tiempoFinal = System.nanoTime();
		//Imprimimos los 10 mejores ordenados por media
		System.out.println("Tiempo ejecución divide y vencerás: "+(tiempoFinal-tiempoInicio)/1000000000+" segundos\n");
	}
	
	@Test
	public void testNombre() {
		//imprimimos los 10 mejores jugadores segun su puntuacion
		for(int i = 0; i< 10; i++) {
			System.out.print(nba.get(nba.size()-1-i));
		}

		assertEquals(nba.get(nba.size()-1).getNombre(), "Wilt Chamberlain*");
		
	}
	@Test
	public void testMedia() {

		assertEquals(1153.9761875, nba.get(nba.size()-1).getMedia(), 0.0001);
	}
	@Test
	public void testPosiciones() {
	
		assertEquals("[SG, SF, PF]", nba.get(nba.size()-5).getPosiciones().toString());
	}
	@Test
	public void testEquipos() {
	
		assertEquals("[PHW, SFW, TOT, PHI, LAL]", nba.get(nba.size()-1).getEquipos().toString());
	}
	
}

