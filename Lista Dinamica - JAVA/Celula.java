package tads;

public class Celula {
	String nome;
	int idade;
	Celula prox;
	
	Celula(){
		this("desconhecido", 0);
	}
	Celula(String NOME, int IDADE){
		idade = IDADE;
		nome = NOME;
		prox = null;
	}
}
