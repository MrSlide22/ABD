package p1admin.adminDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import p1admin.model.Pregunta;

public class PreguntaMapper extends AbstractMapper<Pregunta, Integer> {

	public PreguntaMapper(DataSource ds) {
		super(ds);
	}

	@Override
	protected String getTableName() {
		return "pregunta";
	}

	@Override
	protected String[] getKeyColumnNames() {
		return new String[] { "id" };
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "id", "texto" };
	}

	@Override
	protected Pregunta buildObjectFromResultSet(ResultSet rs) throws SQLException {
		int myId = rs.getInt("id");
		String texto = rs.getString("texto");

		return new Pregunta(myId, texto);
	}

	@Override
	protected Object[] decomposeKey(Integer key) {
		return new Object[] { key };
	}

	@Override
	protected Pregunta buildObject(Object[] o) {
		return new Pregunta((Integer) o[0], (String) o[1]);
	}

	@Override
	protected Object[] decomposeObject(Pregunta object) {
		return new Object[] { object.getId(), object.getEnunciado() };
	}

	@Override
	protected Integer getKey(Pregunta object) {
		return object.getId();
	}

	public LinkedList<Pregunta> selectAll() {

		List<Object[]> result = this.da.query(this.getTableName(), this.getColumnNames(), new QueryCondition[] {});
		LinkedList<Pregunta> ret = new LinkedList<Pregunta>();
		for (Object[] res : result) {
			ret.add(this.buildObject(res));
		}

		return ret;
	}

	@Override
	protected void setKey(Pregunta o, List<Object> keys) {
		o.setId((int) (long) keys.get(0));
	}
}
