package abd.p1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Mensajes_De_Texto")
public class MensajeDeTexto {
	
	@Id
	@Column(name = "Id_Mensaje")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Usuario emisor;
	
	@ManyToOne
	private Usuario receptor;
	
	@Column(nullable = false)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column
	private boolean leido;
	
	
	
	public MensajeDeTexto() {
		super();
	}

	public MensajeDeTexto(Integer id, Usuario emisor, Usuario receptor, String texto, Date fecha, boolean leido) {
		super();
		this.id = id;
		this.emisor = emisor;
		this.receptor = receptor;
		this.texto = texto;
		this.fecha = fecha;
		this.leido = leido;
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
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
