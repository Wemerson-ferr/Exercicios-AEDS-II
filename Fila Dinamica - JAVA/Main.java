package filadinamica;

public class Main {

	public static void main(String[] args) throws Exception {
//		Fila x = new Fila();
//		x.queue(1);
//		x.mostrar();
//		x.queue(5);
//		x.queue(7);
//		x.queue(2);
//		x.queue(-9);
//		x.queue(23);
//		x.queue(50);
//		System.out.printf("Fila de 1 5 7\n");
//		x.mostrar();
//		int value = x.getMaior();
//		System.out.println("O maior valor é "+value);
//		System.out.println("O soma dos elementos é: "+x.somaElementos());
//		int qualquer = x.removeFim();
//		System.out.println("ultimo Elemento:"+ qualquer);
//		x.mostrar();
		ListaIsa lista = new ListaIsa();
		lista.insereI(1);
		lista.insereI(2);
		lista.insereI(3);
		lista.insereP(2, 50);
		lista.mostra();
	}

}
