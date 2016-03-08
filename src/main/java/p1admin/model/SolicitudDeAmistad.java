package p1admin.model;

import java.util.Date;

public class SolicitudDeAmistad {

	private Usuario emisor;
	private Usuario receptor;
	private Date fecha;
	private boolean leido;
	private boolean aceptado;
	
	public SolicitudDeAmistad(Usuario emisor, Usuario receptor, Date fecha, boolean leido, boolean aceptado) {
		super();
		this.emisor = emisor;
		this.receptor = receptor;
		this.fecha = fecha;
		this.leido = leido;
		this.aceptado = aceptado;
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
