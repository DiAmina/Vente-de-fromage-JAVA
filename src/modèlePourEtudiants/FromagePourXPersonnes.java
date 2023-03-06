package modèlePourEtudiants;

public class FromagePourXPersonnes extends Fromage {

	public FromagePourXPersonnes(String désignation) {
		super(désignation);
	}
	
	public String toString2() {
		return super.toString() + ", vendu par nombre de personnes";
	}

}
