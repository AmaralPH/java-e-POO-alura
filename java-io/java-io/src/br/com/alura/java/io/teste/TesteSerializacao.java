package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

//		String nome = "Pedro Amaral";
//		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
//		oos.writeObject(nome);
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
		String nome = (String) ois.readObject();
		ois.close();
		
		System.out.println(nome);
	}

}
