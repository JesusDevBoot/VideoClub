package gonzalez.jesus.videoclub.service;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import gonzalez.jesus.videoclub.model.Alquiler;
import gonzalez.jesus.videoclub.model.Cliente;
import gonzalez.jesus.videoclub.model.Pelicula;

public class AlquilerService {
	
		private List<Alquiler> alquileres;
	
	public AlquilerService() {
		this.alquileres = new ArrayList<>();
	}
	
	//metodos
	
	public List<Alquiler> getAlquileres() {
	    return new ArrayList<>(alquileres);
	}
	
	
	public Alquiler crearAlquiler(Cliente cliente, Pelicula pelicula) {
	    if(cliente == null) {
	        throw new IllegalArgumentException("El cliente es obligatorio");
	    }
	    if(pelicula == null) {
	        throw new IllegalArgumentException("La película es obligatoria");
	    }
	    
	    if (!pelicula.isDisponible()) {
	        throw new IllegalStateException("La película no está disponible");
	    }
	    
	    Alquiler alquiler = new Alquiler(
	            cliente,
	            pelicula,
	            LocalDate.now());
	    
	    pelicula.setDisponible(false);
	    alquileres.add(alquiler);
	    return alquiler;
	    
	}
	
	public void devolverAlquiler(Alquiler alquiler) {
	    if(alquiler == null) {
	        throw new IllegalArgumentException("El alquiler es obligatorio");
	    }
	    
	    if(alquiler.isDevuelta()) {
	        throw new IllegalStateException("La película ya ha sido devuelta");
	    }
	    
	    alquiler.devolver();
	    alquiler.getPelicula().setDisponible(true);
	    
	    
	}
	
	public Alquiler buscarAlquilerActivo(Pelicula pelicula) {

	    for (Alquiler alquiler : alquileres) {

	        if (alquiler.getPelicula().equals(pelicula)
	                && !alquiler.isDevuelta()) {

	            return alquiler;
	        }
	    }

	    return null;
	}
	
	
}
