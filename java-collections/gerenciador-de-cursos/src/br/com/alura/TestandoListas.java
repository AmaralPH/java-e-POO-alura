package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {
		String curso1 = "java.util";
		String curso2 = "java.io";
		String curso3 = "Java Collection";
		
		ArrayList<String> cursos = new ArrayList<>();
		
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);

		cursos.forEach(aula -> {
			System.out.println(aula);
		});
		
		System.out.println(cursos);
		
		cursos.remove(1);
		
		System.out.println(cursos);
		
		System.out.println("O primeiro curso da lista é: " + cursos.get(0));
		
		// retorna IndexOutOfBoundsException porque tentamos acessar um indice fora da lista
//        for (int i = 0; i <= cursos.size(); i++) {
//            System.out.println("Aula : " + cursos.get(i));
//        }
		
		cursos.add("Certificacao Java SE 8 Programmer I");
		System.out.println(cursos);
		
		// método estatico da classe Collections serve pra ordenar itens de uma lista
		Collections.sort(cursos);
		System.out.println(cursos);
	}
}
