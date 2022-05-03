package controle;

import java.text.ParseException;
import java.util.ArrayList;

import visao.Pet;

public class PetProcess {
	public static ArrayList<Pet> pets = new ArrayList<>();
	
 public	static void carregarTestes() throws ParseException {
		pets = new ArrayList<>();
		pets.add(new Pet(1,"Cahorro","toto","tl",5,"20/03/2010","Tete","(12)9988-2233"));
		pets.add(new Pet(2,"Gato","mimi","tl",2,"20/03/2019","Tete","(12)9988-2233"));
		pets.add(new Pet(3,"Coelho","cloccloc","tl",3,"20/03/2020","Tete","(12)9988-2233"));
		pets.add(new Pet(4,"ariranha","win","tl",5,"20/03/2015","Tete","(12)9988-2233"));
	}

}
