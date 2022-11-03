package listaClassEHeranca;

public class Homem extends Animal {
	static private String fala=null;
	public Homem() {}
	public Homem(String nome) {
		super.setNome(nome);
		this.setFala();
	}
	public String getNome() {
		return(super.getNome());
	}
	public String getFala() {
		return(fala);
	}
	@Override
	public void setFala() {
		fala = "Oi";
		
	}
	
}
