package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {

	public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		Aula a1 = new Aula("Revistando as ArrayLists", 21);
        Aula a2 = new Aula("Listas de objetos", 20);
        Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
        
        javaColecoes.adiciona(a1);
        javaColecoes.adiciona(a2);
        javaColecoes.adiciona(a3);

        List<Aula> aulasImutaveis = javaColecoes.getAulas();
        System.out.println(aulasImutaveis);
        
        //Collections.sort(aulasImutaveis);
        
        List<Aula> aulas = new ArrayList<Aula>(aulasImutaveis);
        Collections.sort(aulas);
        System.out.println(aulas);
        
        System.out.println(javaColecoes.getTempoTotal());
        System.out.println(javaColecoes);
	}
}
