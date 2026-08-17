package com.curso.v2;

public class Principal {

	public static void main(String[] args)  {
		
		System.out.println("V2");

		//Try With Resource
		try (ConexionMongoDb con = new ConexionMongoDb("2701")) {
			con.open();
			//con = null; //NO SE PUEDE PORQUE ES EFECTIVE FINAL con
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println("Fin de Programa");
		
	}

}
