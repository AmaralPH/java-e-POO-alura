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
		
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
		
		System.out.println("------ lista ordenada -----");
		
		Comparator<String> comparador = new ComparaStringSize();
		palavras.sort(comparador);
		palavras.forEach(consumidor);	}
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
