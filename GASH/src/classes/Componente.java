package classes;

import exceptions.SinglePartException;

public abstract class Componente {
	private String codice;
	private String nome;
	private double prezzo;
	private String unitadimisura;

	public Componente(String nome, String codice, double prezzo) {
		super();
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
	}
	public Componente(String nome, String codice, double prezzo, String unitadimisura) {
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
		this.unitadimisura = unitadimisura;
	}
	public Componente(String nome, String codice) {
		this.nome = nome;
		this.codice = codice;
		this.prezzo = 0;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getUnitadimisura() {
		return unitadimisura;
	}
	public void setUnitadimisura(String unitadimisura) {
		this.unitadimisura = unitadimisura;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public abstract String toString() ;
	
}
