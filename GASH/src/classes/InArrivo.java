package classes;

import interfaces.StatoOrdine;

public class InArrivo implements StatoOrdine {

	private static final String stato = "inArrivo";
		
	@Override
	public String mostraStato() {
		return stato;
	}

	
}
