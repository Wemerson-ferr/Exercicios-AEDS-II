package ordenadores;

import java.util.Random;

public class Ex02 {
	static int[] criaCopia(int[]vetor) {
		int[] vetorCopia = new int[vetor.length];
		for(int i=0; i<vetorCopia.length; i++) {
			vetorCopia[i] = vetor[i];
		}
		return vetorCopia;
	}
	static void preencheCres(int [] vetor) {//Função que preenche o vetor
		for(int i=0; i<vetor.length; i++) {
			vetor[i] = i;
		}
	}
	static void preencheDecres(int [] vetor) {//Função que preenche o vetor
		for(int i=vetor.length;i>0;i--) {
			vetor[vetor.length-i] = i;
		}
	}
	static void preencheRandom(int[] vetor) {
		Random r = new Random();
		for(int i=0; i<vetor.length;i++) {
			vetor[i] = r.nextInt();
		}
	}
	static void swap(int x, int y, int[]swap) {
		int aux = swap[x];
		swap[x] = swap[y];
		swap[y] = aux;
	}
	static void BubbleSort(int[]bubble) {
		for(int i=bubble.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(bubble[j]>bubble[j+1]) {
					swap(j,j+1, bubble);
				}
			}
		}
	}
	static void SelectionSort(int[]selection) {
		for(int i=0;i<selection.length-1;i++) {
			int menor =  i;
			for(int j=i+1;j<selection.length;j++) {
				if(selection[menor]>selection[j]) {
					menor= j;
				}
			}
			if(i!=menor) {
				int aux = selection[menor];
				selection[menor] = selection[i];
				selection[i] = aux;
			}
		}
	}
	static void InsertionSort(int[]insertion) {
		for(int i=1;i<insertion.length;i++) {
			int temp = insertion[i];
			int j =i-1;
			while((j>=0)&&(insertion[j]>temp)) {
				insertion[j+1] = insertion[j];
				j--;
			}
			insertion[j+1] = temp;
		}
	}
//-----------------> Metodos isolados do Heap - Inicio <----------------------------------------//	
		static void HeapSort(int[] heap) {
			int[] heaper = new int[heap.length+1];
			for(int i=1; i<heaper.length; i++) {
				heaper[i] = heap[i-1];
			}
			int n = heaper.length-1;
			//construção do heap
			for(int tam=2; tam<=n; tam++) {
				construir(tam, heaper);
			}
			//ordenação
			int tam=n;
			while(tam>1) {
				swap(1,(tam--), heaper);
				reconstroi(tam, heaper);
				
			}
			for(int i=1;i<heaper.length;i++) {
				heap[i-1]=heaper[i];
			}
		}
		static void construir(int tam, int[]heaper) {
			for(int i=tam;i>1 &&(heaper[i]>heaper[i/2]);i/=2) {
				swap(i,i/2,heaper);
			}
		}
		static void reconstroi(int tam, int[]heaper) {
			int i=1;
			//verifica se tem filho
			while(hasFilho(i,tam)) {
				int filho = maiorFilho(i, tam, heaper);
				if (heaper[i]<(heaper[filho]))
	            {
	                swap(i, filho, heaper);
	                i = filho;
	            }
	            else
	            {
	                i = tam;
	            }

			}
		}
		static int maiorFilho(int i, int tam, int[]heaper) {
			int retornaMaior;
			if((2*i==tam)||(heaper[(2*i)+1]<(heaper[2*i])))
			{
	            retornaMaior = 2*i;
	        }
	        else {
	            retornaMaior = 2*i+1;
	        }

	        return retornaMaior;
	    }	
		static boolean hasFilho(int i, int tam) {
			return (i <= (tam/2));
		}
//-----------------> Metodos isolados do Merge - Inicio <---------------------------------------//
		static void MergeSort(int esq, int dir, int[]merge) {
			 if (esq < dir){
				 int meio = (esq + dir) / 2;
				 MergeSort(esq, meio, merge);
				 MergeSort(meio + 1, dir, merge);
				 intercalar(esq, meio, dir, merge);
			 }
		}
		static void intercalar(int esq, int meio, int dir, int[]merge){
			 //Definir tamanho dos dois subarrays
			 int nEsq = (meio+1)-esq;
			 int nDir = dir - meio;
			 int[] arrayEsq = new int[nEsq+1];
			 int[] arrayDir = new int[nDir+1];
			 //Sentinela no final dos dois arrays
			 arrayEsq[nEsq] = arrayDir[nDir] = 0x7FFFFFFF;
			 int iEsq, iDir, i; 
			 //Inicializar primeiro subarray
			 for (iEsq = 0; iEsq < nEsq; iEsq++){
			 arrayEsq[iEsq] = merge[esq+iEsq];
			 }
			 //Inicializar segundo subarray
			 for (iDir = 0; iDir < nDir; iDir++){
			 arrayDir[iDir] = merge[(meio+1)+iDir];
			 }
			 //Intercalacao propriamente dita
			 for (iEsq = iDir = 0, i = esq; i <= dir; i++){
			 merge[i] = (arrayEsq[iEsq]<=(arrayDir[iDir])) ? arrayEsq[iEsq++] : arrayDir[iDir++];
			 }
			}		
//-----------------> Metodos isolados do Quick - Inicio <---------------------------------------//
		static void QuickSort(int esq, int dir, int[]quick) {
			int i = esq, j = dir;
			int pivo = quick[(esq+dir)/2];
			while (i <= j){
			while (quick[i]<(pivo))
				{i++;}
			while (quick[j]>(pivo))
				{j--;}
			if (i <= j){
				swap(i, j, quick); i++; j--; }
			}
			if (esq < j) {
				QuickSort(esq, j, quick);}
			if (i < dir) {
				QuickSort(i, dir, quick);}
		}
	public static void main(String[] args) {
		//int[] vetor = new int[1000];
		int[] vetor = new int[10000];
		//int[] vetor = new int[100000];
		//int[] vetor = new int[1000000];
		//preencheCres(vetor);
		//preencheDecres(vetor);
		preencheRandom(vetor);
		
		long inicioBubble = System.currentTimeMillis();
		BubbleSort(criaCopia(vetor));
		long tempoTrascorridoBubble =(System.currentTimeMillis() - inicioBubble);
		System.out.printf("O tempo do método BubbleSort foi de %.2f microsegundos\n", tempoTrascorridoBubble*1000d);
		long inicioSelection = System.currentTimeMillis();
		SelectionSort(criaCopia(vetor));
		long tempoTrascorridoSelection =(System.currentTimeMillis() - inicioSelection);
		System.out.printf("O tempo do método SelectionSort foi de %.2f microsegundos\n", tempoTrascorridoSelection*1000d);
		long inicioInsertion = System.currentTimeMillis();
		InsertionSort(criaCopia(vetor));
		long tempoTrascorridoInsertion =(System.currentTimeMillis() - inicioInsertion);
		System.out.printf("O tempo do método InsertionSort foi de %.2f microsegundos\n", tempoTrascorridoInsertion*1000d);
		long inicioHeap = System.currentTimeMillis();
		HeapSort(criaCopia(vetor));
		long tempoTrascorridoHeap =(System.currentTimeMillis() - inicioHeap);
		System.out.printf("O tempo do método HeapSort foi de %.2f microsegundos\n", tempoTrascorridoHeap*1000d);
		long inicioMerge = System.currentTimeMillis();
		MergeSort(0,vetor.length-1, criaCopia(vetor));
		long tempoTrascorridoMerge =(System.currentTimeMillis() - inicioMerge);
		System.out.printf("O tempo do método MergeSort foi de %.2f microsegundos\n", tempoTrascorridoMerge*1000d);
		long inicioQuick = System.currentTimeMillis();
		QuickSort(0,vetor.length-1, criaCopia(vetor));
		long tempoTrascorridoQuick =(System.currentTimeMillis() - inicioQuick);
		System.out.printf("O tempo do método QuickSort foi de %.2f microsegundos\n", tempoTrascorridoQuick*1000d);
	}

}
