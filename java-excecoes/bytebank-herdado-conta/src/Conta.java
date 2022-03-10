public abstract class Conta {
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;
	
	public Conta(int agencia, int numero) {
		Conta.total++;
		this.agencia = agencia;
		this.numero = numero;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
	
	public abstract void deposita(double valor);
	
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
}