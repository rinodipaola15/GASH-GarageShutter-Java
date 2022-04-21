package classes;

import interfaces.Vendibile;

public class RigaDiVenditaComponente {
	private Vendibile cv;
	private int quantità;
	
	public RigaDiVenditaComponente(Vendibile cv, int quantità) {
		super();
		this.cv = cv;
		this.quantità = quantità;
	}
	public Vendibile getCv() {
		return cv;
	}
	public void setCv(Vendibile cv) {
		this.cv = cv;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	/** 
	 * 	Ritorna prezzo vendita Vendibile cv associato 
	 */
	public double calcolaSubtotale() {
		double prezzoVendita=(cv.getPrezzoVendita())*quantità;
		return prezzoVendita;
	}
	@Override
	public String toString() {
		return "\nRigaDiVenditaComponente [cv=" + cv + ", quantità=" + quantità + "]\n";
	}
	
	
}
