package classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import exceptions.NegValueException;
import interfaces.Vendibile;

public class Gash {
private static Gash instance;
	private Catalogo catalogo;

	private Ordine ordineCorrente;
	private Vendita venditaCorrente;
	private Cliente clienteCorrente;
	private Fornitore fornitoreCorrente;
	
	private Map<String, Vendita> vendite;
	private Map<String, Ordine> ordini;
	private Map<String, Fornitore> fornitori;
	private Session session;
	private Gash() {
		this.catalogo = Catalogo.getInstance();
		this.vendite = new HashMap<String, Vendita>();
		this.ordini = new HashMap<String, Ordine>();
		this.fornitori = new HashMap<String, Fornitore>();
	}
	
	
public static Gash getInstance() { 
	if (instance == null) {
		instance = new Gash(); 
		} 
	return instance;
	
	}
	 
	public Map<String, Vendita> getVendite() {
		return vendite;
	}

	public Map<String, Ordine> getOrdini() {
		return ordini;
	}

	public void addComponente(String codice, Vendibile c) {
		catalogo.addComponente(codice, c);
	}

	public void addCliente(String codice, Cliente c) {
		//Inserimento Database cliente
		Session session = HibernateUtil.getFactory().openSession();
				session.beginTransaction();
				session.save(c);
				session.getTransaction().commit();
				session.close();
	}

	public void addFornitore(String codice, Fornitore f) {
		fornitori.put(codice, f);
	}
	public void addVendita(String codice,Vendita v) {
		vendite.put(codice, v);
	}

	public void addComponenteFornitore(Fornitore f, String codice, ComponenteFornitore cf) {
		f.addComponenteFornitore(codice, cf);
	}
	
	public void addOrdine(String codice, Ordine o) {
		ordini.put(codice, o);
	}	
	
	public Catalogo getCatalogo() {
		return catalogo;
	}
	public void printComponentiVendibili() {
		catalogo.printComponentiVendibili();
	}
	/** Caso d'uso UC2
	 *  
	 */
	public Boolean nuovoTipoPorta(String codice, String nome) {
		return catalogo.nuovoTipoPorta(codice, nome);
	}
	/** 
	 *  Aggiunge componentePorta (implementa controllo su quantit‡ negativa tramite l'eccezione NegValueException)
	 */
	public void aggiungiComponentePorta(String codice, int quantit‡) throws NegValueException {
		if (quantit‡ > 0) {
			catalogo.aggiungiComponentePorta(codice, quantit‡);
		} else {
			NegValueException exp = new NegValueException(quantit‡);
			throw (exp);
		}
	}
	public Boolean associaLamieraPorta(String codiceLamiera) {
		return catalogo.associaLamieraPorta(codiceLamiera);

	}
	public void confermaTipoPorta() {
		catalogo.confermaTipoPorta();
	}
	/** 
	 * Estensioni Caso d'uso UC2
	 */
	public void eliminaPorta(String codicePorta) {
		catalogo.eliminaPorta(codicePorta);

	}

	public TipoPorta ricercaPorta(String codicePorta) {
		return catalogo.ricercaPorta(codicePorta);

	}

	public boolean selezionaPorta(String codicePorta) {
		return catalogo.selezionaPorta(codicePorta);

	}
	
	public void modificaCodicePorta(String codicePorta) {
		catalogo.modificaCodicePorta(codicePorta);

	}

	public void modificaNomePorta(String nome) {
		catalogo.modificaNomePorta(nome);

	}
	public void aggiungiComponenteSingolo(String codiceComponenteSingolo,int quantita) {
		catalogo.aggiungiComponentePorta(codiceComponenteSingolo,quantita);
	}
	public void rimuoviComponenteSingolo(String codiceComponente) {
		catalogo.rimuoviComponenteSingolo(codiceComponente);
	}
	public void rimuoviLamiera() {
		catalogo.rimuoviLamiera();
	}
	public void aggiungiLamiera(String codiceLamiera) {
		catalogo.aggiungiLamiera(codiceLamiera);
	}
	//Permette di visualizzare il catalogo composto dai tipi porta inseriti
	public void visualizzaCatalogo() {
		catalogo.visualizzaCatalogo();

	}
	/** Caso d'uso UC3
	 *  Istanzia un oggetto VenditaPorte
	 */
	public boolean nuovaVenditaPorte(String codice) {
		if(vendite.get(codice)==null && codice!=null &&  !codice.isEmpty()) {
			venditaCorrente = new VenditaPorte(codice);
			((VenditaPorte)venditaCorrente).setStatoVendita(new InConsegna());
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Esiste gi‡ una vendita con questo codice o hai inserito codice null", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}		
	}
	
	public boolean selezionaDatiClientePorte(String codiceFiscale) {
		Cliente cln;
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		cln = session.get(Cliente.class,codiceFiscale);
		session.getTransaction().commit();
		session.close();
		if(cln!=null) {
			JOptionPane.showMessageDialog(null,"Cliente con codice fiscale: "+codiceFiscale+" trovato");
			venditaCorrente.setCliente(cln);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Non esistono clienti con questo codice", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public void nuovaRigaDiVenditaPorte(String codicePorta, double altezzaPorta, double larghezzaPorta) throws NegValueException {
		TipoPorta tp;
		Boolean disponibile=true;
		if(altezzaPorta>0 && larghezzaPorta>0) {
			if(!codicePorta.isEmpty()) {
				tp = catalogo.getTipoPorta(codicePorta);
				if(tp!=null) {
					double mqDisponibili=tp.getLamieraAssociata().getMq();
					double mqPorta=(altezzaPorta*larghezzaPorta);
					if(mqDisponibili<mqPorta) {
						disponibile=false;
						JOptionPane.showMessageDialog(null, "Non ci sono abbastanza mq di lamiera in magazzino", "Errore", JOptionPane.ERROR_MESSAGE);	
					}
					for (Map.Entry<String,ComponentePorta> entry : tp.getComponentiPorta().entrySet()) {
					 int quantit‡Richiesta=entry.getValue().getQuantit‡();
					 
					 if(!entry.getValue().getCb().checkDisponibilit‡(quantit‡Richiesta)) {
						 disponibile=false;
						 JOptionPane.showMessageDialog(null, "Non ci sono abbastanza componenti in magazzino", "Errore", JOptionPane.ERROR_MESSAGE);
					 }
					}
					if(disponibile)
					((VenditaPorte)venditaCorrente).nuovaRigaDiVendita(tp, altezzaPorta, larghezzaPorta);	
					
				} else {
					JOptionPane.showMessageDialog(null, "Porta per garage non trovata", "Errore", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Inserimento annullato: Errori nell'inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			NegValueException exp=new NegValueException();
			throw(exp);
		}		
		
	}

	public double calcolaTotaleVenditaPorte() {
		double totale;
		totale = venditaCorrente.calcolaTotale();
		return totale;
	}
	
	public void inserisciDettagliConsegnaPorte(String indirizzo) {
		venditaCorrente.inserisciDettagliConsegna(indirizzo);
	}

	public void confermaVenditaPorte() throws NegValueException {
		
		if(!((VenditaPorte)venditaCorrente).getRigheDiVenditaPorta().isEmpty()) {
		String c;
		c = venditaCorrente.getCodice();
		String codiceFiscale=venditaCorrente.getClienteAssociato().getCodiceFiscale();
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		Cliente cln = session.get(Cliente.class,codiceFiscale);
		cln.incrementaNumVendite();
		session.getTransaction().commit();
		session.close();


		addVendita(codiceFiscale, venditaCorrente);
		venditaCorrente.setDataEOraVendita();
//		((VenditaPorte)venditaCorrente).setStatoVendita(new InConsegna());
		GashGUI.printInfo("Hai inserito correttamente la vendita di porte per garage:", venditaCorrente.toString());
		
		for(RigaDiVenditaPorta rv : ((VenditaPorte)venditaCorrente).getRigheDiVenditaPorta()) {
			
			double mqPrecedenti=rv.getTp().getLamieraAssociata().getMq();
			double mqVendita=rv.getMq();
			rv.getTp().getLamieraAssociata().setMq(mqPrecedenti-mqVendita);
			
			for (Map.Entry<String,ComponentePorta> entry : rv.getTp().getComponentiPorta().entrySet()) {
				 	int quantit‡=entry.getValue().getQuantit‡();
				 	entry.getValue().getCb().aggiornaQuantit‡(-quantit‡);
			}
		}
		
		writeFile(venditaCorrente.toString(),"Vendite",venditaCorrente.getCodice());//STAMPA FILE
		JOptionPane.showMessageDialog(null, "File Vendite_"+venditaCorrente.getCodice()+" creato", "Creazione file", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Devi inserire almeno una porta", "Errore", JOptionPane.ERROR_MESSAGE);
		}
	}

	/** Caso d'uso UC1
	 *  
	 */
	public boolean nuovoOrdine(String codice) {
		
		if(ordini.get(codice)==null &&codice!=null && !codice.isEmpty()) {
			ordineCorrente = new Ordine(codice);
			ordineCorrente.setStatoOrdine(new InArrivo());
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Esiste gi‡ un ordine con questo codice o hai inserito codice null", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	
	public boolean selezionaFornitore(String codiceFornitore) {

		Fornitore f;
		f = fornitori.get(codiceFornitore);
		if(f!=null) {
			JOptionPane.showMessageDialog(null,"Fornitore con codice: "+codiceFornitore+" trovato");
			ordineCorrente.setFornitore(f);
			f.mostraComponenti();
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Non esistono fornitori con questo codice", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}		
	}	
	public void nuovaRigaDiOrdine(String codiceComponente, int quantita) throws NegValueException {

		Fornitore f;
		ComponenteFornitore cf;

		if(quantita>0 ) {	
			if(!codiceComponente.isEmpty()) {
			f = ordineCorrente.getFornitoreAssociato();
			cf = f.getComponenteFornitore(codiceComponente);
			
				if(cf!=null) {
					
					
					ordineCorrente.nuovaRigaDiOrdine(cf,quantita);
				}
				else {
					JOptionPane.showMessageDialog(null, "Il fornitore specificato non possiede componenti con questo codice", "Errore", JOptionPane.ERROR_MESSAGE);
				}
			
			}else {
			JOptionPane.showMessageDialog(null, "Inserimento annullato: Errori nell'inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
		}
		}else {
			NegValueException exp=new NegValueException();
			throw(exp);
		}
	}

	public double calcolaTotaleOrdine() {
		double totale;
		totale = ordineCorrente.calcolaTotale();
		return totale;
	}

	public void confermaOrdine()  {
		String c;
		c = ordineCorrente.getCodice();
		ordineCorrente.setDataEOraOrdine();
//		ordineCorrente.setStatoOrdine(new InArrivo());
		addOrdine(c, ordineCorrente);
		System.out.println();
		System.out.println("Inserito l'ordine:");
		System.out.println(ordineCorrente);
		
		GashGUI.printInfo("Hai inserito correttamente l'ordine:", ordineCorrente.toString());
		
		writeFile(ordineCorrente.toString(),"Ordini",ordineCorrente.getCodice());//STAMPA FILE
		JOptionPane.showMessageDialog(null, "File Ordini_"+ordineCorrente.getCodice()+" creato", "Creazione file", JOptionPane.INFORMATION_MESSAGE);

		
	}
	public Ordine getOrdineCorrente() {
		return ordineCorrente;
	}
	
	/** Caso d'uso UC5
	 *  Istanzia un oggetto VenditaRicambi
	 */
	public boolean nuovaVenditaComponenti(String codice) {
		if(vendite.get(codice)==null && !codice.isEmpty()) {
			venditaCorrente = new VenditaRicambi(codice);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Esiste gi‡ una vendita con questo codice o hai inserito codice null", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}	
	}

	/**
	 * Effettua il set del cliente della venditaCorrente
	 */
	public Boolean selezionaDatiClienteRicambio(String codiceFiscale) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		Cliente  cln = session.get(Cliente.class,codiceFiscale);
		session.getTransaction().commit();
		session.close();
		
		if(!codiceFiscale.isEmpty() && cln != null) {
			venditaCorrente.setCliente(cln);
			
			return true;
		}else {
			return false;
		}
		
	}

	/** 
	 * 	Ottiene dalla mappa componenti vendibili il componente con quel codice 
	 *  e crea nuova riga di vendita per la venditaCorrente
	 */
	public void nuovaRigaDiComponente(String codiceVendibile, int quantit‡) throws NegValueException {
		Boolean disponibile = true;
		if (quantit‡ > 0) {
			Vendibile cv = catalogo.getVendibile(codiceVendibile);
			if (cv != null) {

				if (cv instanceof ComponenteBase) {										//Controllo quantit‡
					disponibile=((ComponenteBase) cv).checkDisponibilit‡(quantit‡);
			
				} else if (cv instanceof Lamiera) {
					double mqDisponibili = ((Lamiera) cv).getMq();
					if (mqDisponibili < quantit‡) {
						disponibile = false;
					}
				} 
				if (disponibile)
					((VenditaRicambi)venditaCorrente).nuovaRigaDiVendita(cv, quantit‡);
				else
					JOptionPane.showMessageDialog(null, "Non ci sono abbastanza componenti in magazzino", "Errore",
							JOptionPane.ERROR_MESSAGE);
			}else
				JOptionPane.showMessageDialog(null, "Non esistono vendibili con questo codice", "Errore", JOptionPane.ERROR_MESSAGE);
		} else {
			NegValueException exp = new NegValueException(quantit‡);
			throw (exp);
		}
	}

	/** 
	 * 	Calcola il totale della vendita sommando tutti i prezzi dei componenti vendibili associati alle righe di vendita
	 */
	public double calcolaTotaleVenditaComponenti() {
		double totale;
		totale = venditaCorrente.calcolaTotale();
		return totale;
	}
	
	/** 
	 * 	Conferma venditaCorrente e la inserisce nella mappa venditeRicambi
	 * @throws NegValueException 
	 */
	public void confermaVenditaVendibile() throws NegValueException {
		if(!((VenditaRicambi)venditaCorrente).getRigheDiVenditaComponente().isEmpty()) {
			String cv=venditaCorrente.getCodice();
			venditaCorrente.setDataEOraVendita();
			
			String codiceFiscale=venditaCorrente.getClienteAssociato().getCodiceFiscale();
			Session session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Cliente cln = session.get(Cliente.class,codiceFiscale);
			cln.incrementaNumVendite();
			session.getTransaction().commit();
			session.close();

			addVendita(cv, venditaCorrente);
			GashGUI.printInfo("Vendita:"+cv,venditaCorrente.toString()+"\n Totale: "+venditaCorrente.getTotale()+" Ä");
		}else {
			JOptionPane.showMessageDialog(null, "Devi inserire almeno un componente", "Errore", JOptionPane.ERROR_MESSAGE);
		}
		//Scalo quantit‡ componenti
		for(RigaDiVenditaComponente rv : ((VenditaRicambi)venditaCorrente).getRigheDiVenditaComponente()) {// scorro le righe di vendita	
			if(rv.getCv() instanceof ComponenteBase) {											//Controllo il tipo di Componente (Lamiera o ComponenteSingolo)
				int quantit‡=rv.getQuantit‡();
				((ComponenteBase)(rv.getCv())).aggiornaQuantit‡(-quantit‡);
			}else if(rv.getCv() instanceof Lamiera){
				int quantit‡=rv.getQuantit‡();
				double quantit‡pre=((Lamiera)(rv.getCv())).getMq();
				((Lamiera)(rv.getCv())).setMq(quantit‡pre-quantit‡);
			}
			
		}
	}


	public void visualizzaOrdini() {
		GashGUI.printInfo("Lista Ordini",ordini.toString());
	}
	

	public Vendita getVenditaCorrente() {
		return venditaCorrente;
	}

	/** Caso d'uso UC9
	 *  
	 */
	public boolean nuovoFornitore(String codice, String nome) {
				
		if(fornitori.get(codice)==null  && codice !=null && !codice.isEmpty() && !nome.isEmpty()) {
			fornitoreCorrente=new Fornitore(codice, nome);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Esiste gi‡ un fornitore con questo codice o hai inserito codice o nome null", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	public void aggiungiComponenteFornitore(String codice,String nome,double prezzo,String unitadimisura) throws NegValueException {
			if(prezzo>0) {
				if(!codice.isEmpty()) {
					fornitoreCorrente.aggiungiComponenteFornitore(codice,nome,prezzo,unitadimisura);
				} else {
				JOptionPane.showMessageDialog(null, "Inserimento annullato: Errori nell'inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
				} 
			}else {
				NegValueException exp=new NegValueException();
				throw(exp);
			}		
	}
	
	public void confermaFornitore() {
	
		String codiceFornitore=fornitoreCorrente.getCodiceFornitore();
		addFornitore(codiceFornitore, fornitoreCorrente);
		GashGUI.printInfo("Hai inserito correttamente il fornitore:", fornitoreCorrente.toString());
		
	}
	/**
	 * Estensioni caso d'uso UC9
	 * 
	 */
	public Fornitore ricercaFornitore(String codiceFornitore) {
		return fornitori.get(codiceFornitore);
	}

	/**
	 * Modifica Fornitore
	 */
	public boolean trovaFornitore(String codiceFornitore) {
		Fornitore f = fornitori.get(codiceFornitore);
		if (f != null) {
			fornitoreCorrente = f;
			JOptionPane.showMessageDialog(null,"Fornitore con codice: "+codiceFornitore+" trovato");
			return true;
		} else {
			JOptionPane.showMessageDialog(null,"Non esistono fornitori con codice: "+codiceFornitore);
			return false;
		}
	}

	public void modificaCodiceFornitore(String nuovoCodice) {
		if (!nuovoCodice.isEmpty()) {
			Fornitore f = fornitoreCorrente;
			fornitori.remove(fornitoreCorrente.getCodiceFornitore());
			f.setCodiceFornitore(nuovoCodice);
			addFornitore(nuovoCodice, f);
			fornitoreCorrente = fornitori.get(nuovoCodice);
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato il codice in "+nuovoCodice,null);
			JOptionPane.showMessageDialog(null, "Codice modificato", "Modifica fornitore",JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Errore il codice non puÚ essere nullo","Modifica fornitore", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void modificaNomeFornitore(String nuovoNome) {
		if(!nuovoNome.isEmpty()) {
			fornitoreCorrente.setNome(nuovoNome);
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato il nome in "+nuovoNome,null);
		} else {
			JOptionPane.showMessageDialog(null, "Errore il nome non puÚ essere nullo","Modifica fornitore", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void rimuoviComponenteFornitore(String codiceComponente) {
		if(!codiceComponente.isEmpty() && fornitoreCorrente.getComponentiFornitore().get(codiceComponente)!=null) {
		fornitoreCorrente.rimuoviComponenteFornitore(codiceComponente);
		if(GashGUI.statoGUI!=null)
			GashGUI.printInfo("Hai rimosso correttamente il componente "+codiceComponente,null);
		}
	}
	
	public void eliminaFornitore(String codiceFornitore) {
		if(fornitori.get(codiceFornitore)!=null) {
			JOptionPane.showMessageDialog(null,"Fornitore con codice: "+codiceFornitore+" eliminato");
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai eliminato correttamente il fornitore",null);
			fornitori.remove(codiceFornitore);
		} else {
			JOptionPane.showMessageDialog(null,"Non esistono fornitori con codice: "+codiceFornitore);
		}	
	}
	
	/** Caso d'uso UC11
	 *  
	 */
	public boolean nuovoCliente(String codiceFiscale,String denominazione,int partitaIVA,String domicilioFiscale,String email) throws NegValueException {
		
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		Cliente c=session.get(Cliente.class,codiceFiscale);
	
		session.getTransaction().commit();
		session.close();
		if(c==null && !codiceFiscale.isEmpty()) {
			if(partitaIVA>0) { //controllo semplificato; il controllo completo (non effettuato per semplicit‡) prevederebbe l'inserimento di un numero di 11 cifre
				clienteCorrente=new Cliente(codiceFiscale,denominazione, partitaIVA, domicilioFiscale, email);
			} else {
				NegValueException exp = new NegValueException(partitaIVA);
				throw (exp);
			}
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Esiste gi‡ un cliente con questo codice o hai inserito codice o nome null", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
		
		
	}
	public void confermaCliente() {
		String codiceFiscale=clienteCorrente.getCodiceFiscale();
		//Inserimento Database
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		session.save(clienteCorrente);
		session.getTransaction().commit();
		session.close();
		GashGUI.printInfo("Hai inserito correttamente il cliente:", clienteCorrente.toString());
	}
	
	/** Estensioni caso d'uso UC11
	 *  
	 */
	public Cliente ricercaCliente(String codiceFiscale) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		Cliente c=session.get(Cliente.class,codiceFiscale);
		session.getTransaction().commit();
		session.close();
		return c;
		
	}
	public Boolean trovaCliente(String codiceFiscale) {
		session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		Cliente c1=session.get(Cliente.class,codiceFiscale);
		
		Cliente c = c1;
		if (c != null) {
			clienteCorrente = c;
			return true;
		} else {
			return false;
		}	
	}
	
	public void modificaDenominazione(String nuovoNome) {
		
		if(!nuovoNome.isEmpty()) {
		clienteCorrente.setNomecognome_o_ragionesociale(nuovoNome);
		session.getTransaction().commit();
		session.close();
	
		if(GashGUI.statoGUI!=null)
			GashGUI.printInfo("Hai modificato la denominazione in "+nuovoNome,null);
		} else {
			JOptionPane.showMessageDialog(null, "Errore: la denominazione non puÚ essere nulla","Modifica cliente", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void modificaCodiceFiscale(String nuovoCodiceFiscale) {
		if(!nuovoCodiceFiscale.isEmpty()) {
			if(session.get(Cliente.class,nuovoCodiceFiscale)==null) {
				session.remove(clienteCorrente);
				clienteCorrente.setCodiceFiscale(nuovoCodiceFiscale);
				session.save(clienteCorrente);
				session.getTransaction().commit();
				session.close();
			
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato il codice fiscale in "+nuovoCodiceFiscale,null);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Errore: il codice non puÚ essere nullo","Modifica cliente", JOptionPane.ERROR_MESSAGE);
		}	
	}
	public void modificaPartitaIVA(int nuovaPartitaIVA) throws NegValueException {
		if(nuovaPartitaIVA>0) { //controllo semplificato
			clienteCorrente.setPartitaIVA(nuovaPartitaIVA);
			session.getTransaction().commit();
			session.close();
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato la partita IVA in "+nuovaPartitaIVA,null);
		} else {
			NegValueException exp = new NegValueException(nuovaPartitaIVA);
			throw (exp);
		}
	}
	
	public void modificaDomicilioFiscale(String nuovoDomicilioFiscale) {
		if(!nuovoDomicilioFiscale.isEmpty()) {
			clienteCorrente.setDomicilioFiscale(nuovoDomicilioFiscale);
			session.getTransaction().commit();
			session.close();
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato il domicilio fiscale in "+nuovoDomicilioFiscale,null);
		}	
	}
	
	public void modificaEmail(String nuovaEmail) {
		if(!nuovaEmail.isEmpty()) {
			clienteCorrente.setEmail(nuovaEmail);
			session.getTransaction().commit();
			session.close();
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai modificato l'email in "+nuovaEmail,null);
		}	
	}
	
	public void eliminaCliente(String codiceFiscale) {
		session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		Cliente c =session.get(Cliente.class,codiceFiscale);
		if(c!=null) {
			JOptionPane.showMessageDialog(null,"Cliente con codice: "+codiceFiscale+" eliminato");
			if(GashGUI.statoGUI!=null)
				GashGUI.printInfo("Hai eliminato correttamente il cliente",null);
			session.remove(c);
			session.getTransaction().commit();
			session.close(); 
		} else {
			JOptionPane.showMessageDialog(null,"Non esistono clienti con codice: " +codiceFiscale);	
		}
	}	
	

	/** Caso d'uso UC7
	 *  Ricerca Vendite
	 */
	
	//ricerca vendita usando codice
	public Vendita ricercaVendita(String codice) {
		if(!codice.isEmpty()) {
			Vendita v = vendite.get(codice);
			if(v!=null) {
				JOptionPane.showMessageDialog(null,"Vendita con codice: "+codice+" trovata");
				return v;
			} else {
				JOptionPane.showMessageDialog(null,"Non esistono vendite con codice: "+codice);
				return null;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Errore il codice non puÚ essere nullo","Ricerca vendite", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	/** Estensioni caso d'uso UC7
	 *  
	 */
	
	//visualizza tutte le vendite
	public void visualizzaVendite() {
		if(!vendite.isEmpty()) {
			GashGUI.printInfo("CATALOGO",vendite.toString());
		} else {
			JOptionPane.showMessageDialog(null,"Nessuna vendita da visualizzare");
		}
	}
	
	//ricerca vendite cliente usando codice fiscale
	public LinkedList<Vendita> ricercaVenditeCliente(String codiceFiscale) {
		LinkedList<Vendita> venditeCliente = new LinkedList<Vendita>();
		if(!codiceFiscale.isEmpty() && this.ricercaCliente(codiceFiscale)!=null) {
			for (Vendita value : vendite.values()) {
				if(value.getClienteAssociato().getCodiceFiscale().equals(codiceFiscale))
					venditeCliente.add(value);
			}
			return venditeCliente;
		} else {
			return null;
		}
	}	
	
	/** Estensioni caso d'uso UC10
	 *  
	 */
	
	public Vendibile ricercaComponente(String codice) {
		return catalogo.ricercaComponente(codice);
	}
	public boolean trovaComponente(String codice) {
		return catalogo.trovaComponente(codice);
	}
	
	public void modificaCodiceComponente(String codice) {
		catalogo.modificaCodiceComponente(codice);
	}
	
	public void modificaNomeComponente(String nome) {
		catalogo.modificaNomeComponente(nome);
	}
	
	public void modificaQuantitaComponente(int quantita) throws NegValueException {
		catalogo.modificaQuantitaComponente(quantita);
	}
	
	public void modificaMqComponente(double mq) throws NegValueException {
		catalogo.modificaMqComponente(mq);
	}
	
	public void modificaPrezzoComponente(double prezzo) throws NegValueException {
		catalogo.modificaPrezzoComponente(prezzo);
	}
	
	public void eliminaComponente(String codice) {
		catalogo.eliminaComponente(codice);
	}
	
	@Override
	public String toString() {
		return "Gash [catalogo=" + catalogo + ", venditaCorrente=" + venditaCorrente + ", ordineCorrente="
				+ ordineCorrente  + 
				 ", vendite=" + vendite + ", ordini=" + ordini + ", fornitori=" + fornitori
				+ ", calcolaTotaleVenditaPorte()=" + calcolaTotaleVenditaPorte() + "]";
	}
	
	/** Caso d'uso UC12 Arrivo Ordine
	 *  Inserisce i componenti ordinati nella lista componentiVendibili presente in catalogo
	 *  
	 */
	public void arrivoOrdine(String codiceOrdine) throws NegValueException {
		Ordine ordineArrivato = ordini.get(codiceOrdine);

		if (ordineArrivato != null) { 								// controllo se non ci sono ordini con quel codice 
			if(ordineArrivato.getStatoOrdine().equals("inArrivo")) {		// o se l'ordine arrivato Ë stato gi‡ stato registato
			for (RigaDiOrdine ro : ordineArrivato.getRigheDiOrdine()) {
				int quantitaOrdinata = ro.getQuantita();
				
					String codiceComponente=ro.getCf().getCodice();
					
					if (catalogo.getVendibile(codiceComponente) == null) { // Controllo se il componente non Ë presente nel sistema
						Vendibile v = null;
						if (ro.getCf().getUnitadimisura() == "mq") // Controllo unit‡ di misura
							v=new Lamiera(ro.getCf().getNome(), codiceComponente,ro.getCf().getPrezzo(), quantitaOrdinata);
						else if (ro.getCf().getUnitadimisura() == "unitario")
							v=new ComponenteSingolo(ro.getCf().getNome(), codiceComponente, ro.getCf().getPrezzo(), quantitaOrdinata);
						catalogo.addComponente(codiceComponente, v);
					} else {												//Se Ë presente basta aggiornare quantit‡
						
						if (ro.getCf().getUnitadimisura() == "mq") {// Controllo unit‡ di misura
							Lamiera lm=((Lamiera)(catalogo.getVendibile(codiceComponente)));
							double dispPrecedente=lm.getMq();
							lm.setMq(dispPrecedente+quantitaOrdinata);
						}
						else if (ro.getCf().getUnitadimisura() == "unitario") {
							ComponenteSingolo cb=((ComponenteSingolo)(catalogo.getVendibile(codiceComponente)));
							int dispPrecedente=cb.getQuantit‡();
							cb.setQuantit‡(dispPrecedente+quantitaOrdinata);
						}
					}
			}
			ordineArrivato.setStatoOrdine(new Processato());
			JOptionPane.showMessageDialog(null, "L'ordine Ë stato registrato con successo, quantit‡ componenti scalate", "Arrivo Ordine", JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null, "L'ordine Ë gi‡ stato registrato!", "Errore", JOptionPane.ERROR_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null, "Non ci sono ordini con quel codice!", "Errore", JOptionPane.ERROR_MESSAGE);
	}
	
	/** Caso d'uso UC8
	 *  
	 */
	
	public void segnalaConsegnaVendita(String codiceVendita) {
		Vendita v = this.ricercaVendita(codiceVendita);
		if(v instanceof VenditaPorte) {
			if(((VenditaPorte) v).getStatoVendita().equals("inConsegna")) {
				((VenditaPorte)v).setStatoVendita(new Consegnato());
				JOptionPane.showMessageDialog(null, "Stato vendita settato con successo", "Gestisci Consegne", JOptionPane.INFORMATION_MESSAGE);
			}else
				JOptionPane.showMessageDialog(null, "Stato vendita gi‡ settato in Consegnato!", "Errore", JOptionPane.ERROR_MESSAGE);
		}
	}
		
	
	/** Estensioni caso d'uso UC8
	 *  
	 */
	
	public LinkedList<Ordine> visualizzaOrdiniInArrivo() {
		LinkedList<Ordine> ordiniInArrivo = new LinkedList<Ordine>();
				for (Ordine value : ordini.values()) {
					if(value.getStatoOrdine().equals("inArrivo"))
						ordiniInArrivo.add(value);
				}
				return ordiniInArrivo;
	}
	
	public LinkedList<Ordine> visualizzaOrdiniProcessati() {
		LinkedList<Ordine> ordiniProcessati = new LinkedList<Ordine>();
				for (Ordine value : ordini.values()) {
					if(value.getStatoOrdine().equals("processato"))
						ordiniProcessati.add(value);
				}
				return ordiniProcessati;
	}
	
	public LinkedList<Vendita> visualizzaVenditeInConsegna() {
		LinkedList<Vendita> venditeInConsegna = new LinkedList<Vendita>();
		for (Vendita value : vendite.values()) {
			if(value instanceof VenditaPorte) {
				if(((VenditaPorte)value).getStatoVendita().equals("inConsegna")) {
					venditeInConsegna.add(value);
				}
			}
		}
		return venditeInConsegna;
	}
	
	public LinkedList<Vendita> visualizzaVenditeConsegnate() {
		LinkedList<Vendita> venditeConsegnate = new LinkedList<Vendita>();
		for (Vendita value : vendite.values()) {
			if(value instanceof VenditaPorte) {
				if(((VenditaPorte)value).getStatoVendita().equals("consegnato")) {
					venditeConsegnate.add(value);
				}
			}
		}
		return venditeConsegnate;
	}
	
	/** Funzione che crea un file e una directory se necessario.
	 *  
	 */
	public void writeFile(String value,String nomedir,String codice){
	
	    String directoryName = nomedir;
	    String fileName = nomedir+"_"+codice+".txt";

	    File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	    }

	    File file = new File(directoryName + "/" + fileName);
	    try{
	        FileWriter fw = new FileWriter(file.getAbsoluteFile());
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(value);
	        bw.close();
	    }
	    catch (IOException e){
	        e.printStackTrace();
	        System.exit(-1);
	    }
	}
	
}


