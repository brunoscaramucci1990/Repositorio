package br.com.testespringboot.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	String BD_URL;

	public Connection getConnection(){

		BD_URL = "jdbc:mysql://localhost/dietafacil?useTimezone=true&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection(BD_URL, "root", "brunos");
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}finally {
			
		}
	}
}
