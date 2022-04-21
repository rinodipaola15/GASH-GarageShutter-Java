package classes;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class  Vendita {
	
	private String codice;
	private String indirizzo;
	double totale;
	private LocalDateTime data_e_ora;
	private Cliente clienteAssociato;
	
	public Vendita(String codice) {
		this.codice = codice;
	}
	public String getCodice() {
		return codice;
	}

	public Cliente getClienteAssociato() {
		return clienteAssociato;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setClienteAssociato(Cliente clienteAssociato) {
		this.clienteAssociato = clienteAssociato;
	}
	public void setCliente(Cliente cln) {
		this.clienteAssociato = cln;
	}
	public void inserisciDettagliConsegna(String indirizzo) {
		this.indirizzo = indirizzo;
	}	

	public void setDataEOraVendita() {
		data_e_ora = LocalDateTime.now();
	}
	
	public LocalDateTime getDataEOraVendita() {
		return data_e_ora;
	}
	public abstract double calcolaTotale();
	
	public abstract String toString();
	
	public double getTotale() {
		return totale;
	}
	
	
	
}