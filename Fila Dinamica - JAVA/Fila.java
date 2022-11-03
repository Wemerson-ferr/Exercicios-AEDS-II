package filadinamica;
//Fila(First in First out)
public class Fila {
	public celula prim;//"ponteiro"
	public celula ult;//"ponteiro para o topo, ou ultimo item da lista"
	private int tamanho;
	
	Fila(){
		prim = new celula();
		ult = prim; //N�o pode inverter "prim=ult" pois o ult ainda n�o foi inicializado
		tamanho = 0;
	}
	public void queue(int x) {//queue � um metodo para enfileirar a lista(adicionar item)
		ult.prox = new celula(x); //Define o ultimo it�m e cria "ponteiro" de ultimo* e proximo* para uma nova celula na fila.
		ult = ult.prox;
		tamanho++;
	}
	public int unqueue(){//unqueue � um metodo para desenfileirar, ou remover da fila a primeira celula
		if (prim == ult) {
		      System.out.println("Lista Vazia!");
		}
		celula tmp = prim.prox; //vari�vel temporaria para pegar o endere�o da proxima
		int retorna = tmp.elemento; //Salva o conteudo da celula que ser� removida para uso no main
		prim.prox = prim.prox.prox;//Faz com que o primeiro item aponte para o item posterior ao que ser� removido
		tmp.prox = null;
		tmp = null;
		if(prim.prox == null) {
			ult = prim;
		}
		tamanho--;
		return retorna;
	}
	public void mostrar() {
		celula tmp = prim.prox;
		while(tmp != null) {
			System.out.println(tmp.elemento);
			tmp=tmp.prox;
		}
		System.out.println();
	}
	public int getTamanho(){
		return this.tamanho;
	}
	public boolean testavazio() {
		if(ult==prim) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getMaior() {
		if(prim==ult) {
			System.out.println("A lista est� vazia!");
		}
		int maior=-0x7FFFFFFF;
		celula tmp = prim.prox;
		while(tmp!=null) {
			if(maior<tmp.elemento) {
				maior = tmp.elemento;
			}
			tmp = tmp.prox;
		}
		return maior;
	}
	int somaElementos() {
		if(prim==ult) {
			System.out.println("A lista est� vazia!");
		}
		int soma = 0;
		for(celula i=prim.prox; i!=null;i=i.prox) {
			soma+=i.elemento;
		}
		return soma;
	}
	int getElemento(int pos) {
		int cont=0;
		celula aux = prim.prox;
		if(prim==ult) {
			System.out.println("Fila vazia!");
			return 0;
		}
		else {
			while(cont<pos) {
				aux = aux.prox;
				cont++;
			}
			return aux.elemento;
		}
	}
	int removeFim() {
		celula i = prim.prox;
		while(i.prox.prox!=null) {
			i = i.prox;
		}
		celula aux =i.prox;
		ult = i;
		i.prox = null;
		return aux.elemento;
	}
}
