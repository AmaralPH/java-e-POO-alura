package br.com.alura;

public class Funcionario {

	private int idade;
	private String nome;
	
	public Funcionario(String nome, int idade) {
		this.idade = idade;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

//	@Override
//	public int compareTo(Object obj) {
//		Funcionario outroFunc = (Funcionario) obj;
//		return this.idade - outroFunc.idade;
//	}
}
