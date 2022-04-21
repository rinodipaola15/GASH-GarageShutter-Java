package classes;

public class RigaDiVenditaPorta {
	
	private double altezzaPorta;
	private double larghezzaPorta;
	private double mq;
	private TipoPorta tp;
	
	public RigaDiVenditaPorta(TipoPorta tp, double altezzaPorta, double larghezzaPorta) {
		super();
		this.tp = tp;
		this.altezzaPorta = altezzaPorta;
		this.larghezzaPorta = larghezzaPorta;
	}
	
	public double calcolaSubtotale() {
		double subtotale;
		double prezzoBase;
		double prezzoLamiera_al_mq;
		prezzoBase = tp.getPrezzoBase();
		prezzoLamiera_al_mq = tp.getPrezzoLamiera_al_mq();
		subtotale = prezzoBase + altezzaPorta*larghezzaPorta*prezzoLamiera_al_mq;
		this.mq=(altezzaPorta*larghezzaPorta);
		return subtotale;
	}
	public double getMq() {
		return mq;
	}

	public TipoPorta getTp() {
		return tp;
	}

	@Override
	public String toString() {
		return "RigaDiVenditaPorta [altezzaPorta=" + altezzaPorta + ", larghezzaPorta=" + larghezzaPorta + ", tp=" + tp
				+ ", calcolaSubtotale()=" + calcolaSubtotale() + "]\n";
	}
		
	
}
