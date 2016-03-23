package p1admin.model;

import java.util.Date;

public class MensajeDeTexto {
	
	private Usuario emisor;
	private Usuario receptor;
	private String texto;
	private Date fecha;
	private boolean leido;
	
	public MensajeDeTexto(Usuario emisor, Usuario receptor, String texto, Date fecha, boolean leido) {
		super();
		this.emisor = emisor;
		this.receptor = receptor;
		this.texto = texto;
		this.fecha = fecha;
		this.leido = leido;
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
