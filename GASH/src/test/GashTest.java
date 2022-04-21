package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import classes.Cliente;
import classes.ComponenteFornitore;
import classes.ComponenteSingolo;
import classes.Fornitore;
import classes.Gash;
import classes.HibernateUtil;
import classes.Lamiera;
import classes.Ordine;
import classes.RigaDiOrdine;
import classes.RigaDiVenditaPorta;
import classes.TipoPorta;
import classes.Vendita;
import classes.VenditaPorte;
import classes.VenditaRicambi;
import exceptions.NegValueException;
import interfaces.Vendibile;

class GashTest {
	Gash gash = Gash.getInstance()
			;
	
	
	/**
	 * Test UC1
	 */
	@Test
	void testNuovoOrdine() {
		Ordine o = new Ordine("ord17");
		gash.addOrdine(o.getCodice(), o);

		// Inserimento Ordine già esistente	
		gash.nuovoOrdine("ord17");
		assertEquals("e' stato inserito un ordine già esistente", false, gash.getOrdineCorrente().getCodice().equals("ord17"));

		// Inserimento codice vuoto		
		gash.nuovoOrdine("");
		assertEquals("e' stato inserito un codice vuoto", false, gash.getOrdineCorrente().getCodice().equals(""));
		
	}
	
	
	@Test
	void testNuovaRigaDiOrdine() throws NegValueException {
		/** Preparazione dati per i vari test */
		Fornitore f1 = new Fornitore("forn1", "Edilman srl");
		ComponenteFornitore cf1 = new ComponenteFornitore("molla", "COM001", 23, "unitario");
		gash.addComponenteFornitore(f1, cf1.getCodice(), cf1);
		gash.addFornitore(f1.getCodiceFornitore(), f1);
		gash.nuovoOrdine("ord1");
		gash.getOrdineCorrente().setFornitore(f1);
		
		// Inserimento componente non esistente nella lista di componenti del fornitore
		String expected = "nontrovato";
		gash.nuovaRigaDiOrdine("COM002", 5);
		
		String risultato = "nontrovato";
		for(RigaDiOrdine ro : gash.getOrdineCorrente().getRigheDiOrdine()) {
			if(ro.getCf().getCodice()=="COM002")
				risultato = "trovato";
		}
		
		
		assertEquals("componente non esistente nella lista di componenti del fornitore", expected, risultato);
		
		// Inserimento componente esistente nella lista di componenti del fornitore (corretto)
				String expected2 = "trovato";
				gash.nuovaRigaDiOrdine("COM001", 5);
				
				String risultato2 = "nontrovato";
				for(RigaDiOrdine ro : gash.getOrdineCorrente().getRigheDiOrdine()) {
					if(ro.getCf().getCodice()=="COM001")
						risultato2 = "trovato";
				}
				
				assertEquals("componente esistente nella lista di componenti del fornitore", expected2, risultato2);
	}
	
	/**
	 * Test UC3
	 */
	@Test
	void testNuovaVenditaPorte() {
		VenditaPorte vp = new VenditaPorte("vp1");
		gash.addVendita(vp.getCodice(), vp);

		// Inserimento VenditaPorte già esistente
		gash.nuovaVenditaPorte("vp1");			
		assertEquals("e' stata inserita una vendita di porte già esistente", false, gash.getVenditaCorrente().getCodice().equals("vp1"));

		// Inserimento codice vuoto
		gash.nuovaVenditaPorte("");
		assertEquals("e' stato inserito un codice vuoto", false, gash.getVenditaCorrente().getCodice().equals(""));
	}
	
	@Test
	void testNuovaRigaDiVenditaPorte() throws NegValueException {
		/** Preparazione dati per i vari test */
		TipoPorta tp = new TipoPorta("POR005", "prova");
		Lamiera lam004 = new Lamiera("LAM004", "LAM004", 150, 100);
		gash.addComponente("LAM004", lam004);
		tp.associaTipoLamiera(lam004);
		gash.getCatalogo().addTipoPorta("POR005", tp);

		// Inserimento riga di vendita relativa a una porta non presente nella mappa dei tipi porta
		String expected = "nontrovato"; //ci si aspetta che la riga di vendita non venga creata
		gash.nuovaVenditaPorte("vp2");
		gash.nuovaRigaDiVenditaPorte("POR003", 2, 4);
		String risultato = "nontrovato";
		for(RigaDiVenditaPorta rv : ((VenditaPorte)gash.getVenditaCorrente()).getRigheDiVenditaPorta()) {
			if(rv.getTp().getCodice()=="POR003")
				risultato = "trovato";
		}
		
		assertEquals("porta non presente nella mappa dei tipi porta", expected, risultato);
		
		// Inserimento riga di vendita relativa a una porta presente nella mappa dei tipi porta (corretto)
		String expected2 = "trovato";
		gash.nuovaVenditaPorte("vp2");
		gash.nuovaRigaDiVenditaPorte("POR005", 2, 4);
		String risultato2 = "nontrovato";
		for(RigaDiVenditaPorta rv : ((VenditaPorte)gash.getVenditaCorrente()).getRigheDiVenditaPorta()) {
			if(rv.getTp().getCodice()=="POR005")
				risultato2 = "trovato";
		}
		
		assertEquals("porta non presente nella mappa dei tipi porta", expected2, risultato2);
		
	}
	
	/** Test  Caso d'uso UC5
	 * 
	 */
	@Test
	void testNuovaVenditaComponenti() {
		VenditaRicambi vr=new VenditaRicambi("VEN001");
		gash.addVendita("VEN001", vr);
		
		//codice nullo
		gash.nuovaVenditaComponenti("");
		
		assertEquals("e' stato inserito un codice vuoto", false, gash.getVenditaCorrente().getCodice().equals(""));
		
		//Vendita con quel codice gia esistente
		gash.nuovaVenditaComponenti("VEN001");
		
		assertEquals("e' stato inserito un codice di vendita gia esistente", false, gash.getVenditaCorrente().getCodice().equals("VEN001"));
	}
	
	@Test
	void testSelezionaDatiClienteRicambio() {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		Cliente  c1 = session.get(Cliente.class,"abcd");
		session.getTransaction().commit();
		session.close();
		
		gash.nuovaVenditaComponenti("VER001");
		
		//codice fiscale nullo
		gash.selezionaDatiClienteRicambio("");
		assertNull(gash.getVenditaCorrente().getClienteAssociato(), "e' stato inserito un codice fiscale nullo");
		
		//Seleziona cliente non esistente
		gash.selezionaDatiClienteRicambio("sad");
		assertNull(gash.getVenditaCorrente().getClienteAssociato(), "e' stato inserito un cliente non esistente");
		
		//Seleziona cliente esistente
		gash.selezionaDatiClienteRicambio("abcd");
		assertEquals("é stato inserito un cliente esistente",c1.getCodiceFiscale(),gash.getVenditaCorrente().getClienteAssociato().getCodiceFiscale());
	
	}
	@Test
	void testNuovaRigaDiComponente() throws NegValueException {
		
		Vendibile cv=new ComponenteSingolo("molle","COM001",23, 3);
		gash.addComponente("COM001", cv);
		gash.nuovaVenditaComponenti("VER001");
		//componente non esistente nella lista vendibile
		gash.nuovaRigaDiComponente("COM002323", 2);
		assertEquals("è stato inserito un componente vendibile non esistente ",true,((VenditaRicambi)gash.getVenditaCorrente()).getRigheDiVenditaComponente().isEmpty());

		//componente esistente nella lista vendibile
		gash.nuovaRigaDiComponente("COM001", 2);
		assertNotNull(((VenditaRicambi)gash.getVenditaCorrente()).getRigheDiVenditaComponente(),"è stato inserito un componente vendibile esistente ");
		
	}
	@Test
	void testCalcolaTotaleVenditaComponenti() throws NegValueException {
		
		Vendibile cv=new ComponenteSingolo("molle","COM001",20, 3);
		Vendibile cv2=new ComponenteSingolo("motore","COM002",120, 3);
		gash.addComponente("COM001", cv);
		gash.addComponente("COM002", cv2);
		gash.nuovaVenditaComponenti("VER002");
		gash.selezionaDatiClienteRicambio("prova");
		
		gash.nuovaRigaDiComponente("COM001", 2);
		gash.nuovaRigaDiComponente("COM002", 3);
		
		//Calcolo totale corretto
		Double totale=gash.calcolaTotaleVenditaComponenti();
		assertEquals(520,totale,"e' stato calcolato il totale della vendita");
	}


}
