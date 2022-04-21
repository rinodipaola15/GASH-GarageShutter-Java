package classes;

import java.util.LinkedList;
import interfaces.Vendibile;

public class KitComponenti extends ComponenteBase implements Vendibile {
	private LinkedList<ComponenteBase> children;
	public KitComponenti(String nome, String codice) {
		super(nome, codice);
		this.children = new LinkedList<ComponenteBase>();
		super.setUnitadimisura("unitario");
	}

	@Override
	public double getPrezzoVendita() {
		double prezzoVendita=0;
		for(ComponenteBase child: children) {
			prezzoVendita+=child.getPrezzoVendita();
		}
		return prezzoVendita;
	}
	@Override
	public String toString() {
		String toString="KitComponenti [nome=" + super.getNome() +", codice=" + super.getCodice() + ", prezzo=" + super.getPrezzo() + ", unitadimisura="+ super.getUnitadimisura() +", prezzoVendita=" + this.getPrezzoVendita()+"\n Composto da:";
		for(ComponenteBase child: children) {
			toString+="\n\t"+child.toString();
		}
		return toString;
	}
	
	
	public void add(ComponenteBase cb){
		children.add(cb);
		super.setPrezzo(getPrezzo()+cb.getPrezzo());
	}
	public void remove(ComponenteBase cb) {
		children.remove(cb);
		super.setPrezzo(getPrezzo()-cb.getPrezzo());
	}
	public ComponenteBase getChild(int n) {
		return children.get(n);
	}

	@Override
	public void aggiornaQuantità(int quantità) {
		for(ComponenteBase child: children) {
			child.aggiornaQuantità(quantità);
		}
		
	}

	@Override
	public Boolean checkDisponibilità(int quantità) {
		Boolean disponibile=true;
		for(ComponenteBase child: children) {
			if(!child.checkDisponibilità(quantità)) {
				disponibile=false;
				return disponibile;
			}
		}
		return disponibile;
	}

}
