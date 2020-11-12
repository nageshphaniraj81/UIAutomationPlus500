package utilities;

import java.util.HashMap;
import java.sql.*;

public class DBUtility {
	
	public synchronized HashMap<String, String> getSqlResultInMap(String sql) {
		HashMap<String, String> data_map = new HashMap<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(PropertiesUtility.getPropertyValueByKey("DBURL"),
					PropertiesUtility.getPropertyValueByKey("DBUser"),
					PropertiesUtility.getPropertyValueByKey("DBPassword"));

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();

			while (rs.next()) {
				for (int i = 1; i <= md.getColumnCount(); i++) {
					data_map.put(md.getColumnName(i), rs.getString(i));
				}
			}
			con.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return data_map;
	}
}
