package br.com.alura;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TestaAPIDatas {

	public static void main(String[] args) {

		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate dataFutura = LocalDate.of(2099, 1, 25);
		System.out.println(dataFutura);
		
		Period periodo = Period.between(hoje, dataFutura);
		System.out.println(periodo);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formatador));
		
	}

}
