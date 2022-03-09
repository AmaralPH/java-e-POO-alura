
public class TesteGerente {

	public static void main(String[] args) {
		Gerente steve = new Gerente();
		steve.setNome("Steve Jobs");
		steve.setCpf("123.321.456-20");
		steve.setSalario(10000.0);
		steve.setSenha(1234);
		
        System.out.println(steve.getNome());
        System.out.println(steve.getCpf());
        System.out.println(steve.getSalario());
		
		boolean senhaCorreta = steve.autentica(4321);
		System.out.println(senhaCorreta);
		System.out.println(steve.getBonificacao());
	}
}
