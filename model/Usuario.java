package p1admin.model;

import java.sql.Date;
import java.util.List;

public class Usuario {

	private String correo;
	private String pass;
	private Busca busca;
	private Genero sexo;
	private String nombre;
	private String descripcion;
	private byte[] avatar;
	private Date fechaDeNacimiento;
	private List<Aficiones> aficiones;
	private List<Ubicacion> ubicaciones;
	private List<Usuario> amigos;

	public Usuario(String correo, String pass, Busca busca, Genero sexo, String nombre, String descripcion,
			byte[] avatar, Date fechaDeNacimiento, List<Aficiones> aficiones, List<Ubicacion> ubicaciones) {
		super();
		this.correo = correo;
		this.pass = pass;
		this.busca = busca;
		this.sexo = sexo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.avatar = avatar;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.aficiones = aficiones;
		this.ubicaciones = ubicaciones;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Busca getBusca() {
		return busca;
	}

	public void setBusca(Busca busca) {
		this.busca = busca;
	}

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}

	public List<Aficiones> getAficiones() {
		return aficiones;
	}

	public void setAficiones(List<Aficiones> aficiones) {
		this.aficiones = aficiones;
	}

	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public List<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}
}
