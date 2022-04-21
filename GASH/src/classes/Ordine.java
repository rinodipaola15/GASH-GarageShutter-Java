package classes;

import java.time.LocalDateTime;
import java.util.LinkedList;

import interfaces.StatoOrdine;

public class Ordine {
	
	private String codice;
	private LocalDateTime data_e_ora;
	private LinkedList<RigaDiOrdine> righeDiOrdine;
	private Fornitore fornitoreAssociato;
	private StatoOrdine statoOrdine;
	
	public Ordine(String codice) {
		super();
		this.codice = codice;
		this.righeDiOrdine = new LinkedList<RigaDiOrdine>();
	}
	
	public void setFornitore(Fornitore f) {
		this.fornitoreAssociato = f;
	}

	public Fornitore getFornitoreAssociato() {
		return fornitoreAssociato;
	}

	
	public void nuovaRigaDiOrdine(ComponenteFornitore cf, int quantita) {
		RigaDiOrdine ro = new RigaDiOrdine(cf, quantita);
		righeDiOrdine.add(ro);
	}
	
	public double calcolaTotale() {
		double totale = 0.0;
		for(RigaDiOrdine ro : righeDiOrdine) {
			totale+=ro.calcolaSubtotale();
		}
		return totale;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public void setDataEOraOrdine() {
		data_e_ora = LocalDateTime.now();
	}
	
	public LocalDateTime getDataEOraOrdine() {
		return data_e_ora;
	}
	
	public LinkedList<RigaDiOrdine> getRigheDiOrdine() {
		return righeDiOrdine;
	}
	
	public String getStatoOrdine() {
		return statoOrdine.mostraStato();
	}

	public void setStatoOrdine(StatoOrdine statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	@Override
	public String toString() {
		return "Ordine [codice=" + codice + ", data_e_ora=" + data_e_ora + ", righeDiOrdine=" + righeDiOrdine
				+ ", fornitoreAssociato=" + fornitoreAssociato.getCodiceFornitore() + ", calcolaTotale()=" + calcolaTotale()
				+ ", getDataEOraOrdine()=" + getDataEOraOrdine() + ", getStatoOrdine()=" + getStatoOrdine() + "]\n";
	}
		
}
