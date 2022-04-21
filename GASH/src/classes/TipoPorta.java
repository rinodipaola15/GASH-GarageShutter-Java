package classes;

import java.util.HashMap;
import java.util.Map;
import interfaces.Vendibile;

public class TipoPorta {
	
	private String codice;
	private String nome;
	private Map<String, ComponentePorta> componentiPorta;
	private Lamiera lamieraAssociata;

	public TipoPorta(String codice, String nome) {
		this.codice = codice;
		this.nome = nome;
		this.componentiPorta = new HashMap<String, ComponentePorta>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Override
	public String toString() {
		return "\n\n TipoPorta codice=" + codice + ", nome=" + nome + "\n Componenti della Porta\n" + componentiPorta
				+ "\n Lamiera associata\n" + lamieraAssociata + "]";
	}

	public void aggiungiComponentePorta(String codice, ComponenteBase  cb, int quantita) {
		ComponentePorta cp = new ComponentePorta(quantita, cb);
		componentiPorta.put(codice, cp);
	}

	public Map<String, ComponentePorta> getComponentiPorta() {
		return componentiPorta;
	}

	public void setComponentiPorta(Map<String, ComponentePorta> componentiPorta) {
		this.componentiPorta = componentiPorta;
	}

	public void associaTipoLamiera(Lamiera lm) {
		this.lamieraAssociata = lm;
	}

	public Lamiera getLamieraAssociata() {
		return lamieraAssociata;
	}

	public void setLamieraAssociata(Lamiera lamieraAssociata) {
		this.lamieraAssociata = lamieraAssociata;
	}
	
	public double getPrezzoBase() {
		double prezzoBase = 0;
		for(ComponentePorta value : componentiPorta.values()) {
			prezzoBase+=(value.getCb().getPrezzoVendita()*value.getQuantità());
		}
		return prezzoBase;
	}
	
	public double getPrezzoLamiera_al_mq() {
		double prezzoLamiera_al_mq;
		prezzoLamiera_al_mq = lamieraAssociata.getPrezzoVendita();
		return prezzoLamiera_al_mq;
	}

	public void rimuoviComponentePorta(String codiceComponente) {
		componentiPorta.remove(codiceComponente);
		
	}

	public void rimuoviLamiera() {
		lamieraAssociata=null;
	}
	

}
