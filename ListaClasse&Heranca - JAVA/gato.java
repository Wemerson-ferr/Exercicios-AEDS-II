package listaClassEHeranca;

public class gato extends Animal{
	private String fala=null;
	public gato() {}
	public gato(String nome) {
		super.setNome(nome);
		this.setFala();
	}
	public String getFala() {
		return(fala);
	}
	@Override
	public void setFala() {
		fala="Miau";
	}
}
