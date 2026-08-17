package com.curso.v1;

public class Principal {

	public static void main(String[] args)  {

		ConexionMongoDb con = new ConexionMongoDb("2701");
		
		try {
			con.open();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			if (con!=null)
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		System.out.println("Fin de Programa");
		
	}

}
