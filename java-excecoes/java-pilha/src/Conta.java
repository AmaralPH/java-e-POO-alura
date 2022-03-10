
public class Conta {
	private int saldo;
	
	void deposita(double valor) throws MinhaExcecao {
		this.saldo += valor;
	}
}
