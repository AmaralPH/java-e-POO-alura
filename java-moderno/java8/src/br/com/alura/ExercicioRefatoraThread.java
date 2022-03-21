package br.com.alura;

public class ExercicioRefatoraThread {

	public static void main(String[] args) {

		// código original
//		new Thread(new Runnable() {
//
//		    @Override
//		    public void run() {
//		        System.out.println("Executando um Runnable");
//		    }
//
//		}).start();
		
		// refatorado com lambda
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}

}
