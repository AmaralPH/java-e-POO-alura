package br.com.alura;

import java.util.HashSet;
import java.util.Set;

public class TestaImprimindoAlunosSemAcentos {

	public static void main(String[] args) {
		
		Set<String> alunos = new HashSet<>();
        alunos.add("Paulo");
        alunos.add("Alberto");
        alunos.add("Pedro");    
        alunos.add("Nico");
        
        alunos.forEach(aluno -> {
        	System.out.println(aluno);
        });
        
        System.out.println(alunos.size());
        
        // não adiciona um item já contido no Set
        boolean adicionou = alunos.add("Pedro");
        System.out.println("Pedro foi adicionado ao Set? " + adicionou);  

        System.out.println(alunos.size());

	}
}
