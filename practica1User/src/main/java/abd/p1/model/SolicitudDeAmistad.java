package abd.p1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Solicitudes_De_Amistad")
public class SolicitudDeAmistad {

	@Id
	@Column(name = "Id_Respuesta")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Usuario emisor;
	
	@ManyToOne
	private Usuario receptor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(nullable = false)
	private boolean leido;
	
	@Column(nullable = false)
	private boolean aceptado;

	public SolicitudDeAmistad() {
		super();
	}

	public SolicitudDeAmistad(Integer id, Usuario emisor, Usuario receptor, Date fecha, boolean leido,
			boolean aceptado) {
		super();
		this.id = id;
		this.emisor = emisor;
		this.receptor = receptor;
		this.fecha = fecha;
		this.leido = leido;
		this.aceptado = aceptado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}
}
