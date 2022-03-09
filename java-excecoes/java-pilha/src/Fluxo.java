
public class Fluxo {

	public static void main(String[] args) {
		System.out.println("Ini do metodo MAIN");
		metodo1();
		System.out.println("Fim do metodo MAIN");
	}
	
	public static void metodo1() {
		System.out.println("Ini do metodo METODO 1");
		metodo2();
		System.out.println("Fim do metodo METODO 1");
	}
	
	public static void metodo2() {
		System.out.println("Ini do metodo METODO 2");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		System.out.println("Fim do metodo METODO 2");
	}
}
