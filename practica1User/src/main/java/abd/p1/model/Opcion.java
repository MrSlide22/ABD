package abd.p1.model;

import javax.persistence.*;

@Entity
@Table(name = "Opciones")
public class Opcion implements Comparable<Opcion> {

	@Id
	@Column(name = "Id_Opcion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Pregunta preguntaMadre;

	@Column(name = "Numero_Orden", nullable = false)
	private Integer numeroOrden;

	@Column(nullable = false)
	private String texto;

	public Opcion() {
		this.preguntaMadre = null;
	}

	public Opcion(int id, int orden, String texto) {
		this.id = id;
		this.numeroOrden = orden;
		this.texto = texto;
		this.preguntaMadre = null;
	}

	public Integer getId() {
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

	public Integer getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(Integer numeroOrden) {
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

	@Override
	public int compareTo(Opcion arg0) {
		return this.getNumeroOrden() - arg0.getNumeroOrden();
	}
}
