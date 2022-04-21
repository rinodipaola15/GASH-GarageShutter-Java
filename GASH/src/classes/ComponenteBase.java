package classes;
import exceptions.SinglePartException;

public abstract class ComponenteBase extends Componente {

	public ComponenteBase(String nome, String codice, double prezzo, String unitadimisura) {
		super(nome, codice, prezzo, unitadimisura);
		// TODO Auto-generated constructor stub
	}

	public ComponenteBase(String nome, String codice, double prezzo) {
		super(nome, codice, prezzo);
	}

	public ComponenteBase(String nome, String codice) {
		super(nome,codice);
	}

	public void add(ComponenteBase cb) throws SinglePartException {
		if(this instanceof ComponenteBase) {
			throw new SinglePartException();
		}
	}
	public void remove(ComponenteBase cb) throws SinglePartException{
		if(this instanceof ComponenteBase) {
			throw new SinglePartException();
		}
	}
	public ComponenteBase getChild(int n) {
		return null;
	}

	public abstract double getPrezzoVendita();

	public abstract void aggiornaQuantità(int quantità);
	
	public abstract Boolean checkDisponibilità(int quantità);
	
}
