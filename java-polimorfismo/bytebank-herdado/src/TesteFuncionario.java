
public class TesteFuncionario {

	public static void main(String[] args) {
		Gerente pedro = new Gerente();
		pedro.setNome("Pedro Amaral");
		pedro.setCpf("111.222.333-44");
		pedro.setSalario(3400.0);
		
		System.out.println(pedro.getNome());
		System.out.println(pedro.getCpf());
		System.out.println(pedro.getSalario());
		System.out.println(pedro.getBonificacao());
	}
}
