package classes;

import java.util.LinkedList;

import interfaces.Vendibile;

public class VenditaRicambi extends Vendita {

	private LinkedList<RigaDiVenditaComponente> righeDiVenditaComponente;
	public VenditaRicambi(String codice) {
		super(codice);
		this.righeDiVenditaComponente = new LinkedList<RigaDiVenditaComponente>();
	}
	public void nuovaRigaDiVendita(Vendibile cv,int quantità) {
		RigaDiVenditaComponente rvc = new RigaDiVenditaComponente(cv,quantità);
		righeDiVenditaComponente.add(rvc);
	}
	@Override
	public double calcolaTotale() {
		double totale = 0.0;
		for(RigaDiVenditaComponente rvc : righeDiVenditaComponente) {
			totale += rvc.calcolaSubtotale();
		}
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
	public String toString() {
		return "VenditaRicambi \n righeDiVenditaComponente" + righeDiVenditaComponente+"\nCliente Associato:"+super.getClienteAssociato() + "\n]";
	}
	
	public double getTotale() {
		Double tot=(double) Math.round(totale*100)/100;
		return tot;
	}
	public LinkedList<RigaDiVenditaComponente> getRigheDiVenditaComponente() {
		return righeDiVenditaComponente;
	}
	
}
