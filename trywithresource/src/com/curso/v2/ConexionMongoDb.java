package com.curso.v2;

public class ConexionMongoDb implements AutoCloseable{
	
	String port;
	
	public ConexionMongoDb(String port) {
		this.port = port;
	}

	void open() throws Exception {
		System.out.println("Abrir conexion MongoDb");
		throw new Exception("Exception al abrir la Conexion");
	}
	
	@Override //NO SE PUEDE REDUCIR LA VISIBILIDAD (MODIFICADOR DE ACCESO)
	public void close() throws Exception {
		System.out.println("Cerrar conexion MongoDb");
		//throw new Exception("Exception al cerrar la Conexion");
	}

}
