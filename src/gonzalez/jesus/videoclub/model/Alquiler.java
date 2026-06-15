package gonzalez.jesus.videoclub.model;

import java.time.LocalDate;

public class Alquiler {
	
	private final Cliente cliente;
	private final Pelicula pelicula;
	private final LocalDate fechaAlquiler;
	private boolean devuelta;
	private LocalDate fechaDevolucion;
	
	public Alquiler(Cliente cliente, Pelicula pelicula, LocalDate fechaAlquiler) {

		if (cliente == null) {
			throw new IllegalArgumentException("El cliente es obligatorio");
		}
		if (pelicula == null) {
			throw new IllegalArgumentException("La película es obligatoria");
		}
		if (fechaAlquiler == null) {
			throw new IllegalArgumentException("La fecha de alquiler es obligatoria");
		}

		this.cliente = cliente;
		this.pelicula = pelicula;
		this.fechaAlquiler = fechaAlquiler;
		this.devuelta = false;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	
	public Cliente getCliente() {
	    return cliente;
	}
		

	public Pelicula getPelicula() {
	    return pelicula;
	}

	public LocalDate getFechaAlquiler() {
	    return fechaAlquiler;
	}

	public boolean isDevuelta() {
	    return devuelta;
	}
	
	public void devolver() {

	    if(devuelta) {
	        throw new IllegalStateException(
	                "La película ya ha sido devuelta");
	    }

	    this.devuelta = true;
	    this.fechaDevolucion = LocalDate.now();
	}
	
	public double calcularPrecioFinal() {

	    double precioBase = pelicula.calcularPrecio();

	    double descuento =
	            precioBase *
	            cliente.getTipoCliente().getDescuento();

	    return precioBase - descuento;
	}
	
	
	
	
}
