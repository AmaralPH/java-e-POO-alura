package br.com.alura.java.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEEncoding {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String s = "C";
		// printa a posição do caractere "C" na tabela Unicode
		System.out.println(s.codePointAt(0));
		
		// objeto charset padrão do sistema operacional
		Charset charset = Charset.defaultCharset();
		// printa nome do objeto
		System.out.println(charset.displayName());
		
		// cria um array com os bytes do caractere "C" usando o encoding "windows-1253"
		byte[] bytes = s.getBytes("windows-1253");
		System.out.print(bytes.length + ", windows-1253 ");
		// cria uma String com encoding windows-1253 a partir dos 
		// bytes do caractere "C" com encoding windows-1253
		String character = new String(bytes, "windows-1253");
		System.out.println(character);
		
		bytes = s.getBytes("UTF-16"); // bytecode criado a partir da letra C com encoding UTF-16
		System.out.print(bytes.length + ", UTF-16 ");
		// cira uma String com encoding windows-1253 a partir
		// dos bytes do caractere "C" com encoding UTF-16
		character = new String(bytes, "windows-1253");
		System.out.println(character);

		bytes = s.getBytes(StandardCharsets.US_ASCII); // bytecode criado a partir da letra C com encoding US_ASCII
		System.out.print(bytes.length + ", US_ASCII ");
		// cria uma String com encoding windows-1253 a partir dos bytes
		// do caractere "C" com encoding US_ASCII
		character = new String(bytes, "windows-1253");
		System.out.println(character);
	}

}
