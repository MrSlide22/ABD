package p1admin.adminDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import p1admin.model.Opcion;

public class OpcionMapper extends AbstractMapper<Opcion, Integer> {

	public OpcionMapper(DataSource ds) {
		super(ds);
	}

	@Override
	protected String getTableName() {
		return "opcion";
	}

	@Override
	protected String[] getKeyColumnNames() {
		return new String[] { "id" };
	}

	@Override
	protected String[] getColumnNames() {

		return new String[] { "id", "orden", "texto", "pregunta_id" };
	}

	@Override
	protected Opcion buildObjectFromResultSet(ResultSet rs) throws SQLException {
		int myId = rs.getInt("id");
		int orden = rs.getInt("orden");
		String texto = rs.getString("texto");

		return new Opcion(myId, orden, texto);
	}

	@Override
	protected Object[] decomposeKey(Integer key) {
		return new Object[] { key };
	}

	@Override
	protected Opcion buildObject(Object[] o) {
		return new Opcion((Integer) o[0], (Integer) o[1], (String) o[2]);
	}

	@Override
	protected Object[] decomposeObject(Opcion object) {
		return new Object[] { object.getId(), object.getNumeroOrden(), object.getTexto(),
				object.getPreguntaMadre().getId() };
	}

	@Override
	protected Integer getKey(Opcion object) {
		return object.getId();
	}

	@Override
	protected void setKey(Opcion o, List<Object> keys) {
		o.setId((int) (long) keys.get(0));
	}
}
