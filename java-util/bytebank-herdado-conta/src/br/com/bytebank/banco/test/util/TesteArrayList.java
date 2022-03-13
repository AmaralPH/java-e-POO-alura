package br.com.bytebank.banco.test.util;

import java.util.List;
import java.util.Vector;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {

	public static void main(String[] args) {
		// <Tipo> se chama "generics"
//		List<Conta> lista = new ArrayList<Conta>();
//        List<Conta> lista = new LinkedList<Conta>(); //lista linkada
//		Collection<Conta> lista = new Vector<Conta>(); // apresenta erro

		List<Conta> lista = new Vector<Conta>();
		
//		Cliente cliente = new Cliente();
//		lista.add(cliente);
		
        Conta cc = new ContaCorrente(22, 11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22, 22);
        lista.add(cc2);
        
        System.out.println("Tamanho: " + lista.size());
        
        Conta ref = lista.get(0);
        System.out.println(ref.getNumero());
        
        lista.remove(0);
        System.out.println("Tamanho: " + lista.size());
        
        Conta cc3 = new ContaCorrente(33, 311);
        lista.add(cc3);
        
        Conta cc4 = new ContaCorrente(33, 322);
        lista.add(cc4);
        
        for (int i = 0; i < lista.size(); i++) {
        	Object oRef = lista.get(i); // não compila quando a referencia é Collection
        	System.out.println(oRef);
        }
        
        System.out.println("------------");
        
        for (Conta o : lista) {
        	System.out.println(o);
        }
	}
}
