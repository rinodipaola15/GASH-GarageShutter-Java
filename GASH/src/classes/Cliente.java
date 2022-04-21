package classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {
	@Id //Primary key
	@Column(name="codiceFiscale")
	private String codiceFiscale;
	
	@Column(name="nomecognome_o_ragionesociale")
	private String nomecognome_o_ragionesociale;
	
	@Column(name="partitaIVA")
	private int partitaIVA;
	
	@Column(name="domicilioFiscale")
	private String domicilioFiscale;
	
	@Column(name="email")
	private String email;
	
	@Column(name="numVendite")
	private int numVendite=0;
	
	public Cliente() {
		super();
	}
	public Cliente(String codiceFiscale, String nomecognome_o_ragionesociale, int partitaIVA, String domicilioFiscale,
			String email, int numVendite) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nomecognome_o_ragionesociale = nomecognome_o_ragionesociale;
		this.partitaIVA = partitaIVA;
		this.domicilioFiscale = domicilioFiscale;
		this.email = email;
		this.numVendite = numVendite;
	}
	public Cliente(String codiceFiscale, String nomecognome_o_ragionesociale, int partitaIVA, String domicilioFiscale,String email) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nomecognome_o_ragionesociale = nomecognome_o_ragionesociale;
		this.partitaIVA = partitaIVA;
		this.domicilioFiscale = domicilioFiscale;
		this.email=email;
	}
	public Cliente(String codiceFiscale, String nomecognome_o_ragionesociale, String domicilioFiscale) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nomecognome_o_ragionesociale = nomecognome_o_ragionesociale;
		this.domicilioFiscale = domicilioFiscale;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNomecognome_o_ragionesociale() {
		return nomecognome_o_ragionesociale;
	}
	public void setNomecognome_o_ragionesociale(String nomecognome_o_ragionesociale) {
		this.nomecognome_o_ragionesociale = nomecognome_o_ragionesociale;
	}
	public int getPartitaIVA() {
		return partitaIVA;
	}
	public void setPartitaIVA(int partitaIVA) {
		this.partitaIVA = partitaIVA;
	}
	public String getDomicilioFiscale() {
		return domicilioFiscale;
	}
	public void setDomicilioFiscale(String domicilioFiscale) {
		this.domicilioFiscale = domicilioFiscale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumVendite() {
		return numVendite;
	}
	public void setNumVendite(int numVendite) {
		this.numVendite = numVendite;
	}
	public void incrementaNumVendite() {
		this.numVendite++;
	}
	
	@Override
	public String toString() {
		return "Cliente [codiceFiscale=" + codiceFiscale + ", denominazione="
				+ nomecognome_o_ragionesociale + ", partitaIVA=" + partitaIVA + ", domicilioFiscale=" + domicilioFiscale
				+ ", email=" + email + "]\n";
	}
	
	
}
