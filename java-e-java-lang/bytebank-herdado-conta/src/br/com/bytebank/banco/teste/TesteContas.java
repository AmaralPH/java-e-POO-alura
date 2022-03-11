package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.SacaException;

public class TesteContas {

	public static void main(String[] args) throws SacaException {
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(200);
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(500);

		cc.transfere(50, cp);
		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());
	}
}
