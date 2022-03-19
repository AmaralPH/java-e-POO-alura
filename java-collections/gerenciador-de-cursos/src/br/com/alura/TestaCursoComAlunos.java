package br.com.alura;

import java.util.Set;

public class TestaCursoComAlunos {

	public static void main(String[] args) {
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
        
        javaColecoes.getAlunos().forEach(aluno -> {
        	System.out.println(aluno);
        });
        
        Set<Aluno> alunos = javaColecoes.getAlunos();
        // não roda porque getAlunos() retorna um unmodifiableSet
//        alunos.add(new Aluno("Pedro Amaral", 12345));
        
	}
}
