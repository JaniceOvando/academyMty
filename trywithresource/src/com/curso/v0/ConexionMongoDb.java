package com.curso.v0;

public class ConexionMongoDb {
	
	String port;
	
	public ConexionMongoDb(String port) {
		this.port = port;
	}

	void open() throws Exception {
		System.out.println("Abrir conexion MongoDb");
		//throw new Exception("Exception al abrir la Conexion");
	}
	
	void close() throws Exception {
		System.out.println("Cerrar conexion MongoDb");
		//throw new Exception("Exception al cerrar la Conexion");
	}

}
