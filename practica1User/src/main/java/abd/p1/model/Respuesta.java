package abd.p1.model;

import javax.persistence.*;

@Entity
@Table(name = "Respuestas")
public class Respuesta {

	@Id
	@Column(name = "Id_Respuesta")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Usuario usuarioPadre;
	
	@ManyToOne
	private Opcion opcionPadre;
	
	@Column(nullable = false)
	private float relevancia;
	
	
	
	public Respuesta() {
		super();
	}
	public Respuesta(Integer id, Usuario usuarioPadre, Opcion opcionPadre, float relevancia) {
		super();
		this.id = id;
		this.usuarioPadre = usuarioPadre;
		this.opcionPadre = opcionPadre;
		this.relevancia = relevancia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
