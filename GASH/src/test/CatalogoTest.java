package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import classes.Catalogo;
import classes.ComponenteSingolo;

import classes.ComponentePorta;
import classes.Lamiera;
import classes.TipoPorta;


class CatalogoTest {

	Catalogo catalogo = Catalogo.getInstance();

	/**
	 * Test UC2
	 */
	@Test
	void testNuovoTipoPorta() {
		TipoPorta tp = new TipoPorta("POR001", "prova");
		catalogo.addTipoPorta("POR001", tp);

		// Inserimento tipo Porta già esistente
		TipoPorta expected = null;
		catalogo.nuovoTipoPorta("POR001", "porta prova");
		assertEquals("e' stato inserita una porta già esistente", expected, catalogo.getTipoPortaCorrente());

		// Inserimento codice vuoto
		catalogo.nuovoTipoPorta("", "porta a");
		assertEquals("e' stato inserito un codice vuoto", expected, catalogo.getTipoPortaCorrente());

		// Inserimento nome vuoto
		catalogo.nuovoTipoPorta("POR002", "");
		assertEquals("e' stato inserito un nome vuoto", expected, catalogo.getTipoPortaCorrente());

	}

	@Test
	void testAggiungiComponentePorta() {
		/** Preparazione dati per i vari test */
		catalogo.nuovoTipoPorta("POR001", "porta prova");
		ComponenteSingolo cb = new ComponenteSingolo("Prova", "COM001", 20, 10);
		catalogo.addComponente("COM001", cb);
		Lamiera lm = new Lamiera("Lam prova", "LAM001", 20, 25);
		catalogo.addComponente("LAM001", lm);

		// Inserimento componente non esistente
		ComponentePorta expected = null;
		catalogo.aggiungiComponentePorta("COM004", 3);
		assertEquals("e' stato inserito un componente non esistente", expected,
				catalogo.getTipoPortaCorrente().getComponentiPorta().get("COM004"));

		// Inserimento quantità negativa
		catalogo.aggiungiComponentePorta("COM001", -3);
		assertEquals("e' stato inserita una quantita negativa", expected,
				catalogo.getTipoPortaCorrente().getComponentiPorta().get("COM001"));

		// Inserimento codice Vendibile ma lamiera
		catalogo.aggiungiComponentePorta("LAM001", 3);
		assertEquals("e' stato inserita un codice di lamiera", expected,
				catalogo.getTipoPortaCorrente().getComponentiPorta().get("LAM001"));

		// Inserimento componente esistente e con quantita corretta
		ComponenteSingolo expected2 = cb;
		catalogo.aggiungiComponentePorta("COM001", 3);
		assertEquals("e' stato inserito un componente esistente", expected2,
				catalogo.getTipoPortaCorrente().getComponentiPorta().get("COM001").getCb());
	}

	@Test
	void testAssociaLamieraPorta() {
		/**Preparazione dati per i vari test*/
		catalogo.nuovoTipoPorta("POR006","porta prova");
		ComponenteSingolo cb=new ComponenteSingolo("Prova","COM001", 20, 10);
		catalogo.addComponente("COM001",cb);
		Lamiera lm=new Lamiera("Lam prova", "LAM001",20,25);
		catalogo.addComponente("LAM001",lm);
		
		//Inserimento Lamiera non esistente
		
		catalogo.associaLamieraPorta("LAM044");
		assertNull(catalogo.getTipoPortaCorrente().getLamieraAssociata(),"e' stato inserita una lamiera non esistente");
		
		//Inserimento codice nullo
		catalogo.associaLamieraPorta("");
		assertNull(catalogo.getTipoPortaCorrente().getLamieraAssociata(),"e' stato inserito un codice null");
		
		//Tentativo di associazione di un ComponenteSingolo
		catalogo.associaLamieraPorta("COM001");
		assertNull(catalogo.getTipoPortaCorrente().getLamieraAssociata(),"e' stato inserito un codice componente base");
		
	}

	@Test
	void testAddTipoPorta() {
		TipoPorta tp = new TipoPorta("POR001", "prova");
		
		// codice nullo
		catalogo.addTipoPorta("", tp);
		assertNull(catalogo.getTipiPorta().get(""), "e' stato inserito un tipo porta con codice nullo");
		// inserimento corretto
		catalogo.addTipoPorta("POR001", tp);
		assertNotNull(catalogo.getTipiPorta().get("POR001"), "e' stato inserito un tipo porta corretto");
	}

	/**
	 * Test Estensioni UC2
	 */
	@Test
	void modificaNomePorta() {
		/**Preparazione dati per i vari test*/
		TipoPorta tp = new TipoPorta("POR001", "prova");
		catalogo.addTipoPorta("POR001", tp);
		catalogo.selezionaPorta("POR001");
		
		// Modifica nome porta
		catalogo.modificaNomePorta("ciccio");
		assertEquals("e' stato modificato il nome della porta", "ciccio",catalogo.getTipiPorta().get("POR001").getNome());

		// Modifica nome porta con nome nullo
		catalogo.modificaNomePorta("");
		assertEquals("e' stato modificato il nome della porta con nome nullo", "ciccio",catalogo.getTipiPorta().get("POR001").getNome());

	}

	@Test
	void testEliminaPorta() {
		TipoPorta tp = new TipoPorta("POR001", "prova");
		catalogo.addTipoPorta("POR001", tp);
		
		// Eliminazione Porta
		catalogo.eliminaPorta("POR001");
		assertNull(catalogo.getTipiPorta().get("POR001"), "e' stata eliminata una porta");

	}	
	
}
