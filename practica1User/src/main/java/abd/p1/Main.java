package abd.p1;

import abd.p1.controller.UserController;
import abd.p1.model.Usuario;
import abd.p1.view.EditUserDialog;
import abd.p1.view.LoginDialog;
import abd.p1.view.PrincipalDialog;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Ésta es la clase que arranca la aplicación. La ejecución del método main() no
 * reconstruirá la base de datos. La base de datos se supone ya construida por
 * el método CreateDB.main()
 *
 */
public class Main {

    private static SessionFactory buildSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        }
    }

    public static void main(String[] args) {

        SessionFactory sf = null;

        boolean fallo = false;

        try {
            sf = buildSessionFactory();

            //Create controller
            UserController controller = new UserController(sf);

            //Login view
            LoginDialog loginDialog = new LoginDialog(null, true);
            loginDialog.setVisible(true);

            //Get login parameters
            String email = loginDialog.getEmail();
            String password = loginDialog.getPassword();
            controller.setUser(email, password);

            //If login is clicked
            if (loginDialog.isLogin()) {

                Usuario user = controller.getUsuarioById(email);
                if(user == null || !user.getPass().equals(password)){
                    JOptionPane.showMessageDialog(null, "Error en el login", "Error", JOptionPane.ERROR_MESSAGE);
                    fallo = true;
                }else {
                    controller.setUser(user);
                }
                
            } else if (loginDialog.isNewUser()) {

                if (controller.getUsuarioById(email) != null) {
                    JOptionPane.showMessageDialog(null, "Ya existe un usuario con este correo", "Error", JOptionPane.ERROR_MESSAGE);
                    fallo = true;
                } else {

                    EditUserDialog newUserFrame = new EditUserDialog(controller, null, true);
                    controller.addObserver(newUserFrame);
                    newUserFrame.setVisible(true);
                }
            }

            if (!fallo && (loginDialog.isNewUser() || loginDialog.isLogin())) {

                PrincipalDialog principalView = new PrincipalDialog(controller, null, true);
                principalView.setVisible(true);
            }
//                    System.out.println("b");
            //loginDialog.setVisible(false);+
            // Mostrar ventana de login y comprobar validez del usuario y contraseña.
            // Si son validos, mostrar ventana principal.

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Fin");
            if (sf != null) {
                sf.close();
            }
        }
    }

}
