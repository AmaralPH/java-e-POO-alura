package br.com.bytebank.banco.teste;

public class TesteString {

	public static void main(String[] args) {
		
		String nome = "Mario";
		String outro = new String("Alura");
		
		String novo = outro.replace("A", "a");
		
		System.out.println(novo);
		
		novo = nome.toLowerCase();
		
		System.out.println(novo);
		
		char c = nome.charAt(3);
		System.out.println(c);
		
		int pos = nome.indexOf("rio");
		System.out.println(pos);
		
		String sub = nome.substring(1);
		System.out.println(sub);
		
		for (int i = 0; i < nome.length(); i++) {
			System.out.println(nome.charAt(i));
		}
		
		novo = "    " + nome;
		System.out.println(novo);
		novo = novo.trim();
		System.out.println(novo);
		System.out.println(novo.isEmpty());
		System.out.println(novo.contains("ar"));
		System.out.println(novo.split("ar", 1));
	}
}
