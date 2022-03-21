package br.com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestaCurso {

	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		System.out.println(cursos);
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		System.out.println(cursos);
		
		cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.forEach(System.out::println);
		
		Stream<String> nomes = cursos.stream()
				.map(Curso::getNome);

		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .mapToInt(Curso::getAlunos)
		   .forEach(System.out::println);
		
		Optional<Curso> cursoOpt = cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst();
		
		OptionalDouble media = cursos.stream().mapToInt(Curso::getAlunos).average();
		System.out.println(media);
		
		List<Curso> cursosList = cursos.stream()
				.filter(c -> c.getAlunos() > 50)
				.collect(Collectors.toList());
		System.out.println(cursosList);
	}

}
