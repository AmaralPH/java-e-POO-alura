package br.com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestaDefaultMethods {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		// criando uma classe Consumer
//		System.out.println("---criando uma classe Consumer---");
//		Consumer<String> consumidor = new ImprimeNaLinha();
//		palavras.forEach(consumidor);
		
		// utilizando uma classe abstrata
//		System.out.println("---utilizando uma classe abstrata---");
//		palavras.forEach(new Consumer<String>() {
//			public void accept(String palavra) {
//				System.out.println(palavra);
//			}
//		});
		
		// utilizando uma expressão lambda
		System.out.println("---utilizando uma expressão lambda---");
		palavras.forEach(s -> System.out.println(s));
		
		System.out.println("------ lista ordenada -----");

		// sort consumindo uma classe criada
//		 Comparator<String> comparador = new ComparaStringSize();
//		 palavras.sort(comparador);
//		 palavras.forEach(consumidor);	}
	
		// sort feito com uma expressão lambda
		palavras.sort((s1, s2) -> s1.length() - s2.length());
		palavras.forEach(s -> System.out.println(s));
	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);
	}
	
}

class ComparaStringSize implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}
