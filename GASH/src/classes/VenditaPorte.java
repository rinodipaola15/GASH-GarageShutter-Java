package classes;

import java.util.LinkedList;
import interfaces.StatoVendita;
import interfaces.Vendibile;

public class VenditaPorte extends Vendita {
		
	private LinkedList<RigaDiVenditaPorta> righeDiVenditaPorta;
	private double percentualeManodopera = 20;
	private StatoVendita statoVendita;
	
	public VenditaPorte(String codice) {
		super(codice);
		this.righeDiVenditaPorta = new LinkedList<RigaDiVenditaPorta>();
	}
	public double getPercentualeManodopera() {
		return percentualeManodopera;
	}
	public void setPercentualeManodopera(double percentualeManodopera) {
		this.percentualeManodopera = percentualeManodopera;
	}
	
	public void nuovaRigaDiVendita(TipoPorta tp, double altezzaPorta, double larghezzaPorta) {
		RigaDiVenditaPorta rv = new RigaDiVenditaPorta(tp, altezzaPorta, larghezzaPorta);
		righeDiVenditaPorta.add(rv);
	}
	
	public LinkedList<RigaDiVenditaPorta> getRigheDiVenditaPorta() {
		return righeDiVenditaPorta;
	}
	
	public String getStatoVendita() {
		return statoVendita.mostraStato();
	}

	public void setStatoVendita(StatoVendita statoVendita) {
		this.statoVendita = statoVendita;
	}
	
	@Override
	public double calcolaTotale() {
		double totale = 0.0;
		for(RigaDiVenditaPorta rv : righeDiVenditaPorta) {
			totale += rv.calcolaSubtotale();
		}
		double prezzoAggiuntivo = (double) percentualeManodopera/100*totale;
		totale = totale+prezzoAggiuntivo;
		if(this.getClienteAssociato().getNumVendite()>=10) {
			double sconto = (double) ((10/100)*totale);
			this.totale = totale-sconto;
			return (totale-sconto);
		} else {
			this.totale = totale;
			return totale;
		}
	}
	
	@Override
	public double getTotale() {
		double totale = this.totale;
		totale= (double) Math.round(totale*100)/100;
		return totale;
	}
		
	@Override
	public String toString() {
		return "VenditaPorte [codiceVendita=" + getCodice() +" righeDiVenditaPorta=" + righeDiVenditaPorta + " indirizzoConsegna=" + getIndirizzo() +", dataEOraVendita=" + getDataEOraVendita() + ", getStatoVendita()=" + getStatoVendita()+"\nCliente Associato:"+super.getClienteAssociato() + "\ngetTotale()=" + getTotale() + "\n]";
	}

	
}
