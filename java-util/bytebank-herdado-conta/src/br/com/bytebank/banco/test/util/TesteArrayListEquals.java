package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {

	public static void main(String[] args){

	    ArrayList<Conta> lista = new ArrayList<Conta>();

	    Conta cc1 = new ContaCorrente(22, 22);
	    Conta cc2 = new ContaCorrente(22, 22);

	    lista.add(cc1);
	    
	    // verifica se a conta cc2 está na lista
	    boolean existe = lista.contains(cc2);
	    
	    // deveria retornar true, pq não retorna?
	    System.out.println("Já existe? " + existe);

	    for(Conta conta : lista){
	        System.out.println(conta);
	    }
	    
	    boolean igual = cc1.equals(cc2);
	    System.out.println(igual);
	    
	    Conta cc3 = new ContaCorrente(33, 33);
	    lista.add(cc3);
	    
	    System.out.println(cc1.equals(cc3));
	}
}
