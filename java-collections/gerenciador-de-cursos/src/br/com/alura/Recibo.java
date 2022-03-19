package br.com.alura;

public class Recibo implements Comparable {

	private Aluno aluno;
	private String data;
	private double valor;
	
	public Recibo(Aluno aluno, String data, double valor) {
		this.aluno = aluno;
		this.data = data;
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getData() {
		return data;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	@Override
	public int compareTo(Object arg0) {
		Recibo outroRecibo = (Recibo) arg0;
		return aluno.getNome().compareTo(outroRecibo.getAluno().getNome());
	}
}
