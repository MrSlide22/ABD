package p1admin.model;

public class Opcion {
	private Integer id;
	private Pregunta preguntaMadre;
	private int numeroOrden;
	private String texto;
	
	public Opcion() {
		
	}
	
	public Opcion(int id, int orden, String texto){
		this.id = id;
		this.numeroOrden = orden;
		this.texto = texto;
		this.preguntaMadre = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pregunta getPreguntaMadre() {
		return preguntaMadre;
	}

	public void setPreguntaMadre(Pregunta preguntaMadre) {
		this.preguntaMadre = preguntaMadre;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		return "(" + numeroOrden + ") " + texto;
	}
}
