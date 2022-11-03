package sorts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {
//-----------------> Metodos gerais imprime, swap, leitura e copia <----------------------------//	
	static void imprime(String[] x) {
			for(int i=0; i<x.length; i++) {
				System.out.println(x[i]);
			}
		}
	static void swap(int i, int j, String[]Y) {
			String aux = Y[i];
			Y[i] = Y[j];
			Y[j] = aux;
		}
	static String[] leitura()throws FileNotFoundException {
		String[] nomes;
		File arquivo = new File("D:\\eclipse-workspace\\TesteDeClasseOrdenação\\src\\sorts\\nomes.txt");
		Scanner ler = new Scanner(arquivo);
		int i=0;
		while(ler.hasNextLine()) {
				i++;
				ler.nextLine();
		}
		File arquivoR = new File("D:\\eclipse-workspace\\TesteDeClasseOrdenação\\src\\sorts\\nomes.txt");
		Scanner reler = new Scanner(arquivoR);
		nomes = new String[i];
		i=0;
		while(reler.hasNextLine()) {
			nomes[i] = reler.nextLine();
			i++;
		}
		reler.close();
		ler.close();
		return nomes;
	}
	static String[] criaCopia(String[] nomesCopia, String[]nomes) {
		for(int i=0; i<nomesCopia.length; i++) {
			nomesCopia[i] = nomes[i];
		}
		return nomesCopia;
	}
	
	public static void BubbleSort(String [] x) {
		for(int i = x.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(x[j].compareToIgnoreCase(x[j+1])>0) {
					swap(j, j+1, x);
				}
			}
		}
	}
	static void SelectionSort(String[]selection) {
		for(int i=0; i<selection.length-1;i++) {
			int menor =i;
			for(int j=i+1;j<selection.length;j++) {
				if(selection[menor].compareToIgnoreCase(selection[j])>0) {
					menor = j;
				}
			}
			if(i!=menor) {
				swap(menor, i, selection);
			}
		}
	}
	static void InsertionSort(String[]insertion) {
		for(int i=1; i<insertion.length;i++) {
			String tmp = insertion[i];
			int j = i-1;
			while((j>=0)&&(insertion[j].compareToIgnoreCase(tmp)>0)) {
				insertion[j+1] = insertion[j];
				j--;
			}
			insertion[j+1] = tmp;
		}
	} 	
//-----------------> Metodos isolados do Heap - Inicio <----------------------------------------//	
	static void HeapSort(String[] heap) {
		String[] heaper = new String[heap.length+1];
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
	static void construir(int tam, String[]heaper) {
		for(int i=tam;i>1 &&(heaper[i].compareToIgnoreCase(heaper[i/2])>0);i/=2) {
			swap(i,i/2,heaper);
		}
	}
	static void reconstroi(int tam, String[]heaper) {
		int i=1;
		//verifica se tem filho
		while(hasFilho(i,tam)) {
			int filho = maiorFilho(i, tam, heaper);
			if (heaper[i].compareToIgnoreCase(heaper[filho])<0)
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
	static int maiorFilho(int i, int tam, String[]heaper) {
		int retornaMaior;
		if((2*i==tam)||(heaper[(2*i)+1].compareToIgnoreCase(heaper[2*i])<0))
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
	static void MergeSort(int esq, int dir, String[]merge) {
		 if (esq < dir){
			 int meio = (esq + dir) / 2;
			 MergeSort(esq, meio, merge);
			 MergeSort(meio + 1, dir, merge);
			 intercalar(esq, meio, dir, merge);
		 }
	}
	static void intercalar(int esq, int meio, int dir, String[]merge){
		 //Definir tamanho dos dois subarrays
		 int nEsq = (meio+1)-esq;
		 int nDir = dir - meio;
		 String[] arrayEsq = new String[nEsq+1];
		 String[] arrayDir = new String[nDir+1];
		 //Sentinela no final dos dois arrays
		 arrayEsq[nEsq] = arrayDir[nDir] = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
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
		 merge[i] = (arrayEsq[iEsq].compareToIgnoreCase(arrayDir[iDir])<=0) ? arrayEsq[iEsq++] : arrayDir[iDir++];
		 }
		}
//-----------------> Metodos isolados do Merge - Fim <------------------------------------------//
	static void QuickSort(int esq, int dir, String[]quick) {
		int i = esq, j = dir;
		String pivo = quick[(esq+dir)/2];
		while (i <= j){
		while (quick[i].compareToIgnoreCase(pivo)<0)
			{i++;}
		while (quick[j].compareToIgnoreCase(pivo)>0)
			{j--;}
		if (i <= j){
			swap(i, j, quick); i++; j--; }
		}
		if (esq < j) {
			QuickSort(esq, j, quick);}
		if (i < dir) {
			QuickSort(i, dir, quick);}
	}
//-----------------> Main <---------------------------------------------------------------------//
	public static void main(String[] args) throws FileNotFoundException {
		String[] nomes = leitura();
		String[] nomesCopia = new String[nomes.length];
		
//criaCopia(nomesCopia,nomes) subscreve o vetor nomesCopia com o original(nomes) em cada chamada;
		BubbleSort(criaCopia(nomesCopia,nomes));
		imprime(nomesCopia);
		System.out.println("---------------------------------------------");
		SelectionSort(criaCopia(nomesCopia,nomes));
		imprime(nomesCopia);
		System.out.println("---------------------------------------------");
		InsertionSort(criaCopia(nomesCopia, nomes));
		imprime(nomesCopia);
		System.out.println("---------------------------------------------");
		HeapSort(criaCopia(nomesCopia, nomes));
		imprime(nomesCopia);
		System.out.println("---------------------------------------------");
		MergeSort(0, nomesCopia.length-1, criaCopia(nomesCopia, nomes));
		imprime(nomesCopia);
		System.out.println("---------------------------------------------");
		QuickSort(0,nomesCopia.length-1,criaCopia(nomesCopia,nomes));
		imprime(nomesCopia);	
	}

}
