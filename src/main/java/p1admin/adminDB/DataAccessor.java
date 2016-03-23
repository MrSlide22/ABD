package p1admin.adminDB;

<<<<<<< HEAD
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
	 * @return <code>true</code> si la inserción tuvo éxito, o
	 *         <code>false</code> en caso contrario.
	 */
	public boolean insertRow(String tableName, String[] fields, Object[] values) {
		String sql = generateInsertStatement(tableName, fields);
		try (Connection con = ds.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i + 1, values[i]);
			}
			int numRows = pst.executeUpdate();
			return (numRows == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
		System.out.println(sql);
		try (Connection con = ds.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

			for (int i = 0; i < conditions.length; i++) {
				st.setObject(i + 1, conditions[i].getValue());
			}

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
=======
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DataAccessor {

	private DataSource ds;

	public DataAccessor(DataSource ds) {
		super();
		this.ds = ds;
	}

	public boolean insertRow(String tableName, String[] fields, Object[] values) {

		String sql = generateInsertStatement(tableName, fields);

		try (Connection con = (Connection) ds.getConnection();

				PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql)) {

			for (int i = 0; i < values.length; i++) {
				pst.setObject(i + 1, values[i]);
			}

			int numRows = pst.executeUpdate();
			return (numRows == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateRows(String tableName, String[] keys, String[] vals, String[] fields, Object[] newVals) {
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf

		String sql = generateUpdateStatement(tableName, keys, fields);

		try (Connection con = (Connection) ds.getConnection();

				PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql)) {

			for (int i = 0; i < newVals.length; i++) {
				pst.setObject(i + 1, newVals[i]);
			}

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

<<<<<<< HEAD
	public boolean deleteRows(String tableName, String[] keys, Object[] vals) {

		String sql = generateDeleteStatement(tableName, keys);
		System.out.println(sql);
=======
	public boolean deleteRows(String tableName, String[] keys, String[] vals) {

		String sql = generateDeleteStatement(tableName, keys);

>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
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

<<<<<<< HEAD
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
=======
	public ResultSet selectRows(String tableName, String[] keys, Object[] vals) {
	
		String sql = generateSelectStatement(tableName, keys);

		try (Connection con = (Connection) ds.getConnection();

				PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql)) {

			for (int i = 0; i < vals.length; i++) {
				pst.setObject(i + 1, vals[i]);
			}

			return pst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private String generateSelectStatement(String tableName, String[] keys) {
		String keyList = String.join(" = ? AND ", keys) + " = ?";
		return "SELECT * FROM " + tableName + " WHERE " + keyList;
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	}

	private String generateDeleteStatement(String tableName, String[] keys) {
		String keyList = String.join(" = ? AND ", keys) + " = ?";
<<<<<<< HEAD
		return "DELETE FROM " + tableName + " WHERE " + keyList;
=======
		return "DELETE " + tableName + " WHERE " + keyList;
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
	}

	private String generateUpdateStatement(String tableName, String[] keys, String[] fields) {

		String fieldList = String.join(" = ?, ", fields) + " = ?";
		String keyList = String.join(" = ? AND ", keys) + " = ?";
		return "UPDATE " + tableName + " SET " + fieldList + " WHERE " + keyList;
	}
<<<<<<< HEAD
=======

	private String generateInsertStatement(String tableName, String[] fields) {
		String fieldList = String.join(",", fields);
		String[] marks = new String[fields.length];
		Arrays.fill(marks, "?");
		String markList = String.join(",", marks);
		return "INSERT INTO " + tableName + " (" + fieldList + ") VALUES (" + markList + ")";
	}
>>>>>>> d1eb4ee41915731e646b70a22473302f9fa2efcf
}
