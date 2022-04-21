package classes;

public class ComponentePorta {
	private int quantit�;
	private ComponenteBase  cb;
	
	
	public ComponentePorta(int quantit�, ComponenteBase  cb) {
		super();
		this.quantit� = quantit�;
		this.cb = cb;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	public ComponenteBase  getCb() {
		return cb;
	}

	public void setCb(ComponenteBase  cb) {
		this.cb = cb;
	}

	@Override
	public String toString() {
		return "ComponentePorta [quantit�=" + quantit� + ", cb=" + cb + "]\n";
	}
	
	
}
