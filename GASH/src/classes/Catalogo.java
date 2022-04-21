package classes;

import java.util.HashMap;
import exceptions.NegValueException;

import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JOptionPane;

import interfaces.Vendibile;

public class Catalogo {
	private static Catalogo instance;
	private Map<String, Vendibile> componentiVendibili;
	private Map<String, TipoPorta> tipiPorta;
	private TipoPorta tipoPortaCorrente;
	private Vendibile componenteVendibileCorrente;
	
	
	public static Catalogo getInstance() { 
		if (instance == null) {
			instance = new Catalogo(); 
			} 
		return instance;
		
		}
	/*
	 * COSTRUTTORE
	 */
	private Catalogo() {
		this.componentiVendibili = new HashMap<String, Vendibile>();
		this.tipiPorta = new HashMap<String, TipoPorta>();
	}

	/** Caso d'uso UC2
	 * Istanzia un oggetto tipo di Porta corrente
	 */
	public Boolean nuovoTipoPorta(String codice, String nome) {
		tipoPortaCorrente=null;
		if(tipiPorta.get(codice)==null && codice!=null && nome!=null && !codice.isEmpty() && !nome.isEmpty()) {
			tipoPortaCorrente = new TipoPorta(codice, nome);
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Esiste già una porta o hai inserito codice o nome null", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	/**
	 * Aggiunge a tipoPortaCorrente un componente 
	 */
	public void aggiungiComponentePorta(String codice, int quantita) {
			Vendibile v=componentiVendibili.get(codice);
			ComponenteBase cb;
			if(v!=null && !codice.isEmpty() && quantita>0 && v instanceof ComponenteBase) {
				cb=(ComponenteBase) v;
				tipoPortaCorrente.aggiungiComponentePorta(codice,cb,quantita);
			}else {
				
				if(quantita<=0)
				JOptionPane.showMessageDialog(null, "Quantità minore di zero o nulla", "Errore", JOptionPane.ERROR_MESSAGE);
				else
				JOptionPane.showMessageDialog(null, "Non esistono componenti con questo codice", "Errore", JOptionPane.ERROR_MESSAGE);
			}
			
	}
	/**
	 * Associa a tipoPortaCorrente un tipo di Lamiera
	 */
	public Boolean associaLamieraPorta(String codiceLamiera) {
		Vendibile v= componentiVendibili.get(codiceLamiera);
		if (!codiceLamiera.isEmpty() && v != null && v instanceof Lamiera) {
			tipoPortaCorrente.associaTipoLamiera((Lamiera)v);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Non esistono lamiere con questo codice", "Errore",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}	
	/**
	 * Conferma il tipoPortaCorrente e lo aggiunge nella mappa tipiPorta
	 */
	public void confermaTipoPorta() {
		String c=tipoPortaCorrente.getCodice();
		addTipoPorta(c, tipoPortaCorrente);		
		GashGUI.printInfo("Hai inserito correttamente la porta:",tipoPortaCorrente.toString());
	}
	/**
	 * Aggiunge un tipo Porta alla lista tipi porta
	 */
	public void addTipoPorta(String codice, TipoPorta tp) {
		if(!codice.isEmpty() && tp!=null) {
		tipiPorta.put(codice, tp);
		}
	}
	/**
	 * Aggiunge un componente vendibile nella mappa componentiVendibili
	 */
	public void addComponente(String codice, Vendibile c) {
		if(!codice.isEmpty() && c!=null) {
		componentiVendibili.put(codice, c);
		}
	}

	public void printComponentiVendibili() {
		for (Entry<String, Vendibile> entry : componentiVendibili.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
	}

	/** Estensioni UC2
	 * Elimina Porta
	 */
	public void eliminaPorta(String codicePorta) {
		if(tipiPorta.get(codicePorta)!=null) {
		if(GashGUI.statoGUI!=null)
		GashGUI.printInfo("Hai eliminato correttamente la porta",null);
		JOptionPane.showMessageDialog(null,"Porta con codice: "+codicePorta+"eliminata");
		tipiPorta.remove(codicePorta);
		}else {
			JOptionPane.showMessageDialog(null,"Non esistono porte con codice: "+codicePorta);
		}
		
	}
	/**
	 * Ricerca Porta
	 */
	public TipoPorta ricercaPorta(String codicePorta) {
		TipoPorta tp=tipiPorta.get(codicePorta);
		if(tp!=null) {
			JOptionPane.showMessageDialog(null,"Porta con codice: "+codicePorta+" trovata");
				return tp;
			}else {
				JOptionPane.showMessageDialog(null,"Non esistono porte con codice: "+codicePorta);
				return null;
			}
		
	}
	/**
	 * Modifica Porta
	 */
	public Boolean selezionaPorta(String codicePorta) {
		TipoPorta tp=tipiPorta.get(codicePorta);
		if(tp!=null) {
			JOptionPane.showMessageDialog(null,"Porta con codice: "+codicePorta+" trovata");
				tipoPortaCorrente=tp;
				return true;
			}else {
			JOptionPane.showMessageDialog(null,"Non esistono porte con codice: "+codicePorta);
				return false;
		}
	}

	public void modificaCodicePorta(String codicePorta) {
		//Per cambiare codice occorre settare il codice del tipoporta e sostituire l'entry nella mappa cambiando la key
		if(!codicePorta.isEmpty()) {
			TipoPorta tp= tipoPortaCorrente;
			tipiPorta.remove(tipoPortaCorrente.getCodice());
			tp.setCodice(codicePorta);
			tipiPorta.put(codicePorta,tp);
			tipoPortaCorrente=tipiPorta.get(codicePorta);
			if(GashGUI.statoGUI!=null)
			GashGUI.printInfo("Hai modificato il codice in "+codicePorta,null);
			JOptionPane.showMessageDialog(null, "Codice modificato", "Modifica Porta",JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Errore il codice non può essere nullo","Modifica Porta", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void modificaNomePorta(String nome) {
		if(!nome.isEmpty()) {
		tipoPortaCorrente.setNome(nome);
		String codicePorta=tipoPortaCorrente.getCodice();
		if(GashGUI.statoGUI!=null)
		GashGUI.printInfo("Hai modificato la porta: "+codicePorta+"nuovo nome: "+nome,null);
		}
	}
	
	public void rimuoviComponenteSingolo(String codiceComponente) {
		if(!codiceComponente.isEmpty() && tipoPortaCorrente.getComponentiPorta().get(codiceComponente) !=null) {
			tipoPortaCorrente.rimuoviComponentePorta(codiceComponente);
		}
	}
	public void rimuoviLamiera() {
		tipoPortaCorrente.rimuoviLamiera();
	}
	public void aggiungiLamiera(String codiceLamiera) {
		associaLamieraPorta(codiceLamiera);
	}
	
	/** 
	 * Visualizza Catalogo
	 */
	public void visualizzaCatalogo() {
		GashGUI.printInfo("CATALOGO",tipiPorta.toString());
	}
	
	public TipoPorta getTipoPorta(String codicePorta) {
		TipoPorta tp;
		tp = tipiPorta.get(codicePorta);
		return tp;
	}

	public Vendibile getVendibile(String codiceVendibile) {
		Vendibile v=componentiVendibili.get(codiceVendibile);
		if(v!=null) {
			return v;
		}else {
			return null;
		}
	}

	public TipoPorta getTipoPortaCorrente() {
		return tipoPortaCorrente;
	}

	public Map<String, TipoPorta> getTipiPorta() {
		return tipiPorta;
	}

	/** Estensioni caso d'uso UC10
	 *  
	 */
	
	public Vendibile ricercaComponente(String codice) {
		return componentiVendibili.get(codice);
	}
	
	public boolean trovaComponente(String codice) {
		Vendibile v = componentiVendibili.get(codice);
		if(v!=null) {
			JOptionPane.showMessageDialog(null,"Componente con codice: "+codice+" trovato");
				componenteVendibileCorrente = v;
				return true;
			}else {
			JOptionPane.showMessageDialog(null,"Non esistono componenti con codice: "+codice);
				return false;
		}
	}
	
	public void modificaCodiceComponente(String codice) {
		if(!codice.isEmpty()) {
			Vendibile v = componenteVendibileCorrente;
			componentiVendibili.remove(v.getCodice());
			v.setCodice(codice);
			componentiVendibili.put(codice, v);
			componenteVendibileCorrente = componentiVendibili.get(codice);
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato il codice in "+codice,null);
			JOptionPane.showMessageDialog(null, "Codice modificato", "Modifica componente",JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Errore: il codice non può essere nullo","Modifica componente", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void modificaNomeComponente(String nome) {
		if(!nome.isEmpty()) {
			componenteVendibileCorrente.setNome(nome);
			String codiceComponente = componenteVendibileCorrente.getCodice();
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato il componente: "+codiceComponente+" nuovo nome: "+nome,null);
		}
	}
	
	public void modificaPrezzoComponente(double prezzo) throws NegValueException {
		if(prezzo>=0) {
			componenteVendibileCorrente.setPrezzo(prezzo);
			String codiceComponente = componenteVendibileCorrente.getCodice();
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato il componente: "+codiceComponente+" nuovo prezzo: "+prezzo,null);
		} else {
			JOptionPane.showMessageDialog(null, "Hai inserito un prezzo negativo", "Errore", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void modificaQuantitaComponente(int quantita) throws NegValueException {
		if(quantita>=0) {
			((ComponenteSingolo)componenteVendibileCorrente).setQuantità(quantita);
			String codiceComponente = componenteVendibileCorrente.getCodice();
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato il componente: "+codiceComponente+" nuova quantita': "+quantita,null);
		} else {
			JOptionPane.showMessageDialog(null, "Hai inserito una quantità negativa", "Errore", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void modificaMqComponente(double mq) {
		if(mq>=0) {
			((Lamiera)componenteVendibileCorrente).setMq(mq);
			String codiceComponente = componenteVendibileCorrente.getCodice();
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato il componente: "+codiceComponente+" nuovi mq: "+mq,null);
		} else {
			JOptionPane.showMessageDialog(null, "Hai inserito mq negativi", "Errore", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void eliminaComponente(String codiceComponente) {
		if(componentiVendibili.get(codiceComponente)!=null) {
		if(GashGUI.statoGUI!=null)
			GashGUI.printInfo("Hai eliminato correttamente il componente",null);
		JOptionPane.showMessageDialog(null,"Componente con codice: "+codiceComponente+" eliminato");
		componentiVendibili.remove(codiceComponente);
		}else {
			JOptionPane.showMessageDialog(null,"Non esistono componenti con codice: "+codiceComponente);
		}
	}

}
