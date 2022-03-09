
public class TestaCliente {

	public static void main(String[] args) {
		Cliente pedro = new Cliente();
		Conta contaDoPedro = new Conta(1334, 23511);
		
		pedro.setNome("Pedro");
		pedro.setCpf("342.377.578-54");
		pedro.setProfissao("programador");
		
		contaDoPedro.setTitular(pedro);
		
		System.out.println(contaDoPedro.getTitular().getNome());
		
		Conta contaDaHinara = new Conta(1234, 75823);
		contaDaHinara.setTitular(new Cliente());
		contaDaHinara.getTitular().setNome("Hinara");
		
		System.out.println(contaDaHinara.getTitular());
		System.out.println(contaDaHinara.getTitular().getNome());
		
		System.out.println(Conta.getTotal());
	}
}
