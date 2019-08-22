package br.com.testespringboot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import br.com.testespringboot.conexao.ConnectionFactory;
import br.com.testespringboot.exception.FalhaNaConexaoDaoException;
import br.com.testespringboot.modelo.CadastroClienteBean;

public class CadastroClienteDao {
	private Connection connection;

	//Construtor
	public CadastroClienteDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	//Inser��o de dados
	public void adiciona (CadastroClienteBean cadastroCliente) {
		String sql = "insert into cadastro_cliente " + 
				" (nome, email, telefone, endereco, dataNascimento, motivoDieta) " +
				" values (?,?,?,?,?,?)";
		int i=1;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(i++, cadastroCliente.getNome());
			stmt.setString(i++, cadastroCliente.getEmail());
			stmt.setString(i++, cadastroCliente.getTelefone());
			stmt.setString(i++, cadastroCliente.getEndereco());
			stmt.setDate(i++, new Date(cadastroCliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(i++, cadastroCliente.getMotivoDieta());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<CadastroClienteBean> getListaCadastroCliente() {
		try {
			List<CadastroClienteBean> listCadastrosCliente = new ArrayList<CadastroClienteBean>();

			String sql = "Select * from cadastro_cliente";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				CadastroClienteBean cadastroCliente = new CadastroClienteBean();
				cadastroCliente.setId(rs.getLong("id"));
				cadastroCliente.setNome(rs.getString("nome"));
				cadastroCliente.setEmail(rs.getString("email"));
				cadastroCliente.setTelefone(rs.getString("telefone"));
				cadastroCliente.setEndereco(rs.getString("endereco"));

				Calendar dataNascimentoFormatada = Calendar.getInstance();
				dataNascimentoFormatada.setTime(rs.getDate("dataNascimento"));
				cadastroCliente.setDataNascimento(dataNascimentoFormatada);

				cadastroCliente.setMotivoDieta(rs.getString("motivoDieta"));
				listCadastrosCliente.add(cadastroCliente);
			}
			return listCadastrosCliente;
		} catch (SQLException e) {
			throw new FalhaNaConexaoDaoException("Falha ao registrar");
		}

	}

	public CadastroClienteBean getCadastroCliente(CadastroClienteBean cadastroParam) {
		int i=1;

		try {
			CadastroClienteBean cadastroCliente = new CadastroClienteBean();
			String sql = "Select * from cadastro_cliente where id = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(i++, cadastroParam.getId());
			ResultSet rs = stmt.executeQuery();

			if(rs != null) { 
				while(rs.next()) {
					cadastroCliente.setId(rs.getLong("id"));
					cadastroCliente.setNome(rs.getString("nome"));
					cadastroCliente.setEmail(rs.getString("email"));
					cadastroCliente.setTelefone(rs.getString("telefone"));
					cadastroCliente.setEndereco(rs.getString("endereco"));

					Calendar dataNascimentoFormatada = Calendar.getInstance();
					dataNascimentoFormatada.setTime(rs.getDate("dataNascimento"));
					cadastroCliente.setDataNascimento(dataNascimentoFormatada);

					cadastroCliente.setMotivoDieta(rs.getString("motivoDieta"));
				}
			}
			stmt.close();
			return cadastroCliente;
		} catch (SQLException e) {
			throw new FalhaNaConexaoDaoException(e.getMessage());
		}
	}

	public void alteraCadastroCliente(CadastroClienteBean cadastroClienteParam) {
		int i = 1;
		try {
			String sql = "update cadastro_cliente set nome = ?, email = ? where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(i++, cadastroClienteParam.getNome());
			stmt.setString(i++, cadastroClienteParam.getEmail());
			stmt.setLong(i++, cadastroClienteParam.getId());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new FalhaNaConexaoDaoException(e.getMessage());
		}
	}
}