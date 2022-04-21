package classes;

public class ComponenteFornitore extends Componente {

	public ComponenteFornitore(String nome, String codice, double prezzo, String unitadimisura) {
		super(nome, codice, prezzo, unitadimisura);
	}
	@Override
	public String toString() {
		return "ComponenteFornitore [Nome=" + getNome() + ", Prezzo=" + getPrezzo() + ", Unitadimisura="
				+ getUnitadimisura() + ", Codice=" + getCodice() + "]\n";
	}
	
}
