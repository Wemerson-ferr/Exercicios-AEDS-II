package tads;

public class Lista {
	Celula prim;
	Celula ult;
	private int tam = -1;//Tamanho considerado como útil tam-1;
	Lista(){
		prim = new Celula();
		ult = prim;
		tam++;
	}
	void inserirInicio(Celula x) {
		if(prim==ult) {
			prim.prox = x;
			ult = x;
			tam++;
		}
		else{
			x.prox = prim.prox;
			prim.prox = x;
			tam++;
		}
	}
	Celula removerInicio() {
		Celula aux;
		aux = prim.prox;
		prim.prox = prim.prox.prox;
		aux.prox = null;
		tam--;
		return aux;
	}
	void mostrar() {
		Celula i = prim.prox;
		while(i!=null){
			System.out.printf("Nome: %s \nIdade: %d\n",i.nome, i.idade);
			System.out.println();
			i = i.prox;
		}
	}
	void tamanhoAtual() {
		System.out.println("Tamanho atual: "+tam);
	}
	boolean isEmpty() {
		boolean res = prim==ult ? true : false;
		return res;
	}
	int mediaIdadesIter() {
		Celula i = prim.prox;
		int media=0;
		while(i!=null) {
			media = media + i.idade;
			i = i.prox;
		}
		return media;
	}
	int mediaRec() {//Esta vai ser a chamada no main, que irá instanciar a celula i e iniciar a verdadeira chamada rescursiva;
		Celula i = prim.prox;
		return mediaRecOculta(0, i);
	}
	private int mediaRecOculta(int media, Celula i) {
		if(prim==ult) {
			System.out.println("Lista vazia!");
		}
		else if (i==null) {
			return media/tam;
			
		}
		else {
			return media=+mediaRecOculta(media+i.idade, i.prox);
			
		}
		return 0;
	}
}
