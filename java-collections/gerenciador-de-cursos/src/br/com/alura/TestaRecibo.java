package br.com.alura;

import java.util.Set;
import java.util.TreeSet;

public class TestaRecibo {

	public static void main(String[] args) {
		Recibo rec1 = new Recibo(new Aluno("Pedro", 123), "25/09/2022", 300.0);
		Recibo rec2 = new Recibo(new Aluno("João", 321), "25/09/2022", 300.0);
		Recibo rec3 = new Recibo(new Aluno("Otavio", 422), "25/09/2022", 300.0);
		
		Set<Recibo> contabil = new TreeSet<>();
		contabil.add(rec1);
		contabil.add(rec2);
		contabil.add(rec3);

	}
}
