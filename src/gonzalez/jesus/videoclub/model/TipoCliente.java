package gonzalez.jesus.videoclub.model;

public enum TipoCliente {
	
	SOCIO_FUNDADOR(0.30), 
	SOCIO(0.15), 
	NO_SOCIO(0.0);

	private final double descuento;
	TipoCliente (double descuento) {
		this.descuento = descuento;
		
	}
	
	public double getDescuento() {
		return descuento;
	}
	
}
