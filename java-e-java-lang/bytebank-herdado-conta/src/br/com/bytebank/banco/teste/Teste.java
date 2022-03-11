package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(333, 444);
		ContaPoupanca cp = new ContaPoupanca(123, 321);
//		Conta c = new Conta(000, 000);
		
		System.out.println(cc);
		System.out.println(cp);
//		System.out.println(c);

	}
}
