package abd.p1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Invitaciones_A_Pregunta")
public class InvitacionAPregunta {

	@Id
	@Column(name = "Id_Invitacion_Pregunta")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Pregunta preguntaPadre;
	
	@ManyToOne
	private Usuario emisor;
	
	@ManyToOne
	private Usuario receptor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date fecha;
	
	@Column
	private boolean leido;
	
	

	public InvitacionAPregunta() {
		super();
	}

	public InvitacionAPregunta(Integer id, Pregunta preguntaPadre, Usuario emisor, Usuario receptor, Date fecha,
			boolean leido) {
		super();
		this.id = id;
		this.preguntaPadre = preguntaPadre;
		this.emisor = emisor;
		this.receptor = receptor;
		this.fecha = fecha;
		this.leido = leido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pregunta getPreguntaPadre() {
		return preguntaPadre;
	}

	public void setPreguntaPadre(Pregunta preguntaPadre) {
		this.preguntaPadre = preguntaPadre;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}
}
