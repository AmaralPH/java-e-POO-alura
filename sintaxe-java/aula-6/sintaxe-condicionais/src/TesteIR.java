
public class TesteIR {

	public static void main(String[] args) {
		double salario = 3300.0;
		if (1900.0 <= salario && salario <= 2800.0) {
			double ir = 0.075 * salario;
			int deducao = 142;
			System.out.println("Sua alicota é de 7.5%, valor = " + ir);
			System.out.println("Você pode deduzir o valor de R$" + deducao);
		} else if (salario <= 3751.0) {
			double ir = 0.15 * salario;
			int deducao = 350;
			System.out.println("Sua alicota é de 15%, valor = " + ir);
			System.out.println("Você pode deduzir o valor de R$" + deducao);
		} else if (salario <= 4664.00) {
			double ir = 0.225 * salario;
			int deducao = 636;
			System.out.println("Sua alicota é de 22.5%, valor = " + ir);
			System.out.println("Você pode deduzir o valor de R$" + deducao);
		}
	}
}
