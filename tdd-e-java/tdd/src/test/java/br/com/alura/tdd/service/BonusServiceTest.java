package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void deveriaRetonarBonusIgualZeroParaSalarioMuitoAlto() {
		Funcionario funcionario = new Funcionario("Pedro", LocalDate.now(), new BigDecimal("25000"));
		BonusService service = new BonusService();

//		assertThrows(IllegalArgumentException.class,
//				() -> service.calcularBonus(funcionario));
		
		try {
			service.calcularBonus(funcionario);
			fail("Não lançou Exception");
		} catch (Exception e) {
			assertEquals("Funcionarios com salario acima de 10000 não podem receber bonus", e.getMessage());
		}
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
