package br.com.bytebank.banco.modelo;

import java.io.Serializable;

/**
 * Classe que representa uma conta no ByteBank
 * 
 * @author pedroamaral
 * @version 0.1
 */
public abstract class Conta implements Comparable<Conta>, Serializable {
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;
	
	/**
	 * Construtor para inicializar o objeto Conta a partir da agencia e numero
	 * @param agencia
	 * @param numero
	 */
	protected Conta(int agencia, int numero) {
		Conta.total++;
		if (agencia < 1 || numero < 1) {
			throw new IllegalArgumentException("Agencia ou Numero da conta inválido");
		}
		this.agencia = agencia;
		this.numero = numero;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
	
	public abstract void deposita(double valor);
	
	/**
	 * Valor precisa ser maior ou igual ao saldo
	 * @param valor
	 * @throws SacaException
	 */
	public void saca(double valor) throws SacaException {
		if (this.saldo < valor) {
			throw new SacaException("ex- saldo: " + this.saldo + ", valor: " + valor);
		}
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SacaException {
		this.saca(valor);
		destino.deposita(valor);
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	@Override
	public String toString() {
		return "Numero: " + this.numero + ", Agencia: " + this.agencia;
	}
	
	@Override
	public boolean equals(Object ref) {
		
		Conta outra = (Conta) ref;
		
		if (this.agencia != outra.agencia) {
			return false;
		}
		
		if (this.numero != outra.numero) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int compareTo(Conta outra) {
		return Double.compare(this.saldo, outra.saldo);
	}
}