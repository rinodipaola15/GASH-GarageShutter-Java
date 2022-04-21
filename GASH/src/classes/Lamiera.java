package classes;


import interfaces.Vendibile;

public class Lamiera extends Componente implements Vendibile {
	
	private double percentualeAggiuntivaVendita = 30;
	private double mq;

	public Lamiera(String nome, String codice, double prezzo,double mq) {
		super(nome, codice, prezzo);
		super.setUnitadimisura("mq");
		this.mq=mq;
	}

	public Lamiera(String nome, String codice, double prezzo) {
		super(nome, codice, prezzo);
		super.setUnitadimisura("mq");
		this.mq=0;
	}
	
	@Override
	public double getPrezzoVendita() {
		double prezzoAcquistoLamiera = this.getPrezzo();
		double prezzoAggiuntivo = (double) percentualeAggiuntivaVendita/100*prezzoAcquistoLamiera;
		return prezzoAcquistoLamiera + prezzoAggiuntivo;
	}
	
	public double getMq() {
		return mq;
	}

	public void setMq(double mq) {
		this.mq = mq;
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
	public String toString() {
		return "Lamiera [nome=" + super.getNome() + ", codice=" + super.getCodice() + ", prezzo=" + super.getPrezzo() + ", unitadimisura="+ super.getUnitadimisura() +
				", prezzoVendita=" + this.getPrezzoVendita() + ", mq=" + mq + "]\n";
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

	
}
