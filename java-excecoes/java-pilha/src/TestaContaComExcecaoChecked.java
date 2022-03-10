
public class TestaContaComExcecaoChecked {
	
	public static void main(String[] args) {
		Conta c = new Conta();
		try {
			c.deposita(100);
		} catch (MinhaExcecao ex) {
			System.out.println("tratamento.....");
		}
	}
}
