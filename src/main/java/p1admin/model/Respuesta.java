package p1admin.model;

public class Respuesta {

	private Usuario usuarioPadre;
	private Opcion opcionPadre;
	private float relevancia;
	
	public Respuesta(Usuario usuarioPadre, Opcion opcionPadre, float relevancia) {
		super();
		this.usuarioPadre = usuarioPadre;
		this.opcionPadre = opcionPadre;
		this.relevancia = relevancia;
	}

	public Usuario getUsuarioPadre() {
		return usuarioPadre;
	}

	public void setUsuarioPadre(Usuario usuarioPadre) {
		this.usuarioPadre = usuarioPadre;
	}

	public Opcion getOpcionPadre() {
		return opcionPadre;
	}

	public void setOpcionPadre(Opcion opcionPadre) {
		this.opcionPadre = opcionPadre;
	}

	public float getRelevancia() {
		return relevancia;
	}

	public void setRelevancia(float relevancia) {
		this.relevancia = relevancia;
	}
}
