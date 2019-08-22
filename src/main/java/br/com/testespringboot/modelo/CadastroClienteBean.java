package br.com.testespringboot.modelo;

import java.util.Calendar;

public class CadastroClienteBean {
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	private Calendar dataNascimento;
	private String motivoDieta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getMotivoDieta() {
		return motivoDieta;
	}
	public void setMotivoDieta(String motivoDieta) {
		this.motivoDieta = motivoDieta;
	}
}
