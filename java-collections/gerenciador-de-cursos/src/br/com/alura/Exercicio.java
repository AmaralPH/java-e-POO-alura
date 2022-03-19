package br.com.alura;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exercicio {

	public static void main(String[] args) {
		Map<Integer, String> pessoas = new HashMap<>();
        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");
        
        Set<Integer> chaves = pessoas.keySet();
        chaves.forEach(chave -> {
        	System.out.println(pessoas.get(chave));
        });
        
        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

        Aluno a1 = new Aluno("Rodrigo Turini", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 5617);
        Aluno a3 = new Aluno("Mauricio Aniche", 17645);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);
        
        System.out.println(javaColecoes.buscaMatriculado(34672));
	}

}
