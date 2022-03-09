
public class TestaMetodos {

	public static void main(String[] args) {
		Conta contaDoPedro = new Conta(1234, 1234);
		Conta contaDaHinara = new Conta(1234, 1234);
		
		contaDoPedro.deposita(1900);
		System.out.println(contaDoPedro.getSaldo());
		System.out.println(contaDaHinara.getSaldo());
		
		contaDoPedro.transfere(900, contaDaHinara);
		System.out.println(contaDoPedro.getSaldo());
		System.out.println(contaDaHinara.getSaldo());
	}
}
