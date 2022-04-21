package classes;

import java.util.HashMap;
import java.util.Map;

public class Fornitore {
	
	private String codiceFornitore;
	private String nome;
	private Map<String,ComponenteFornitore> componentiFornitore;
	
	public Fornitore(String codiceFornitore) {
		super();
		this.codiceFornitore = codiceFornitore;
		this.componentiFornitore = new HashMap<String,ComponenteFornitore>();
	}
	
	public Fornitore(String codice, String nome) {
		super();
		this.codiceFornitore = codice;
		this.nome = nome;
		this.componentiFornitore = new HashMap<String,ComponenteFornitore>();
	}


	public Map<String, ComponenteFornitore> mostraComponenti() {
		return componentiFornitore;
	}
	
	public ComponenteFornitore getComponenteFornitore(String codiceComponente) {
		ComponenteFornitore cf;
		cf = componentiFornitore.get(codiceComponente);
		return cf;
	}
	public void addComponenteFornitore(String codice, ComponenteFornitore cf) {
		componentiFornitore.put(codice, cf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFornitore() {
		return codiceFornitore;
	}

	public void setCodiceFornitore(String codiceFornitore) {
		this.codiceFornitore = codiceFornitore;
	}

	public void aggiungiComponenteFornitore(String codice, String nome2, double prezzo, String unitadimisura) {
		ComponenteFornitore cf=new ComponenteFornitore(nome2, codice, prezzo, unitadimisura);
		componentiFornitore.put(codice,cf);
		
	}

	public void rimuoviComponenteFornitore(String codiceComponente) {
		componentiFornitore.remove(codiceComponente);
	}

	public Map<String, ComponenteFornitore> getComponentiFornitore() {
		return componentiFornitore;
	}

	@Override
	public String toString() {
		return "Fornitore [codiceFornitore=" + codiceFornitore + ", nome=" + nome + ", componentiFornitore="
				+ componentiFornitore + "]\n";
	}
	
}
