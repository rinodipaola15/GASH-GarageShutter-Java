package classes;

import interfaces.StatoOrdine;

public class Processato implements StatoOrdine{
	
	private static final String stato = "processato";
		
	@Override
	public String mostraStato() {
		return stato;
	}

	
}
