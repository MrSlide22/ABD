package p1admin.model;

public class Aficiones {

	private Usuario usuarioPadre;
	private String aficion;
	
	public Aficiones(Usuario usuarioPadre, String aficion) {
		super();
		this.usuarioPadre = usuarioPadre;
		this.aficion = aficion;
	}
	public Usuario getUsuarioPadre() {
		return usuarioPadre;
	}
	public void setUsuarioPadre(Usuario usuarioPadre) {
		this.usuarioPadre = usuarioPadre;
	}
	public String getAficion() {
		return aficion;
	}
	public void setAficion(String aficion) {
		this.aficion = aficion;
	}
}
