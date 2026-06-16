package gonzalez.jesus.videoclub.service;

import java.util.ArrayList;
import java.util.List;

import gonzalez.jesus.videoclub.model.Pelicula;

public class PeliculaService {
	
	private List<Pelicula> peliculas;
	
	public PeliculaService() {
		this.peliculas = new ArrayList<>();
	}
	
	//Agregar metodos
	
	public void agregarPelicula(Pelicula pelicula) {
		if (pelicula == null) {
			throw new IllegalArgumentException("La película es obligatoria");
		}
		
		if(buscaPorId(pelicula.getId()) != null) {
		    throw new IllegalArgumentException(
		        "Ya existe una película con ese ID");
		}
		this.peliculas.add(pelicula);
	}
	
	public List<Pelicula> getPeliculas() {
	    return new ArrayList<>(peliculas);
	}
	
	public Pelicula buscaPorId(int id) {
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getId() == id) {
				return pelicula;
				
			}
		}
		
		return null;
	}
	
	public boolean eliminarPelicula(int id) {
		
		Pelicula pelicula = buscaPorId(id);
		if( pelicula != null) {
			peliculas.remove(pelicula);
		
				return true;
			}
			return false;
	}
	
	public List<Pelicula> peliculasDisponibles() {

	    List<Pelicula> disponibles = new ArrayList<>();

	    for(Pelicula pelicula : peliculas) {

	        if(pelicula.isDisponible()) {
	            disponibles.add(pelicula);
	        }
	    }

	    return disponibles;
	}

}
