package classes;

import interfaces.StatoVendita;

public class Consegnato implements StatoVendita {
	
	private static final String stato = "consegnato";
	
	@Override
	public String mostraStato() {
		return stato;
	}

	
}
