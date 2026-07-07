package gonzalez.jesus.videoclub.model;

import java.time.LocalDate;

public class Novedad extends Pelicula {
	
	private LocalDate  fechaLanzamiento;
	private boolean enCartelera;

	public Novedad(int id, String titulo, String genero, boolean disponible, String clasificacion,  LocalDate fechaLanzamiento, boolean enCartelera) {
		super(id, titulo, genero, disponible, clasificacion);
		// TODO Auto-generated constructor stub
		if (fechaLanzamiento == null) {
		    throw new IllegalArgumentException(
		        "La fecha de lanzamiento es obligatoria");
		}
		this.fechaLanzamiento = fechaLanzamiento;
		this.enCartelera = enCartelera;
		
	}


	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		if (fechaLanzamiento == null) {
		    throw new IllegalArgumentException(
		        "La fecha de lanzamiento es obligatoria");
		}
		this.fechaLanzamiento = fechaLanzamiento;
	}
	
	public boolean getEnCartelera() {
		return enCartelera;
	}
	
	public void setEnCartelera(boolean enCartelera) {
		this.enCartelera = enCartelera;
	}


	@Override
	public double calcularPrecio() {
		// TODO Auto-generated method stub
		if (enCartelera) {
			return 5.99;
		} else {
			return 4.99;
			}
		}
	
	@Override
	public String toString() {
		return "Novedad [fechaLanzamiento=" + fechaLanzamiento + ", enCartelera=" + enCartelera + ", getId()="
				+ getId() + ", getTitulo()=" + getTitulo() + ", getGenero()=" + getGenero() + ", isDisponible()="
				+ isDisponible() + ", getClasificacion()=" + getClasificacion() + "]";
	}
}
		
	
	
	



