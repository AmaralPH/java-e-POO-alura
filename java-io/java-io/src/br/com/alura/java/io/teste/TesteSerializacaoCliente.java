package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.bytebank.banco.modelo.Cliente;

public class TesteSerializacaoCliente {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

//		Cliente cliente = new Cliente();
//		cliente.setNome("Pedro");
//		cliente.setProfissao("Programador");
//		cliente.setCpf("123456789");
//		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
//		oos.writeObject(cliente);
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
		Cliente cliente = (Cliente) ois.readObject();
		ois.close();
		
		System.out.println(cliente.getCpf());
	}

}
