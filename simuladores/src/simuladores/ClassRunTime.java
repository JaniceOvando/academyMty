package simuladores;

class Animal {
	protected void comer() {}
}

class Perro extends Animal {
	void ladrar() {
		System.out.println("Guau");
	}
	
	@Override
	public void comer() {}
}

class Gato extends Animal {
	void maullar() {
		System.out.println("Miau");
	}
}

public class ClassRunTime {
	public static void main(String[] args) {
		Animal a = new Perro();
		System.out.println(a instanceof Gato);
		Gato g = (Gato) a;
		g.maullar();
	}

}