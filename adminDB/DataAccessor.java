package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

public class DataAccessor {
	private DataSource ds;

	public DataAccessor(DataSource ds) {
		this.ds = ds;
	}

	/**
	 * Inserta una fila en una tabla de la BD.
	 * 
	 * @param tableName
	 *            Nombre de la tabla en la que insertar la fila.
	 * @param fields
	 *            Nombres de las columnas a rellenar de la nueva fila.
	 * @param values
	 *            Valores a insertar en la nueva fila. Este array ha de tener
	 *            tantos elementos como <code>fields</code>
	 * @return <code>List<Object></code> La lista con las claves generadas, o
	 *         <code>null</code> si no genera ninguna clave.
	 */
	public List<Object> insertRow(String tableName, String[] fields, Object[] values) {
		String sql = generateInsertStatement(tableName, fields);
		try (Connection con = ds.getConnection(); PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i + 1, values[i]);
			}
			
			pst.executeUpdate();
			ResultSet res = pst.getGeneratedKeys();
			List<Object> ret = new LinkedList<Object>();
			int i = 0;
			while (res.next()) {
				ret.add(res.getObject(i + 1));
				i++;
			}
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String generateInsertStatement(String tableName, String[] fields) {
		String fieldList = String.join(", ", fields);
		String[] marks = new String[fields.length];
		Arrays.fill(marks, "?");
		String markList = String.join(", ", marks);
		return "INSERT INTO " + tableName + " (" + fieldList + ") VALUES (" + markList + ")";
	}

	/**
	 * Realiza una consulta en la BD a partir de una conjunción de condiciones
	 * simples
	 * 
	 * @param tableName
	 *            Nombre de la tabla a consultar
	 * @param columns
	 *            Nombre de las columnas a devolver
	 * @param conditions
	 *            Condiciones sobre los resultados devueltos
	 * @return Lista con las filas devueltas por la consulta. Las columnas de
	 *         cada fila se representan mediante un array de Object.
	 */
	public List<Object[]> query(String tableName, String[] columns, QueryCondition[] conditions) {
		List<Object[]> result = new LinkedList<>();

		String sql = generateSelectStatement(tableName, columns, conditions);
		try (Connection con = ds.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

			for (int i = 0; i < conditions.length; i++) {
				st.setObject(i + 1, conditions[i].getValue());
			}
			System.out.println(st);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					Object[] obj = new Object[columns.length];
					for (int i = 0; i < obj.length; i++) {
						obj[i] = rs.getObject(columns[i]);
					}

					result.add(obj);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(sql);

		return result;
	}

	public boolean updateRows(String tableName, String[] keys, Object[] vals, String[] fields, Object[] newVals) {

		String sql = generateUpdateStatement(tableName, keys, fields);
		System.out.println(sql);
		try (Connection con = (Connection) ds.getConnection();

				PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql)) {

			int i;
			for (i = 0; i < newVals.length; i++) {
				pst.setObject(i + 1, newVals[i]);
			}

			for (int j = 0; j < vals.length; j++) {
				pst.setObject(i + 1, vals[j]);
			}
			System.out.println(pst);
			int numRows = pst.executeUpdate();
			return (numRows == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteRows(String tableName, String[] keys, Object[] vals) {

		String sql = generateDeleteStatement(tableName, keys);
		System.out.println(sql);
		try (Connection con = (Connection) ds.getConnection();

				PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql)) {

			for (int i = 0; i < vals.length; i++) {
				pst.setObject(i + 1, vals[i]);
			}

			int numRows = pst.executeUpdate();
			return (numRows == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private String generateSelectStatement(String tableName, String[] columns, QueryCondition[] conditions) {
		String[] conditionStrings = new String[conditions.length];

		for (int i = 0; i < conditionStrings.length; i++) {
			conditionStrings[i] = conditions[i].getColumnName() + " " + conditions[i].getOperator() + " ?";

		}

		// String sql = "SELECT " + String.join(", ", columns) + " FROM " +
		// tableName + " WHERE "
		// + String.join(" AND ", conditionStrings);

		String sql = "SELECT " + String.join(", ", columns) + " FROM " + tableName;
		if (conditions.length > 0) {
			sql += " WHERE " + String.join(" AND ", conditionStrings);
		}
		return sql;
	}

	private String generateDeleteStatement(String tableName, String[] keys) {
		String keyList = String.join(" = ? AND ", keys) + " = ?";
		return "DELETE FROM " + tableName + " WHERE " + keyList;
	}

	private String generateUpdateStatement(String tableName, String[] keys, String[] fields) {

		String fieldList = String.join(" = ?, ", fields) + " = ?";
		String keyList = String.join(" = ? AND ", keys) + " = ?";
		return "UPDATE " + tableName + " SET " + fieldList + " WHERE " + keyList;
	}
}
