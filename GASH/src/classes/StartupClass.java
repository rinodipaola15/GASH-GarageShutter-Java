package classes;

import exceptions.NegValueException;

public class StartupClass {
	
	private Gash gash;

	public StartupClass(Gash gash) {
		this.gash = gash;
		
		Lamiera lm1 = new Lamiera("8mm", "LAM001", 20, 10);
		Lamiera lm2 = new Lamiera("9mm", "LAM002", 20, 10);
		Lamiera lm3 = new Lamiera("10mm", "LAM003", 200);

		ComponenteSingolo cb1 = new ComponenteSingolo("molla", "COM001", 23, 100);
		ComponenteSingolo cb2 = new ComponenteSingolo("tubo", "COM002", 13, 100);
		ComponenteSingolo cb3 = new ComponenteSingolo("motore cam12", "COM003", 103, 200);
		
		KitComponenti kit1= new KitComponenti("Kit a","KIT001");
		kit1.add(cb1);
		kit1.add(cb2);
		
		Fornitore f1 = new Fornitore("forn1", "Edilman srl");
		
		//Cliente c1 = new Cliente("sadasdasdsadsad", "Bud Spencer", 1234, "via Etnea 15","dasdas@gmail.com");
		
		ComponenteFornitore cf1 = new ComponenteFornitore("molla", "COM001", 23, "unitario");
		ComponenteFornitore cf2 = new ComponenteFornitore("lamiera", "LAM001", 35, "mq");
		ComponenteFornitore cf3 = new ComponenteFornitore("tubo", "COM005", 23, "unitario");
		ComponenteFornitore cf4 = new ComponenteFornitore("lamiera 22", "LAM005", 35, "mq");
		
		gash.addComponenteFornitore(f1, cf1.getCodice(), cf1);
		gash.addComponenteFornitore(f1, cf2.getCodice(), cf2);
		gash.addComponenteFornitore(f1, cf3.getCodice(), cf3);
		gash.addComponenteFornitore(f1, cf4.getCodice(), cf4);
		
		gash.addComponente(cb1.getCodice(), cb1);
		gash.addComponente(cb2.getCodice(), cb2);
		gash.addComponente(cb3.getCodice(), cb3);
		gash.addComponente(lm1.getCodice(), lm1);
		gash.addComponente(lm2.getCodice(), lm2);
		gash.addComponente(lm3.getCodice(), lm3);

		gash.addComponente(kit1.getCodice(), kit1);
		
		
		gash.printComponentiVendibili();
		
		gash.addFornitore(f1.getCodiceFornitore(), f1);
		
		
		
		// Caso d'uso 2 Aggiunta porta di prova
		try {
			gash.nuovoTipoPorta("POR001", "Porta di Prova");
			gash.aggiungiComponentePorta("COM001", 2);
			gash.aggiungiComponentePorta("COM002", 2);
			gash.associaLamieraPorta("LAM002");
			gash.confermaTipoPorta();
		} catch (NegValueException ex) {
			System.out.println(ex.getMessage());
		} catch (NumberFormatException ex) {
			System.out.println("Formato errato!");
			ex.printStackTrace();
		}
	
	
	try {
		gash.nuovoTipoPorta("POR002", "Porta con kit a");
		gash.aggiungiComponentePorta("KIT001", 2);
		gash.aggiungiComponentePorta("COM002", 2);
		gash.associaLamieraPorta("LAM001");
		gash.confermaTipoPorta();
	} catch (NegValueException ex) {
		System.out.println(ex.getMessage());
	} catch (NumberFormatException ex) {
		System.out.println("Formato errato!");
		ex.printStackTrace();
	}
}

	
}
