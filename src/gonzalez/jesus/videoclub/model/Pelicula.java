/**
 * Clase abstracta que representa una película del videoclub.
 * Contiene los atributos y comportamientos comunes a todos los tipos de películas.
 *
 * @author Jesús González
 * @version 1.0
 */

package gonzalez.jesus.videoclub.model;


public abstract class Pelicula {
	
	private int id;
	private String titulo;
	private String genero;
	private boolean disponible;
	private String clasificacion;
	
	
	public Pelicula (int id, String titulo, String genero, boolean disponible, String clasificacion) {
		
		
		
		this.id=id;
		this.titulo=titulo;
		this.genero=genero;
		this.disponible=disponible;
		this.clasificacion=clasificacion;
		
	}
	
	
	/**
	 * Calcula el precio de alquiler de la película.
	 *
	 * @return Precio final del alquiler.
	 */
	
	public abstract double calcularPrecio();

	
	@Override
	public String toString() {
	    return "Pelicula [id=" + id +
	           ", titulo=" + titulo +
	           ", genero=" + genero +
	           ", disponible=" + disponible +
	           ", clasificacion=" + clasificacion + "]";
	         
	}
	
		
	// Getter y setter
	
	
	/**
	 * Obtiene el identificador único de la película.
	 *
	 * @return ID de la película.
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	
	
	
	

}
