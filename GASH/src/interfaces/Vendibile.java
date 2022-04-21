package interfaces;

import exceptions.NegValueException;

public interface Vendibile {
	   public double getPrezzoVendita();
	   public String getCodice();
	   public void setCodice(String codice);
	   public String getNome();
	   public void setNome(String nome);
	   public double getPrezzo();
	   public void setPrezzo(double prezzo);
	   
	   
}
