package com.curso.v0;

public class Outer {
	int i = 10;

	class Inner {
		//int i = 0;
		public void methodA() {
			System.out.println(i); //10
			System.out.println(Outer.this.i); //10
			//System.out.println(this.i); //0
		}
	}
	
	public static void main(String[] args) {
		new Outer().new Inner().methodA();
	}
	
}
