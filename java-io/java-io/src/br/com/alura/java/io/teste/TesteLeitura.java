package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura {

	public static void main(String[] args) throws IOException {

		// FileInputStream é um InputStream
		InputStream fis = new FileInputStream("lorem.txt");
		// InputStreamReader é um Reader
		Reader isr = new InputStreamReader(fis, "UTF-8");
		// BufferedReader não pode ser referenciado como Reader, 
		// pois perderia o método readLine()
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		
		br.close();
	}

}
