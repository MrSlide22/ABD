package p1admin.model;

import java.util.Date;

public class InvitacionAPregunta {

	private Pregunta preguntaPadre;
	private Usuario emisor;
	private Usuario receptor;
	private Date fecha;
	private boolean leido;
	
	public InvitacionAPregunta(Pregunta preguntaPadre, Usuario emisor, Usuario receptor, Date fecha, boolean leido) {
		super();
		this.preguntaPadre = preguntaPadre;
		this.emisor = emisor;
		this.receptor = receptor;
		this.fecha = fecha;
		this.leido = leido;
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
