package listaClassEHeranca;

public class principal {

	public static void main(String[] args) {
		Homem[] homens = new Homem[5];
			homens[0] = new Homem("Jose");
			homens[1] = new Homem("Antonio");
			homens[2] = new Homem("Ricardo");
			homens[3] = new Homem("Bruno");
			homens[4] = new Homem("Pedro");
		
		cao[] caes ={
			new cao("Snoopy"),
			new cao("Bolinha"),
			new cao("Lulu"),
			new cao("Bela"),
			new cao("Apolo")
		};
		gato[] gatos = {
			new gato("Bolacha"),
			new gato("Pateta"),
			new gato("Pipoca"),
			new gato("Kiara"),
			new gato("Pelucia")
		};
		for(int i=0; i<5;i++) {
			System.out.println(homens[i].getNome()+":"+homens[i].getFala());
			System.out.println(caes[i].getNome()+":"+caes[i].getFala());
			System.out.println(gatos[i].getNome()+":"+gatos[i].getFala());
		}
		
	}

}
