package br.com.testespringboot.teste;


import java.util.Calendar;

import br.com.testespringboot.dao.CadastroClienteDao;
import br.com.testespringboot.modelo.CadastroClienteBean;

public class TesteCadastroCliente {

	public static void main(String[] args) {
		CadastroClienteBean cadastroCliente = new CadastroClienteBean();
		cadastroCliente.setId((long)2);
		cadastroCliente.setNome("Alexia Komauer Sgoll");
		cadastroCliente.setEmail("alexia@yahoo.com.br");
		cadastroCliente.setEndereco("Avenina alexia 255 25");
		cadastroCliente.setDataNascimento(Calendar.getInstance());
		cadastroCliente.setTelefone("991431949");
		cadastroCliente.setMotivoDieta("1");

		/*CadastroClienteDao dao = new CadastroClienteDao();
		dao.adiciona(cadastroCliente);

		System.out.println("Feito!");*/
		/*CadastroClienteDao cadastroClienteDao = new CadastroClienteDao();
		List<CadastroClienteBean> listCadastroCliente = cadastroClienteDao.getListaCadastroCliente();
		for (CadastroClienteBean cadastro : listCadastroCliente) {
			System.out.println(cadastro.getNome());	*/
		
		
		CadastroClienteDao cadastroClienteDao = new CadastroClienteDao();
		cadastroClienteDao.alteraCadastroCliente(cadastroCliente);
		
		
		System.out.println("mal feito feito");
	}
}

