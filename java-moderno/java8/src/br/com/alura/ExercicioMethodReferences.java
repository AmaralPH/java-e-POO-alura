package br.com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExercicioMethodReferences {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("Method reference");
		palavras.add("Lambda expression");
		palavras.add("Java 8 é muito legal");
		
		System.out.println(palavras);
		
		// original
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length()); 
		});
		
		// refatorado lambda
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		// refatorado method reference
		palavras.sort(Comparator.comparing(String::length));
		
		// com o import static (import java.util.Comparator.*) ficaria assim
//		palavras.sort(comparing(String::length));
		
		// criterio de comparação sendo a ordem das Strings
		palavras.sort(Comparator.comparing(s -> s));

		
		System.out.println(palavras);
	}
}
