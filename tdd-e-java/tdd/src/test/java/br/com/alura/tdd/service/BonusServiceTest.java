package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void deveriaRetonarBonusIgualZeroParaSalarioMuitoAlto() {
		Funcionario funcionario = new Funcionario("Pedro", LocalDate.now(), new BigDecimal("25000"));
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(funcionario);
		
		Assertions.assertEquals(BigDecimal.ZERO, bonus);
	}

	@Test
	void deveriaRetornarBonusDe10PorCentoDoSalarioParaSalarioMenorQue10000() {
		Funcionario funcionario = new Funcionario("Pedro", LocalDate.now(), new BigDecimal("2500"));
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(funcionario);
		
		Assertions.assertEquals(new BigDecimal("250.0"), bonus);
	}
	
	@Test
	void deveriaRetonarBonusDe1000ParaSalarioDe10000() {
		Funcionario funcionario = new Funcionario("Pedro", LocalDate.now(), new BigDecimal("10000"));
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(funcionario);
		
		Assertions.assertEquals(new BigDecimal("1000.0"), bonus);
	}
}
