package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayDeReferencias {

	public static void main(String[] args) {

		Conta[] contas = new Conta[5];
		ContaCorrente cc1 = new ContaCorrente(123, 321);
		ContaPoupanca cc2 = new ContaPoupanca(444, 555);
		contas[0] = cc1;
		contas[1] = cc2;
		
		System.out.println(contas[1].getNumero());
		
//		Conta ref = contas[0];
		ContaCorrente ref = (ContaCorrente) contas[0];
		System.out.println(cc2.getNumero());
		System.out.println(ref.getNumero());
		
//		ContaPoupanca ref2 = contas[1]; ->  não compila sem fazer o cast ou alterar o tipo
		ContaPoupanca ref2 = (ContaPoupanca) contas[1];
	}

}
