package p1admin.model;

public class Amigo {

	private Usuario usuarioPadre;
	private Usuario amigo;
	
	public Amigo(Usuario usuarioPadre, Usuario amigo) {
		super();
		this.usuarioPadre = usuarioPadre;
		this.amigo = amigo;
	}
	public Usuario getUsuarioPadre() {
		return usuarioPadre;
	}
	public void setUsuarioPadre(Usuario usuarioPadre) {
		this.usuarioPadre = usuarioPadre;
	}
	public Usuario getAmigo() {
		return amigo;
	}
	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}	
}
