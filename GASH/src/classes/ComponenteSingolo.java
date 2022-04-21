package classes;

import exceptions.NegValueException;
import interfaces.Vendibile;

public class ComponenteSingolo extends ComponenteBase implements Vendibile {
	private int quantit�;
	private double percentualeAggiuntivaVendita = 30;
	

	public ComponenteSingolo(String nome, String codice, double prezzo, int quantit�) {
		super(nome, codice, prezzo);
		this.quantit� = quantit�;
		super.setUnitadimisura("unitario");
	}

	@Override
	public String toString() {
		return "ComponenteSingolo [nome=" + super.getNome() + ", codice=" + super.getCodice() + ", prezzo=" + super.getPrezzo() + ", unitadimisura="+ super.getUnitadimisura() +", prezzoVendita=" + this.getPrezzoVendita() + ", quantit�=" + quantit� + "]\n";
	}

	@Override
	public double getPrezzoVendita() {
		double prezzoAcquistoComponenteSingolo = this.getPrezzo();
		double prezzoAggiuntivo = (double) percentualeAggiuntivaVendita/100*prezzoAcquistoComponenteSingolo;
		return prezzoAcquistoComponenteSingolo + prezzoAggiuntivo;
	}
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) throws NegValueException {
		this.quantit�=quantit�;
	}
	
	@Override
	public String getCodice() {
		return super.getCodice();
	}
	
	@Override
	public void setCodice(String codice) {
		super.setCodice(codice);
	}
	
	@Override
	public String getNome() {
		return super.getNome();
	}
	
	@Override
	public void setNome(String nome) {
		super.setNome(nome);
	}
	
	@Override
	public double getPrezzo() {
		return super.getPrezzo();
	}
	
	@Override
	public void setPrezzo(double prezzo) {
		super.setPrezzo(prezzo);
	}

	@Override
	public void aggiornaQuantit�(int quantit�) {
		this.quantit�=this.quantit�+quantit�;
	}

	@Override
	public Boolean checkDisponibilit�(int quantit�) {
		if(this.quantit�<quantit�) {
			return false;
		}else {
			return true;
		}
	}	
	
}
