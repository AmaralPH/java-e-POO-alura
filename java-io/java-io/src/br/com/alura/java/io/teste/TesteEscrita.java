package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {

		// FileOutputStream é um OutputStream
		OutputStream os = new FileOutputStream("lorem2.txt");
		// OutputStreamWriter é um Writer
		Writer osw = new OutputStreamWriter(os);
		// BufferedWriter não pode ser referenciado como Writer, 
		// pois perderia o método write()
		BufferedWriter bw = new BufferedWriter(osw);
		
		
		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		bw.newLine();
		bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");
		
		
		bw.close();
	}

}
