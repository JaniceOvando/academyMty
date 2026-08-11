package com.curso.v6;

import com.curso.v5.strategy.AleatorioVolar;

public class Pato extends Ave {
	
	Pato(){
		super(new AleatorioVolar());
	}

}
