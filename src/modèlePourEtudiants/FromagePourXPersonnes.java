package mod�lePourEtudiants;

public class FromagePourXPersonnes extends Fromage {

	public FromagePourXPersonnes(String d�signation) {
		super(d�signation);
	}
	
	public String toString2() {
		return super.toString() + ", vendu par nombre de personnes";
	}

}
