package filadinamica;

public class celula {
	public int elemento;
	public celula prox;//"Ponteiro" que aponta para o proximo itém celula criadoS
	
	celula(){
		this(0);
	}
	celula(int elemento){
		this.elemento = elemento;
		this.prox = null;
	}
	
}
