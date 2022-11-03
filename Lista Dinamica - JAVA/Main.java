package tads;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Lista pessoas = new Lista();//Cria uma lista chamada Pessoas;
		Scanner ent = new Scanner(System.in);
		Celula individuo;//Celula para inserção na lista.
		for(int i=0;i<4; i++) {//For para inserir individuos(Celulas) em pessoas(Lista)
			individuo = new Celula();
			System.out.print("Nome: ");
			individuo.nome = ent.nextLine();
			System.out.print("Idade: ");
			individuo.idade = ent.nextInt();
			pessoas.inserirInicio(individuo);
			ent.nextLine();
		}
		ent.close();
		pessoas.tamanhoAtual();
		pessoas.mostrar();
		System.out.println("Iterativo--->A media das idades é "+pessoas.mediaIdadesIter());//Media iterativa
		System.out.println("Recursivo--->A media das idades é "+pessoas.mediaRec());//Media recursiva
		while(pessoas.isEmpty()) {pessoas.removerInicio();}//isEmpty retorna true quando está vazia
		
	}

}
