package classes;

import interfaces.StatoVendita;

public class InConsegna implements StatoVendita {
	
	private static final String stato = "inConsegna";
	
	@Override
	public String mostraStato() {
		return stato;
	}

	
}
