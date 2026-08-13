package simuladores;

interface Ruidoso {
	default String sonar() {
		return "Ruidoso";
	}
}

interface Silencioso {
	default String sonar() {
		return "Silencioso";
	}
}

class Robot implements Ruidoso, Silencioso { //HERENCIA MULTIPLE

	public String sonar() {
		return Ruidoso.super.sonar();
	}
}

public class DefaultConflicto {

	public static void main(String[] args) {

		Silencioso s = new Robot();

		System.out.println(s.sonar());

	}
}