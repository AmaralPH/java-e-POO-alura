
public class FatorialLoopFor {

	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			int fat = i;
			if (i == 0) {
				fat = 1;
			}
			for (int j = 1; j < i; j++) {

				fat *= j;
			}
			System.out.println(fat);
		}
	}
}

class Fatorial {
	public static void main(String[] args) {
		int fatorial = 1;
		for (int i = 1; i < 11; i++) {
			fatorial *= i;
			System.out.println("Fatorial de " + i + " = " + fatorial);
		}
	}
}