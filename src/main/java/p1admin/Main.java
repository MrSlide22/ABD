package p1admin;

<<<<<<< HEAD
import javax.sql.DataSource;
import javax.swing.DefaultListModel;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import p1admin.adminDB.DBFacade;
=======
import javax.swing.DefaultListModel;

>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
import p1admin.adminDB.FauxDBFacade;
import p1admin.adminDB.GenericDBFacade;
import p1admin.admincontroller.AllQuestionsController;
import p1admin.adminview.AllQuestionsEditor;
import p1admin.model.Opcion;
import p1admin.model.Pregunta;

public class Main {
	public static void main(String[] args) {
<<<<<<< HEAD
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost/Practica_605");
		cpds.setUser("root");
		cpds.setPassword("clara123");
		cpds.setAcquireRetryAttempts(1);
		cpds.setAcquireRetryDelay(1);
		
		DataSource ds = cpds;
		
		// DONE Cambiar inicialización de fachada a BD añadiendo
		// los parámetros que sean necesarios
//		GenericDBFacade<Pregunta, Opcion> facade = new FauxDBFacade();
		GenericDBFacade<Pregunta, Opcion> facade = new DBFacade(ds);
=======
		// TODO Inicializar conexión a BD
		
		
		// TODO Cambiar inicialización de fachada a BD añadiendo
		// los parámetros que sean necesarios
		GenericDBFacade<Pregunta, Opcion> facade = new FauxDBFacade();
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
		
		DefaultListModel<Pregunta> model = new DefaultListModel<>();
		AllQuestionsController controller = new AllQuestionsController(model, facade);
		AllQuestionsEditor ed = new AllQuestionsEditor(model, controller);
		ed.setModal(true);
		ed.setVisible(true);
		
<<<<<<< HEAD
		cpds.close();
		// DONE: Cerrar conexión
=======
		// TODO: Cerrar conexión
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	}
}
