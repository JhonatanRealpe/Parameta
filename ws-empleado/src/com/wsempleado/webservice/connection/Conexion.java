package com.wsempleado.webservice.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String url = "jdbc:mysql://localhost:3306/pruebabd?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
			+ "serverTimezone=UTC";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String user = "root";
	private String pwd = "root";

	public Connection getConnection() {
		Connection c = null;
		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url, user, pwd);
			if(c!=null) {
				System.out.println("Conexion exitosa");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error conexion" + e);
		} catch (SQLException e) {
			System.out.println("Error conexion" + e);
		}
		return c;
	}

	public static void main(String[] args) throws SQLException {
		new Conexion().getConnection();
		System.out.println("ejecut!!!");

	}
}
