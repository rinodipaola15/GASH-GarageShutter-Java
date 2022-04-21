package classes;

public class RigaDiOrdine {
	
	private int quantita;
	private ComponenteFornitore cf;
	
	public RigaDiOrdine(ComponenteFornitore cf, int quantita) {
		super();
		this.cf = cf;
		this.quantita = quantita;
	}
	
	public double calcolaSubtotale() {
		double subtotale;
		subtotale = cf.getPrezzo()*quantita;
		return subtotale;
	}

	public ComponenteFornitore getCf() {
		return cf;
	}

	@Override
	public String toString() {
		return "RigaDiOrdine [quantita=" + quantita + ", cf=" + cf + "]\n";
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

}
