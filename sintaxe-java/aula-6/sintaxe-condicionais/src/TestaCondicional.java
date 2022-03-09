
public class TestaCondicional {

	public static void main(String[] args) {
		System.out.println("testando condicionas");

		int idade = 20;

		int quantidadePessoas = 3;

		if (idade >= 18) {
			System.out.println("Você tem mais que 18 anos");
			System.out.println("Seja bem vindo");
		} else {
			if (quantidadePessoas >= 2) {
				System.out.println("voce nao tem 18 anos, mas pode entrar, pois esta acompanhado");
			} else {

				System.out.println("Infelizmente voce nao pode entrar");
			}
		}
	}

}
