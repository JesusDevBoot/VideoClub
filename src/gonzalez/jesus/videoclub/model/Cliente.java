package gonzalez.jesus.videoclub.model;


public class Cliente {
	
	private final int id;
	private String nombre;
	private String email;
	private String telefono;
	private TipoCliente tipoCliente;
	
	public Cliente(int id, 
			String nombre,
			String email,
			String telefono,
			TipoCliente tipoCliente)
			{
		
		if (id <= 0) {
			throw new IllegalArgumentException("El ID del cliente debe ser un número positivo");
		}
		if (email == null || !email.contains("@")) {
				throw new IllegalArgumentException("El email del cliente no es válido");
				
			}
		if (telefono == null || !telefono.matches("\\d{9}")) {
				throw new IllegalArgumentException("El teléfono del cliente debe contener 9 dígitos");
			}
		
		if(nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
			
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.tipoCliente=tipoCliente;
	}
	
	public int getId() {
		return id;
	}
	
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	
	public void setTipoCliente(TipoCliente tipoCliente) {
		
		if(tipoCliente == null) {
	        throw new IllegalArgumentException(
	            "El tipo de cliente es obligatorio");
	    }
		
		this.tipoCliente = tipoCliente;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		
		if(nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
		
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		
		if (email == null || !email.contains("@")) {
			throw new IllegalArgumentException("El email del cliente no es válido");
			
		}
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		
		if (telefono == null || !telefono.matches("\\d{9}")) {
			throw new IllegalArgumentException("El teléfono del cliente debe contener 9 dígitos");
		}
		
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
	    return "Cliente{" +
	            "id=" + id +
	            ", nombre='" + nombre + '\'' +
	            ", email='" + email + '\'' +
	            ", telefono='" + telefono + '\'' +
	            ", tipoCliente=" + tipoCliente +
	            '}';
	}
	

}
