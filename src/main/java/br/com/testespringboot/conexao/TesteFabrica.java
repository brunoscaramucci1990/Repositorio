package br.com.testespringboot.conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteFabrica {

	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conex�o aberta!");
        try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}

}
