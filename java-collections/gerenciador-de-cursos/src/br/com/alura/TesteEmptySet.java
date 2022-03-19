package br.com.alura;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TesteEmptySet {

	public static void main(String[] args) {
		
		Set<String> nomes = Collections.emptySet();
		nomes.add("Pedro");
	}
}
