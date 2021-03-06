package abd.p1.model;

import abd.p1.controller.UsuarioObserver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Transient
    private ArrayList<UsuarioObserver> obs;

    @Id
    @Column(name = "Id_Correo_Usuario")
    private String correo;

    @Column(nullable = false, length = 512)
    private String pass;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Busca busca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero sexo;

    @Column(nullable = false, length = 64)
    private String nombre;

    @Column
    private String descripcion;

    @Lob
    private byte[] avatar;

    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> aficiones;

    @Column
    private Double longitud;

    @Column
    private Double latitud;

    @ManyToMany
    private List<Usuario> amigos;

    public Usuario() {
        this.obs = new ArrayList<>();
        this.aficiones = new ArrayList<>();
    }

    public Usuario(String correo, String pass, Busca busca, Genero sexo, String nombre, String descripcion,
            byte[] avatar, Date fechaDeNacimiento, List<String> aficiones, Double longitud, Double latitud) {
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
        this.longitud = longitud;
        this.latitud = latitud;

        this.obs = new ArrayList<>();
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
        
        for (UsuarioObserver o : obs) {
            o.onPassChange(this.pass);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        for (UsuarioObserver o : obs) {
            o.onNombreChange(this.nombre);
        }
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
        
        for (UsuarioObserver o : obs) {
            o.onAvatarChange(this.avatar);
        }
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
        for (UsuarioObserver o : obs) {
            o.onFechaDeNacimientoChange(this.fechaDeNacimiento);
        }
    }

    public Busca getBusca() {
        return busca;
    }

    public void setBusca(Busca busca) {
        this.busca = busca;
        
        for (UsuarioObserver o : obs) {
            o.onPreferenciaChange(this.busca);
        }
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
        
        for (UsuarioObserver o : obs) {
            o.onSexoChange(this.sexo);
        }
    }

    public List<String> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<String> aficiones) {
        
        this.aficiones = aficiones;
        
        for (UsuarioObserver o : obs) {
            o.onAficionesChange(this.aficiones);
        }
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public void addObserver(UsuarioObserver o) {
        this.obs.add(o);
    }
}
