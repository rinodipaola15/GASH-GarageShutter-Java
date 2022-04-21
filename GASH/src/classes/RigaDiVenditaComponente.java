package classes;

import interfaces.Vendibile;

public class RigaDiVenditaComponente {
	private Vendibile cv;
	private int quantit�;
	
	public RigaDiVenditaComponente(Vendibile cv, int quantit�) {
		super();
		this.cv = cv;
		this.quantit� = quantit�;
	}
	public Vendibile getCv() {
		return cv;
	}
	public void setCv(Vendibile cv) {
		this.cv = cv;
	}
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}
	/** 
	 * 	Ritorna prezzo vendita Vendibile cv associato 
	 */
	public double calcolaSubtotale() {
		double prezzoVendita=(cv.getPrezzoVendita())*quantit�;
		return prezzoVendita;
	}
	@Override
	public String toString() {
		return "\nRigaDiVenditaComponente [cv=" + cv + ", quantit�=" + quantit� + "]\n";
	}
	
	
}
