package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaFileWriter {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("lorem2.txt");
		BufferedWriter bw = new BufferedWriter(fw); // ou: BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
		
//		fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
//		fw.write(System.lineSeparator());
//		fw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");
		
		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		// para usar o método newLine precisamos criar um BufferedWriter que recebe o FileWriter, caso contrário
		// é necessário usar o método write() que recebe como parametro System.lineSeparator()
		bw.newLine();
		bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");
		
		
		bw.close();
	}

}
