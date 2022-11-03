package listaClassEHeranca;

public abstract class Animal {
	private String nome;
	public abstract void setFala();
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
}
