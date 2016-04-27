/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.bd;

import abd.p1.model.Busca;
import abd.p1.model.Genero;
import abd.p1.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UsuarioDAO {

    SessionFactory sf;

    public UsuarioDAO(SessionFactory sf) {
        this.sf = sf;
    }

    public UsuarioDAO() {

    }

    public Usuario getUserById(String correo) {
        Session s = null;
        try {
            s = sf.openSession();
            Usuario u = s.get(Usuario.class, correo);
            return u;
        } catch (HibernateException e) {
            return null;
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public boolean saveUsuario(Usuario user) {
        Session s = null;
        try {
            s = sf.openSession();
            Transaction tr = s.beginTransaction();

            Usuario u = s.get(Usuario.class, user.getCorreo());

            if (u == null) { // Si no existe el usuario
                s.save(user);
            } else { // Si existe, se actualiza
                u = user;
                s.merge(u);
            }
            tr.commit();

            return true;
        } catch (HibernateException e) {
            return false;
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public List<Usuario> getAllUsuarios() {
        Session s = null;
        try {
            s = sf.openSession();

            return s.createCriteria(Usuario.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        } catch (HibernateException e) {
            return null;
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public List<Usuario> getAllUsuarios(Busca b) {
        Session s = null;
        try {
            s = sf.openSession();

            if (null != b) switch (b) {
                case HOMBRES:
                    return s.createCriteria(Usuario.class).add(Restrictions.eq("sexo", Genero.MASCULINO))
                            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                            .list();
                case MUJERES:
                    return s.createCriteria(Usuario.class).add(Restrictions.eq("sexo", Genero.FEMENINO))
                            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                            .list();
                default:
                    return s.createCriteria(Usuario.class)
                            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                            .list();
            }else{
                return null;
            }

        } catch (HibernateException e) {
            return null;
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public List<Usuario> getUsuarioFilteredByNombre(String nombre) {

        Session s = null;
        try {
            s = sf.openSession();

            return s.createCriteria(Usuario.class)
                    .add(Restrictions.like("nombre", "%" + nombre + "%"))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();

        } catch (HibernateException e) {
            return null;
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public List<Usuario> getUsuarioFilteredByNombre(String nombre, Busca b) {

        Session s = null;
        try {
            s = sf.openSession();
            
            if (null != b) switch (b) {
                case HOMBRES:
                    return s.createCriteria(Usuario.class)
                            .add(Restrictions.eq("sexo", Genero.MASCULINO))
                            .add(Restrictions.like("nombre", "%" + nombre + "%"))
                            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                            .list();
                case MUJERES:
                    return s.createCriteria(Usuario.class)
                            .add(Restrictions.eq("sexo", Genero.FEMENINO))
                            .add(Restrictions.like("nombre", "%" + nombre + "%"))
                            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                            .list();
                default:
                    return s.createCriteria(Usuario.class)
                            .add(Restrictions.like("nombre", "%" + nombre + "%"))
                            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                            .list();
            }else{
                return null;
            }

        } catch (HibernateException e) {
            return null;
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public List<Usuario> getUsuarioFilteredByAmistad(String correo) {

        Session s = null;
        try {
            s = sf.openSession();
            Usuario u = s.get(Usuario.class, correo);
            List<Usuario> amigos = new ArrayList<Usuario>();
            for (Usuario amigo : u.getAmigos()) {
                amigos.add(amigo);
            }
            return amigos;
        } catch (HibernateException e) {
            return null;
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public List<Usuario> getUsuarioFilteredByAmistad(String correo, Busca b) {

        Session s = null;
        try {
            s = sf.openSession();
            Usuario u = s.get(Usuario.class, correo);
            List<Usuario> amigos = new ArrayList<Usuario>();
            for (Usuario amigo : u.getAmigos()) {
                amigos.add(amigo);
            }
            return amigos;
        } catch (HibernateException e) {
            return null;
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
