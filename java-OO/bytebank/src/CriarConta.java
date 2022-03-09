
public class CriarConta {

	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 200.0;
		System.out.println(primeiraConta.saldo);
		
		primeiraConta.saldo += 100;
		System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 50;
		
		System.out.println("o saldo da primeira conta é: " + primeiraConta.saldo);
		System.out.println("o saldo da segunda conta é: " + segundaConta.saldo);
		
		System.out.println(primeiraConta);
		System.out.println(segundaConta);
	}
}
