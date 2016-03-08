package p1admin.model;

public class Ubicacion {

	private Usuario usuarioPadre;
	private double longitud;
	private double altitud;
	
	public Ubicacion(Usuario usuarioPadre, double longitud, double altitud) {
		super();
		this.usuarioPadre = usuarioPadre;
		this.longitud = longitud;
		this.altitud = altitud;
	}
	public Usuario getUsuarioPadre() {
		return usuarioPadre;
	}
	public void setUsuarioPadre(Usuario usuarioPadre) {
		this.usuarioPadre = usuarioPadre;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getAltitud() {
		return altitud;
	}
	public void setAltitud(double altitud) {
		this.altitud = altitud;
	}
}
