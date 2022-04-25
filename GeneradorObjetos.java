package practica3;

public class GeneradorObjetos {
	private Objeto[] objetos;
	
	public Objeto[] getObjetos() {
		return objetos;
	}

	public void setObjetos(Objeto[] objetos) {
		this.objetos = objetos;
	}

	public GeneradorObjetos(int numObjetos, int capacidad) {
		for (int i = 0; i < numObjetos; i++) {
			this.objetos[i] = new Objeto(0,0);
			this.objetos[i].setNombre(i);
			this.objetos[i].setSeleccionado(0);
			this.objetos[i].setPeso(capacidad);
			this.objetos[i].setValor();
		}
	}
	
	

}
