package gonzalez.jesus.videoclub.model;

public class Vhs extends Pelicula {
	
	private boolean rebobinada;
	private boolean cintaDanada;
	
	

	public Vhs(int id, String titulo, String genero, boolean disponible, String clasificacion) {
		super(id, titulo, genero, disponible, clasificacion);
		
		this.rebobinada = false;
		this.cintaDanada = false;
		
		// TODO Auto-generated constructor stub
	}
	
		
	public boolean isRebobinada() {
		return rebobinada;
	}
	
	public void setRebobinada(boolean rebobinada) {
		this.rebobinada = rebobinada;
	}
	
	public boolean isCintaDanada() {
		return cintaDanada;
	}
	
	public void setCintaDanada(boolean cintaDanada) {
		this.cintaDanada = cintaDanada;
	}

	@Override
	public double  calcularPrecio() {
		// TODO Auto-generated method stub
		if (cintaDanada) {
		return 4.99;
		} else {
			return 3.99;
		}
		
	}
	
}
