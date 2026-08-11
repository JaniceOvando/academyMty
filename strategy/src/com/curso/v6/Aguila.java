package com.curso.v6;

import com.curso.v5.strategy.SiVolar;

public class Aguila extends Ave { //IS-A

	Aguila(){
		super(new SiVolar());
	}

}
