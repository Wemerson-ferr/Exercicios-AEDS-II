package listaClassEHeranca;

public class cao extends Animal {
	private String fala=null;
	public cao() {}
	public cao(String nome) {
		super.setNome(nome);
		this.setFala();
	}
	public String getFala() {
		return(fala);
	}
	@Override
	public void setFala() {
		fala = "Au Au";
	}
}
