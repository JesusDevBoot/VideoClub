package gonzalez.jesus.videoclub.model;

public class Cliente {
	
	private final int id;
	private String nombre;
	private String email;
	private String telefono;
	
	public Cliente(int id, String nombre, String email, String telefono) {
		
		if (id <= 0) {
			throw new IllegalArgumentException("El ID del cliente debe ser un número positivo");
		}
		if (email == null || !email.contains("@")) {
				throw new IllegalArgumentException("El email del cliente no es válido");
				
			}
		if (telefono == null || !telefono.matches("\\d{9}")) {
				throw new IllegalArgumentException("El teléfono del cliente debe contener 9 dígitos");
			}
			
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}
	
	public int getId() {
		return id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
	    return "Cliente{" +
	            "id=" + id +
	            ", nombre='" + nombre + '\'' +
	            ", email='" + email + '\'' +
	            ", telefono='" + telefono + '\'' +
	            '}';
	}
	

}
