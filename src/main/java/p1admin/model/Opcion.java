package p1admin.model;

public class Opcion {
<<<<<<< HEAD
	private Integer id;
=======
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	private Pregunta preguntaMadre;
	private int numeroOrden;
	private String texto;
	
	public Opcion() {
		
	}
<<<<<<< HEAD
	
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
=======
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf

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
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
		return "(" + numeroOrden + ") " + texto;
	}
}
