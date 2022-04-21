package classes;

public class ComponentePorta {
	private int quantità;
	private ComponenteBase  cb;
	
	
	public ComponentePorta(int quantità, ComponenteBase  cb) {
		super();
		this.quantità = quantità;
		this.cb = cb;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	public ComponenteBase  getCb() {
		return cb;
	}

	public void setCb(ComponenteBase  cb) {
		this.cb = cb;
	}

	@Override
	public String toString() {
		return "ComponentePorta [quantità=" + quantità + ", cb=" + cb + "]\n";
	}
	
	
}
