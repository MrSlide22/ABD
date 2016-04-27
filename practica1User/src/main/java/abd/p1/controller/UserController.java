package abd.p1.controller;

import abd.p1.bd.UsuarioDAO;
import abd.p1.model.Busca;
import abd.p1.model.Genero;
import abd.p1.model.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.hibernate.SessionFactory;

public class UserController {

    private Usuario user;
    private SessionFactory sf;

    public UserController() {

    }

    public UserController(SessionFactory sf) {
        this.sf = sf;
    }

    public void setUser(String correo, String password) {
        user = new Usuario();
        user.setCorreo(correo);
        user.setPass(password);
    }
    
    public void setUser(Usuario u){
        this.user = u;
    }

    public Usuario getUser() {
        return this.user;
    }

    public void changeNombre(String nombre) {
        this.user.setNombre(nombre);
    }

    public void changeFechaNacimiento(Date fecha) {
        this.user.setFechaDeNacimiento(fecha);
    }

    public void changeAvatar(byte[] avatar) {
        this.user.setAvatar(avatar);
    }

    public void addAficion(String aficion) {
        List<String> aficiones = this.user.getAficiones();
        aficiones.add(aficion);
        this.user.setAficiones(aficiones);
    }

    public void delAficion(String aficion) {
        List<String> aficiones = this.user.getAficiones();
        aficiones.remove(aficion);
        this.user.setAficiones(aficiones);
    }

    public void editAficion(String aficion, String nuevaAficion) {
        List<String> aficiones = this.user.getAficiones();
        aficiones.remove(aficion);
        aficiones.add(nuevaAficion);
        this.user.setAficiones(aficiones);
    }

    public void changeSexo(Genero sexo) {
        this.user.setSexo(sexo);
    }

    public void changePreferencia(Busca busca) {
        this.user.setBusca(busca);
    }

    public void changePassword(String pass) {
        this.user.setPass(pass);
    }

    public void changeDescripcion(String description) {
        this.user.setDescripcion(description);
    }

    public void addObserver(Observer o) {
        user.addObserver((UsuarioObserver) o);
    }

    public void saveChanges() {
        UsuarioDAO dao = new UsuarioDAO(sf);
        dao.saveUsuario(this.user);
    }
    
    public Usuario getUsuarioById(String correo){
        return new UsuarioDAO(sf).getUserById(correo);
    }
    
    public List<Usuario> getAllUsuariosByPreferencia(){
        
        UsuarioDAO dao = new UsuarioDAO(sf);
        return dao.getAllUsuarios(this.user.getBusca());
    }
    
    public List<Usuario> getUsuarioFilteredByNombre(String nombre){
        
        UsuarioDAO dao = new UsuarioDAO(sf);
        
        return dao.getUsuarioFilteredByNombre(nombre, this.user.getBusca());
    }
    
    public List<Usuario> getUsuarioFilteredByAmistad(){
        
        UsuarioDAO dao = new UsuarioDAO(sf);
        
        return dao.getUsuarioFilteredByAmistad(this.user.getCorreo());
    }
    
    public void setRandomUbicacion(){
        
        Random rand = new Random();
        
        Double latitud = rand.nextFloat() * (41.2 - 40) + 40;
        Double longitud = rand.nextFloat() * (4.5 - 3) + 3;
        
        this.user.setLatitud(latitud);
        this.user.setLongitud(longitud);
        
        this.saveChanges();
    }
}
