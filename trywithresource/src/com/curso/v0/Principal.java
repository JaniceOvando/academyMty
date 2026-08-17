package com.curso.v0;

public class Principal {

	public static void main(String[] args) {

		ConexionMongoDb con = new ConexionMongoDb("2701");
		
		try {
			con.open();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Paso Finally");
		}
		
		System.out.println("Fin de Programa");
		
	}

}
