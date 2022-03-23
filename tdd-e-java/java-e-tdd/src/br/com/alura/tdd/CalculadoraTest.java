package br.com.alura.tdd;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class CalculadoraTest {

	@Test
	public void deveriaSomarDoisInteiros() {
		Calculadora calc = new Calculadora();
		int soma = calc.somar(3, 7);
		
		Assert.assertEquals(10, soma);
	}
}
