package br.com.bytebank.banco.modelo;

import java.io.Serializable;

/**
 * Classe que representa um cliente no ByteBank
 * 
 * @author pedroamaral
 * @version 0.1
 */
public class Cliente implements Serializable {
	
    private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String profissao;
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getProfissao() {
		return this.profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}
