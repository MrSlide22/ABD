package p1admin.adminDB;

import java.util.LinkedList;
import java.util.List;

<<<<<<< HEAD
import javax.sql.DataSource;

=======
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
import p1admin.model.Opcion;
import p1admin.model.Pregunta;

/**
 * Fachada de acceso a la base de datos.
 * 
 * Implementa aquí las operaciones de acceso a datos.
 * 
 * AVISO: No incluyas ninguna sentencia SQL ni ninguna referencia a una tabla o
 * columna de la BD. Los accesos a la BD deben hacerse a traves de un Mapper.
 * 
 */
public class DBFacade implements GenericDBFacade<Pregunta, Opcion> {
<<<<<<< HEAD

	private DataSource ds;

	public DBFacade() {

	}

	public DBFacade(DataSource ds) {
		this.ds = ds;
	}
=======
	// TODO Introduce los atributos que sean necesarios.

	// TODO Si es necesario, añade el constructor que inicialice esos atributos.
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf

	/**
	 * Inserta una pregunta en la base de datos.
	 * 
<<<<<<< HEAD
	 * Esta función no tiene que guardar las opciones de la pregunta en la base
	 * de datos.
=======
	 * Esta función no tiene que guardar las opciones de la pregunta
	 * en la base de datos.
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	 * 
	 * Esta función es llamada cuando el usuario hace clic en el botón
	 * {@code Añadir Pregunta}, justo tras introducir el enunciado de la misma.
	 * 
	 * @param question
	 *            Pregunta a almacenar en la BD.
	 */
	@Override
	public void insertQuestion(Pregunta question) {
		System.out.println("Insertar pregunta en BD: " + question);
<<<<<<< HEAD

		PreguntaMapper pMap = new PreguntaMapper(this.ds);
		pMap.insert(question);
=======
		// TODO Implementar
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	}

	/**
	 * Devuelve todas las preguntas de la base de datos.
	 * 
	 * Esta función es llamada al principio del programa, para llenar el JList
	 * de la ventana principal. También se llama cuando el usuario ha hecho clic
	 * en el botón {@code Filtrar} tras introducir la cadena vacía en el cuadro
	 * de texto correspondiente.
	 * 
<<<<<<< HEAD
	 * <b>Importante:</b> Esta función también ha de recuperar de la BD las
	 * opciones asociadas a cada pregunta.
=======
	 * <b>Importante:</b> Esta función también ha de recuperar de la BD
	 * las opciones asociadas a cada pregunta.
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	 * 
	 * @return Una lista con todas las preguntas de la base de datos
	 */
	@Override
	public List<Pregunta> getAllQuestions() {
		System.out.println("Obtener todas las preguntas de la BD");
<<<<<<< HEAD
		
		PreguntaMapper pMap = new PreguntaMapper(ds);
		
		return pMap.selectAll();
=======
		// TODO Implementar
		return new LinkedList<>();
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	}

	/**
	 * Devuelve todas las preguntas de la base de datos cuyo enunciado contenga
	 * la cadena pasada como parámetro.
	 * 
	 * Esta función es llamada cuando el usuario pulsa el botón {@code Filtrar}
	 * tras haber introducido una cadena de texto en el cuadro correspondiente.
	 *
<<<<<<< HEAD
	 * <b>Importante:</b> Esta función también ha de recuperar de la BD las
	 * opciones asociadas a cada pregunta devuelta.
=======
	 * <b>Importante:</b> Esta función también ha de recuperar de la BD
	 * las opciones asociadas a cada pregunta devuelta.
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	 * 
	 * @param text
	 *            Texto que ha de aparecer en las respuestas devueltas.
	 * @return Lista con las preguntas cuyo enunciado contengan la cadena
	 *         {@code text}.
	 */
	@Override
	public List<Pregunta> findQuestionsContaining(String text) {
		System.out.println("Búsqueda de preguntas que contienen: " + text);
		// TODO implementar
<<<<<<< HEAD
		Pregunta p = new Pregunta();
		p.setEnunciado(text);
		PreguntaMapper pMap = new PreguntaMapper(ds);
		pMap.selectLike(p);
=======
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
		return new LinkedList<>();
	}

	/**
	 * Actualiza en la BD la información de la pregunta pasada como parámetro.
	 * 
	 * Esta función no tiene que actualizar la información de las posibles
	 * respuestas asociadas a dicha pregunta. Tan sólo hay que modificar la
	 * tabla que contiene la información de la pregunta en sí.
	 * 
	 * Se supone que la pregunta ya existe en la base de datos.
	 * 
	 * Esta función es llamada cuando el usuario cambia el botón del enunciado
	 * de una pregunta.
	 * 
	 * @param question
	 *            Pregunta a actualizar.
	 */
	@Override
	public void updateQuestion(Pregunta question) {
		System.out.println("Actualizar pregunta: " + question);
		// TODO Implementar
	}

	/**
	 * Actualiza en la BD la información de la respuesta (esto es, una de las
	 * posibles opciones asociadas a una pregunta) pasada como parámetro.
	 * 
	 * Esta función es llamada cuando el usuario pulsa el botón {@code Editar}
	 * del cuadro de diálogo de edición de pregunta.
	 * 
	 * En función del diseño de la base de datos que hayáis hecho, es posible
	 * que el parámetro {@code question} no sea necesario.
	 * 
	 * @param question
	 *            Pregunta que contiene la respuesta a actualizar.
	 * @param answer
	 *            Respuesta a actualizar.
	 */
	@Override
	public void updateAnswer(Pregunta question, Opcion answer) {
		System.out.println("Actualizar opción " + answer);
		// TODO Implementar

	}

	/**
	 * Elimina de la BD la respuesta (u opción) pasada como parámetro.
	 * 
	 * Esta función es llamada cuando el usuario pulsa el botón {@code Eliminar}
	 * del cuadro de diálogo de edición de pregunta.
	 * 
	 * @param question
	 *            Pregunta que contiene la respuesta a eliminar (puede no ser
	 *            necesario su uso).
	 * @param answer
	 *            Respuesta a eliminar.
	 */
	@Override
	public void deleteAnswer(Pregunta question, Opcion answer) {
		System.out.println("Eliminar opción " + answer);
		// TODO Implementar
	}

	/**
	 * Elimina de la BD la pregunta pasada como parámetro.
	 * 
	 * Esta función es llamada cuando el usuario hace clic en el botón
	 * {@code Eliminar pregunta} tras seleccionar una pregunta en la lista
	 * principal.
	 * 
<<<<<<< HEAD
	 * Esta función <b>sí</b> ha de eliminar la lista de respuestas asociadas a
	 * la pregunta.
=======
	 * Esta función <b>sí</b> ha de eliminar la lista de respuestas asociadas
	 * a la pregunta.
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	 * 
	 * @param question
	 *            Pregunta a eliminar.
	 */
	@Override
	public void deleteQuestion(Pregunta question) {
		System.out.println("Eliminar pregunta " + question);
<<<<<<< HEAD
		
		PreguntaMapper pMap = new PreguntaMapper(this.ds);
		pMap.delete(question);
=======
		// TODO Implementar
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	}

	/**
	 * Inserta una respuesta en la BD.
	 * 
	 * Esta función es llamada cuando el usuario añade una nueva opción en la
	 * pregunta actual.
	 * 
	 * @param question
	 *            Pregunta a la que pertenece la acción.
	 * @param answer
	 *            Respuesta a insertar.
	 */
	@Override
	public void insertAnswer(Pregunta question, Opcion answer) {
		System.out.println("Insertar " + answer);
		// TODO Implementar
	}
}
