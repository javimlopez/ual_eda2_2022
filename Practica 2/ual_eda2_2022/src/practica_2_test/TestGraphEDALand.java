package practica_2_test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import practica_2.Arista;
import practica_2.Grafo;
import practica_2.MapRepresentation;
class TestGraphEDALand {

	@Test
	void main(String[] args) {
		MapRepresentation map = new MapRepresentation();
    	Grafo grafo = new Grafo();
    	map.lecturaArchivo(grafo, "C:\\Users\\motal\\OneDrive\\Escritorio\\graphEDALand.txt");
    	System.out.println(grafo);
    	ArrayList<Arista> solucion = map.prim(grafo, grafo.getNodo(0));
    	System.out.println(solucion);
    	String resultado = "[\r\n"
    			+ " Arista: ( Almeria, Granada) / Distancia = 173, \r\n"
    			+ " Arista: ( Granada, Jaen) / Distancia = 99, \r\n"
    			+ " Arista: ( Almeria, Murcia) / Distancia = 224, \r\n"
    			+ " Arista: ( Murcia, Albacete) / Distancia = 150, \r\n"
    			+ " Arista: ( Albacete, Valencia) / Distancia = 191, \r\n"
    			+ " Arista: ( Jaen, Sevilla) / Distancia = 242, \r\n"
    			+ " Arista: ( Sevilla, Huelva) / Distancia = 92, \r\n"
    			+ " Arista: ( Sevilla, Cadiz) / Distancia = 125, \r\n"
    			+ " Arista: ( Huelva, Badajoz) / Distancia = 234, \r\n"
    			+ " Arista: ( Badajoz, Caceres) / Distancia = 90, \r\n"
    			+ " Arista: ( Albacete, Madrid) / Distancia = 251, \r\n"
    			+ " Arista: ( Madrid, Valladolid) / Distancia = 193, \r\n"
    			+ " Arista: ( Valladolid, Bilbao) / Distancia = 280, \r\n"
    			+ " Arista: ( Bilbao, Oviedo) / Distancia = 304, \r\n"
    			+ " Arista: ( Bilbao, Zaragoza) / Distancia = 324, \r\n"
    			+ " Arista: ( Zaragoza, Barcelona) / Distancia = 296, \r\n"
    			+ " Arista: ( Barcelona, Gerona) / Distancia = 100, \r\n"
    			+ " Arista: ( Gerona, Lerida) / Distancia = 222, \r\n"
    			+ " Arista: ( Valladolid, Vigo) / Distancia = 356, \r\n"
    			+ " Arista: ( Vigo, Corunya) / Distancia = 171]";
    	assertEquals(solucion, resultado);
    	
    }

}
