package com.curso.v0;

public class Principal2 {

	public static void main(String[] args) {

		String nombre = "Filologo";

		try {
			System.out.println(nombre.charAt(7));
			nombre = null;
			System.out.println(nombre.length());
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (RuntimeException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} catch (Throwable e) {
			System.out.println(e);
		}

		System.out.println("Fin de programa");
	}

}
