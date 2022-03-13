package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {

	public static void main(String[] args) {
		
		Integer idadeRef = 29; // autoboxing
		int primitivo = new Integer(21); // deprecated - unboxing

		List<Integer> lista = new ArrayList<>();
		lista.add(idadeRef);
		lista.add(primitivo); // autoboxing
		
		int i1 = lista.get(0); // unboxing
		Integer i2 = lista.get(1); // retorna o tipo Integer como salvo na lista
		
		System.out.println(i1);
		System.out.println(i2);
		
		Integer valorRef = Integer.valueOf(33); // cria um Wrapper para 33
		int valorPri = valorRef.intValue(); // atribui a valorPri o int representado por ele
		
		System.out.println(valorPri);
		System.out.println(valorRef);
		
		Integer iParseado1 = Integer.valueOf("42");
		int iParseado2 = Integer.parseInt("44");
		
		System.out.println(iParseado1);
		System.out.println(iParseado2);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);
	}

}
