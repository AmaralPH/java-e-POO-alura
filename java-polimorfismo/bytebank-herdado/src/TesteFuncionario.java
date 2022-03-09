
public class TesteFuncionario {

	public static void main(String[] args) {
		Gerente pedro = new Gerente();
		pedro.setNome("Pedro Amaral");
		pedro.setCpf("342.377.578-54");
		pedro.setSalario(3400.0);
		
		System.out.println(pedro.getNome());
		System.out.println(pedro.getCpf());
		System.out.println(pedro.getSalario());
		System.out.println(pedro.getBonificacao());
	}
}
