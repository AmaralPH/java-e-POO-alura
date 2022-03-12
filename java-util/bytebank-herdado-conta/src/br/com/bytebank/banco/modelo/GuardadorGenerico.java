package br.com.bytebank.banco.modelo;

public class GuardadorGenerico {

	private Object[] referencias;
	private int index;
	
	public GuardadorGenerico() {
		this.referencias = new Object[10];
		this.index = 0;
	}
	
	public int length() {
		return this.index;
	}
	
	public Object getElement(int i) {
		return this.referencias[i];
	}
	
	public void add(Object o) {
		this.referencias[this.index] = o;
		this.index++;
	}
}
