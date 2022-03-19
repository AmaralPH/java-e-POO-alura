package br.com.alura;

import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {

//		Collection<Integer> numeros = new ArrayList<>(); // 940 millis
		Collection<Integer> numeros = new HashSet<>(); // 12 millis
		
//		long inicio = System.currentTimeMillis();
		
		for (int i = 1; i <= 50000; i++) {
			numeros.add(i);
		}

		long inicio = System.currentTimeMillis(); // Set: 6 millis // List: 966 millis

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}
		
		long fim = System.currentTimeMillis();
		
		long tempoDeExecucao = fim - inicio;
		
		System.out.println("Tempo gasto: " + tempoDeExecucao);
	}

}
