package br.com.alura;

import java.util.Comparator;

public class OrdenaPorIdade implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario arg0, Funcionario arg1) {
		return arg0.getIdade() - arg1.getIdade();
	}

}
