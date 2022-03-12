package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorGenerico;

public class TestaGuardadorReferencias {

	public static void main(String[] args) {
		GuardadorGenerico guardador = new GuardadorGenerico();
		
		Conta cc = new ContaCorrente(22, 11);
		guardador.add(cc);
		
		Conta cc2 = new ContaCorrente(22, 22);
		guardador.add(cc2);
		
		int tamanho = guardador.length();
		System.out.println(tamanho);
		
		Conta ref = (Conta) guardador.getElement(0);
		System.out.println(ref);
	}
}
