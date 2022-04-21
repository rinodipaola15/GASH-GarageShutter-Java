package classes;

import exceptions.NegValueException;
import interfaces.Vendibile;

public class ComponenteSingolo extends ComponenteBase implements Vendibile {
	private int quantità;
	private double percentualeAggiuntivaVendita = 30;
	

	public ComponenteSingolo(String nome, String codice, double prezzo, int quantità) {
		super(nome, codice, prezzo);
		this.quantità = quantità;
		super.setUnitadimisura("unitario");
	}

	@Override
	public String toString() {
		return "ComponenteSingolo [nome=" + super.getNome() + ", codice=" + super.getCodice() + ", prezzo=" + super.getPrezzo() + ", unitadimisura="+ super.getUnitadimisura() +", prezzoVendita=" + this.getPrezzoVendita() + ", quantità=" + quantità + "]\n";
	}

	@Override
	public double getPrezzoVendita() {
		double prezzoAcquistoComponenteSingolo = this.getPrezzo();
		double prezzoAggiuntivo = (double) percentualeAggiuntivaVendita/100*prezzoAcquistoComponenteSingolo;
		return prezzoAcquistoComponenteSingolo + prezzoAggiuntivo;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) throws NegValueException {
		this.quantità=quantità;
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
	public void aggiornaQuantità(int quantità) {
		this.quantità=this.quantità+quantità;
	}

	@Override
	public Boolean checkDisponibilità(int quantità) {
		if(this.quantità<quantità) {
			return false;
		}else {
			return true;
		}
	}	
	
}
