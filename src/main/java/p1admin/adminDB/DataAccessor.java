package p1admin.adminDB;

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

	public boolean deleteRows(String tableName, String[] keys, String[] vals) {

		String sql = generateDeleteStatement(tableName, keys);

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
	}

	private String generateDeleteStatement(String tableName, String[] keys) {
		String keyList = String.join(" = ? AND ", keys) + " = ?";
		return "DELETE " + tableName + " WHERE " + keyList;
	}

	private String generateUpdateStatement(String tableName, String[] keys, String[] fields) {

		String fieldList = String.join(" = ?, ", fields) + " = ?";
		String keyList = String.join(" = ? AND ", keys) + " = ?";
		return "UPDATE " + tableName + " SET " + fieldList + " WHERE " + keyList;
	}

	private String generateInsertStatement(String tableName, String[] fields) {
		String fieldList = String.join(",", fields);
		String[] marks = new String[fields.length];
		Arrays.fill(marks, "?");
		String markList = String.join(",", marks);
		return "INSERT INTO " + tableName + " (" + fieldList + ") VALUES (" + markList + ")";
	}
}
