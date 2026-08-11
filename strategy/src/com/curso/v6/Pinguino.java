package com.curso.v6;

import com.curso.v5.strategy.NoVolar;

public class Pinguino extends Ave {
	
	Pinguino(){
		super(new NoVolar());
	}
}
