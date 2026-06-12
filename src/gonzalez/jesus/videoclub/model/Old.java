package gonzalez.jesus.videoclub.model;

public class Old extends Pelicula {
	
	private int anioLanzamiento;
	private boolean remasterizada;

	public Old(int id, String titulo, String genero, boolean disponible, String clasificacion, double precio,int anioLanzamiento, boolean remasterizada) {
		super(id, titulo, genero, disponible, clasificacion );
		
		if (anioLanzamiento < 1900 || anioLanzamiento > 2024) {
			throw new IllegalArgumentException("El año de lanzamiento debe estar entre 1900 y 2024");
		}
		
		this.anioLanzamiento = anioLanzamiento;
		this.remasterizada = remasterizada;
		
	}

	public int getAnioLanzamiento() {
		return anioLanzamiento;
	}
	
	public void setAnioLanzamiento(int anioLanzamiento) {
		if (anioLanzamiento < 1900 || anioLanzamiento > 2024) {
			throw new IllegalArgumentException("El año de lanzamiento debe estar entre 1900 y 2024");
		}
		this.anioLanzamiento = anioLanzamiento;
	}
	
	public boolean getRemasterizada() {
		return remasterizada;
	}
	
	public void setRemasterizada(boolean remasterizada) {
		this.remasterizada = remasterizada;
	}

	@Override
	public double calcularPrecio() {
		// TODO Auto-generated method stub
		if (remasterizada) {
			return 3.99;
		} else {
			return 2.99;
		}
		
	}
	
	

}
